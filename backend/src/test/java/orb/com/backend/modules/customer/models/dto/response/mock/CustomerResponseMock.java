package orb.com.backend.modules.customer.models.dto.response.mock;

import orb.com.backend.modules.customer.models.dto.response.CustomerResponse;

import java.util.UUID;

public class CustomerResponseMock {

    CustomerResponse customerResponse;

    private CustomerResponseMock() {
    }

    public static CustomerResponseMock builder() {

        CustomerResponseMock builder = new CustomerResponseMock();

        builder.customerResponse =
                new CustomerResponse(
                        UUID.fromString("bcdc5961-b48b-424f-8958-746713fffc92"),
                        "Gabriel Lagrota",
                        "gabriellagrota@gmail.com"
                );

        return builder;
    }

    public CustomerResponse build() {
        return customerResponse;
    }
}
