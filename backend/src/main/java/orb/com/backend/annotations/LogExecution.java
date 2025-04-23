package orb.com.backend.annotations;

import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.TYPE})
public @interface LogExecution {

    boolean logArguments() default true;
    boolean logReturnValue() default true;
    boolean trackExecutionTime() default true;
    LogLevel level() default LogLevel.INFO;

    enum LogLevel {
        TRACE, DEBUG, INFO, WARN, ERROR
    }
}
