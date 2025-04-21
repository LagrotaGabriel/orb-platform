package orb.com.backend.modules.customer.actions.login.dto.request;

import orb.com.backend.modules.customer.actions.login.dto.request.mock.CustomerLoginRequestMock;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;

@DisplayName("Request: CustomerLogin")
class CustomerLoginRequestTest {

    @DisplayName("Should test mock object")
    void shouldTestMockObject() {

        CustomerLoginRequest customerLoginRequest = CustomerLoginRequestMock.builder().build();

        Assertions.assertEquals(
                "",
                customerLoginRequest.toString()
        );
    }
}
