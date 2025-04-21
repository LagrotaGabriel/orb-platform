package orb.com.backend.modules.customer.actions.login.dto.response;

import orb.com.backend.modules.customer.actions.login.dto.response.mock.CustomerLoginResponseMock;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;

@DisplayName("Response: CustomerLogin")
class CustomerLoginResponseTest {

    @DisplayName("Should test mock object")
    void shouldTestMockObject() {

        CustomerLoginResponse customerLoginResponse = CustomerLoginResponseMock.builder().build();

        Assertions.assertEquals(
                "CustomerLoginResponse[loginDateTime=2025-02-05T11:53, sessionEndDateTime=2125-02-05T11:53, jwtToken=123456]",
                customerLoginResponse.toString()
        );
    }
}
