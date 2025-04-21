package orb.com.backend.modules.customer.actions.login.dto.response.mock;

import orb.com.backend.modules.customer.actions.login.dto.response.CustomerLoginResponse;

import java.time.LocalDateTime;
import java.util.Date;

public class CustomerLoginResponseMock {

    private CustomerLoginResponse customerLoginResponse;

    private CustomerLoginResponseMock() {
    }

    public static CustomerLoginResponseMock builder() {

        CustomerLoginResponseMock builder = new CustomerLoginResponseMock();

        builder.customerLoginResponse =
                new CustomerLoginResponse(
                        Date.from(LocalDateTime.of(2025, 2, 5, 11, 53, 0).atZone(java.time.ZoneId.systemDefault()).toInstant()),
                        Date.from(LocalDateTime.of(2125, 2, 5, 11, 53, 0).atZone(java.time.ZoneId.systemDefault()).toInstant()),
                        "123456"
                );

        return builder;
    }

    public CustomerLoginResponse build() {
        return customerLoginResponse;
    }
}
