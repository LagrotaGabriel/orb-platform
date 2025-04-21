package orb.com.backend.modules.customer.actions.create.controller.impl;

import orb.com.backend.modules.customer.actions.create.dto.CreateCustomerRequest;
import orb.com.backend.modules.customer.actions.create.dto.mock.CreateCustomerRequestMock;
import orb.com.backend.modules.customer.actions.create.service.business.CreateCustomerService;
import orb.com.backend.modules.customer.models.dto.response.CustomerResponse;
import orb.com.backend.modules.customer.models.dto.response.mock.CustomerResponseMock;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@DisplayName("Controller CreateCustomer")
class CreateCustomerControllerTest {

    @InjectMocks
    CreateCustomerController createCustomerController;

    @Mock
    CreateCustomerService createCustomerService;

    @Test
    @DisplayName("Should create customer successfully")
    void shouldCreateCustomerSuccessFully() {

        CustomerResponse expectedResponse = CustomerResponseMock.builder().build();
        CreateCustomerRequest createCustomerRequestMock = CreateCustomerRequestMock.builder().build();

        when(createCustomerService.create(any())).thenReturn(expectedResponse);

        ResponseEntity<CustomerResponse> controllerResponse =
                createCustomerController.createNewCustomer(
                        createCustomerRequestMock
                );

        Assertions.assertNotNull(controllerResponse);
        Assertions.assertNotNull(controllerResponse.getBody());

        Assertions.assertEquals(
                HttpStatus.CREATED,
                controllerResponse.getStatusCode()
        );

        Assertions.assertEquals(
                expectedResponse,
                controllerResponse.getBody()
        );
    }
}
