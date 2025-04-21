package orb.com.backend.modules.customer.models.dto.response;

import orb.com.backend.modules.customer.models.dto.response.mock.CustomerResponseMock;
import orb.com.backend.modules.customer.models.entity.mock.CustomerEntityMock;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Response: Customer")
class CustomerResponseTest {

    @Test
    @DisplayName("Should test mock object")
    void shouldTestMockObject() {

        CustomerResponse customerResponse = CustomerResponseMock.builder().build();

        Assertions.assertEquals(
                "CustomerResponse[id=bcdc5961-b48b-424f-8958-746713fffc92, " +
                        "name=Gabriel Lagrota, email=gabriellagrota@gmail.com]",
                customerResponse.toString()
        );
    }

    @Test
    @DisplayName("Should test createFromEntity method without metrics")
    void shouldTestCreateFromEntityMethodWithoutMetrics() {

        CustomerResponse customerResponse = CustomerResponse.createFromEntity(
                CustomerEntityMock.builder().build()
        );

        Assertions.assertEquals(
                "CustomerResponse[id=bcdc5961-b48b-424f-8958-746713fffc92, " +
                        "name=Gabriel Lagrota, email=gabriel@gmail.com]",
                customerResponse.toString()
        );
    }

    @Test
    @DisplayName("Should test createFromEntity method with metrics")
    void shouldTestCreateFromEntityMethodWithMetrics() {

        CustomerResponse customerResponse = CustomerResponse.createFromEntity(
                CustomerEntityMock.builder().build()
        );

        Assertions.assertEquals(
                "CustomerResponse[id=bcdc5961-b48b-424f-8958-746713fffc92, " +
                        "name=Gabriel Lagrota, email=gabriel@gmail.com]",
                customerResponse.toString()
        );
    }
}
