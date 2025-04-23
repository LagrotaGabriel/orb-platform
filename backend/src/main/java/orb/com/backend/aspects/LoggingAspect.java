package orb.com.backend.aspects;

import lombok.extern.slf4j.Slf4j;
import orb.com.backend.annotations.LogExecution;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.Arrays;

@Slf4j
@Aspect
@Component
public class LoggingAspect {

    @Around("@annotation(orb.com.backend.annotations.LogExecution) || @within(orb.com.backend.annotations.LogExecution)")
    public Object logMethodExecution(ProceedingJoinPoint joinPoint) throws Throwable {

        Method method = ((MethodSignature) joinPoint.getSignature()).getMethod();
        LogExecution annotation = method.getAnnotation(LogExecution.class);

        if (annotation == null) {
            annotation = joinPoint.getTarget().getClass().getAnnotation(LogExecution.class);
        }

        String methodName = joinPoint.getSignature().toShortString();
        Object[] args = joinPoint.getArgs();
        long start = System.currentTimeMillis();

        if (annotation.logArguments()) {
            logWithLevel(annotation.level(), "➡️ Entering {} with arguments: {}", methodName, Arrays.toString(args));
        } else {
            logWithLevel(annotation.level(), "➡️ Entering {}", methodName);
        }

        try {
            Object result = joinPoint.proceed();
            long duration = System.currentTimeMillis() - start;

            if (annotation.trackExecutionTime() && annotation.logReturnValue()) {
                logWithLevel(annotation.level(), "✅ Exiting {} | Duration: {}ms | Return: {}", methodName, duration, result);
            } else if (annotation.trackExecutionTime()) {
                logWithLevel(annotation.level(), "✅ Exiting {} | Duration: {}ms", methodName, duration);
            } else if (annotation.logReturnValue()) {
                logWithLevel(annotation.level(), "✅ Exiting {} | Return: {}", methodName, result);
            } else {
                logWithLevel(annotation.level(), "✅ Exiting {}", methodName);
            }

            return result;
        } catch (Throwable e) {
            log.error("❌ Exception in {} | Message: {}", methodName, e.getMessage());
            throw e;
        }
    }

    private void logWithLevel(LogExecution.LogLevel level, String message, Object... args) {
        switch (level) {
            case TRACE -> log.trace(message, args);
            case DEBUG -> log.debug(message, args);
            case INFO -> log.info(message, args);
            case WARN -> log.warn(message, args);
            case ERROR -> log.error(message, args);
        }
    }
}