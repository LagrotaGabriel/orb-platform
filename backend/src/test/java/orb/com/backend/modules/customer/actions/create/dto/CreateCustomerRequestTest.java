package orb.com.backend.modules.customer.actions.create.dto;

import orb.com.backend.modules.customer.actions.create.dto.mock.CreateCustomerRequestMock;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Request: CreateCustomer")
class CreateCustomerRequestTest {

    @Test
    @DisplayName("Should test mock object")
    void shouldTestMockObject() {

        CreateCustomerRequest createCustomerRequest = CreateCustomerRequestMock.builder().build();

        Assertions.assertEquals(
                "CreateCustomerRequest[name=Gabriel, email=gabriel@gmail.com, " +
                        "password=123456]",
                createCustomerRequest.toString()
        );
    }
}