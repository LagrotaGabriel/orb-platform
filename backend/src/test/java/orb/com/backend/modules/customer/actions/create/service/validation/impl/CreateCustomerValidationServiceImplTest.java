package orb.com.backend.modules.customer.actions.create.service.validation.impl;

import orb.com.backend.exceptions.models.DuplicateResourceException;
import orb.com.backend.modules.customer.repository.CustomerRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@DisplayName("Service: CreateCustomerValidation")
class CreateCustomerValidationServiceImplTest {

    @InjectMocks
    CreateCustomerValidationServiceImpl createCustomerValidationServiceImpl;

    @Mock
    CustomerRepository customerRepository;

    String mockMail;

    @BeforeEach
    void setUp() {
        this.mockMail = "gabriel@gmail.com";
    }

    @Test
    @DisplayName("Should test validation if customer email already exists with success")
    void shouldTestValidationIfCustomerEmailAlreadyExistsWithSuccess() {

        when(customerRepository.existsByEmail(mockMail)).thenReturn(false);

        Assertions.assertDoesNotThrow(() ->
                createCustomerValidationServiceImpl.validateIfCustomerEmailAlreadyExists(mockMail)
        );

        verify(customerRepository).existsByEmail(mockMail);
    }

    @Test
    @DisplayName("Should test validation if customer email already exists with error")
    void shouldTestValidationIfCustomerEmailAlreadyExistsWithError() {

        when(customerRepository.existsByEmail(mockMail)).thenReturn(true);

        Assertions.assertThrows(
                DuplicateResourceException.class,
                () -> createCustomerValidationServiceImpl.validateIfCustomerEmailAlreadyExists(mockMail)
        );

        verify(customerRepository).existsByEmail(mockMail);
    }
}
