package orb.com.backend.modules.customer.actions.login.dto.request.mock;

import orb.com.backend.modules.customer.actions.login.dto.request.CustomerLoginRequest;

public class CustomerLoginRequestMock {

    private CustomerLoginRequest customerLoginRequest;

    private CustomerLoginRequestMock() {
    }

    public static CustomerLoginRequestMock builder() {

        CustomerLoginRequestMock builder = new CustomerLoginRequestMock();

        builder.customerLoginRequest =
                new CustomerLoginRequest(
                        "gabriellagrota@gmail.com",
                        "123456"
                );

        return builder;
    }

    public CustomerLoginRequest build() {
        return customerLoginRequest;
    }
}
