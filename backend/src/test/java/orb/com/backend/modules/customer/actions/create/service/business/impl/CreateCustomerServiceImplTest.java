package orb.com.backend.modules.customer.actions.create.service.business.impl;

import orb.com.backend.modules.customer.actions.create.dto.CreateCustomerRequest;
import orb.com.backend.modules.customer.actions.create.dto.mock.CreateCustomerRequestMock;
import orb.com.backend.modules.customer.actions.create.service.validation.impl.CreateCustomerValidationServiceImpl;
import orb.com.backend.modules.customer.models.entity.CustomerEntity;
import orb.com.backend.modules.customer.models.entity.mock.CustomerEntityMock;
import orb.com.backend.modules.customer.repository.CustomerRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@DisplayName("Service: CreateCustomer")
class CreateCustomerServiceImplTest {

    @InjectMocks
    CreateCustomerServiceImpl createCustomerService;

    @Mock
    CreateCustomerValidationServiceImpl createCustomerValidationService;

    @Mock
    CustomerRepository customerRepository;

    @Mock
    PasswordEncoder passwordEncoder;

    @Test
    @DisplayName("Should create customer successfully")
    void shouldCreateCustomerSuccessfully() {

        CustomerEntity mockCreatedCustomer = CustomerEntityMock.builder().build();
        CreateCustomerRequest mockCustomerRequest = CreateCustomerRequestMock.builder().build();

        doNothing().when(createCustomerValidationService).validateIfCustomerEmailAlreadyExists(any());
        when(passwordEncoder.encode(any())).thenReturn("encodedPassword");
        when(customerRepository.save(any())).thenReturn(mockCreatedCustomer);

        Assertions.assertDoesNotThrow(
                () -> createCustomerService.create(
                        mockCustomerRequest
                )
        );

        verify(
                createCustomerValidationService,
                times(1)).validateIfCustomerEmailAlreadyExists(mockCustomerRequest.email()
        );

        verify(
                passwordEncoder,
                times(1)).encode(mockCustomerRequest.password()
        );

        verify(
                customerRepository,
                times(1)).save(any(CustomerEntity.class)
        );
    }

    @Test
    @DisplayName("Should throw exception when customer email already exists")
    void shouldThrowExceptionWhenCustomerCreationFails() {

        CreateCustomerRequest mockCustomerRequest = CreateCustomerRequestMock.builder().build();

        doNothing().when(createCustomerValidationService).validateIfCustomerEmailAlreadyExists(any());
        when(passwordEncoder.encode(any())).thenReturn("encodedPassword");
        when(customerRepository.save(any())).thenThrow(new RuntimeException("Mock error"));

        Assertions.assertThrows(
                RuntimeException.class,
                () -> createCustomerService.create(
                        mockCustomerRequest
                )
        );

        verify(
                createCustomerValidationService,
                times(1)).validateIfCustomerEmailAlreadyExists(mockCustomerRequest.email()
        );

        verify(
                passwordEncoder,
                times(1)).encode(mockCustomerRequest.password()
        );

        verify(
                customerRepository,
                times(1)).save(any(CustomerEntity.class)
        );
    }
}
