package orb.com.backend.aspects;

import orb.com.backend.modules.customer.actions.create.dto.CreateCustomerRequest;
import orb.com.backend.modules.customer.actions.create.service.business.impl.CreateCustomerServiceImpl;
import orb.com.backend.modules.customer.actions.create.service.validation.CreateCustomerValidationService;
import orb.com.backend.modules.customer.repository.CustomerRepository;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.reflect.MethodSignature;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.mockito.Mockito.when;

@DisplayName("Aspect: Logging")
@ExtendWith(MockitoExtension.class)
class LoggingAspectTest {

    @Mock
    private ProceedingJoinPoint joinPoint;

    @Mock
    private MethodSignature methodSignature;

    @InjectMocks
    private LoggingAspect loggingAspect;

    @BeforeEach
    void setUp() {
        when(joinPoint.getSignature()).thenReturn(methodSignature);
    }

    @Test
    void enteringMethodWithArgumentsLogsCorrectly() throws Throwable {

        when(methodSignature.getMethod()).thenReturn(
                CreateCustomerServiceImpl.class.getMethod(
                        "create",
                        CreateCustomerRequest.class
                )
        );

        when(joinPoint.getArgs()).thenReturn(new Object[]{"arg1"});

        when(joinPoint.getTarget()).thenReturn(
                new CreateCustomerServiceImpl(
                        Mockito.mock(CreateCustomerValidationService.class),
                        Mockito.mock(CustomerRepository.class),
                        Mockito.mock(PasswordEncoder.class)
                )
        );

        Assertions.assertDoesNotThrow(
                () -> loggingAspect.logMethodExecution(joinPoint)
        );
    }
}
