package orb.com.backend.modules.customer.actions.create.dto.mock;

import orb.com.backend.modules.customer.actions.create.dto.CreateCustomerRequest;

public class CreateCustomerRequestMock {

    CreateCustomerRequest createCustomerRequest;

    private CreateCustomerRequestMock() {
    }

    public static CreateCustomerRequestMock builder() {

        CreateCustomerRequestMock builder = new CreateCustomerRequestMock();

        builder.createCustomerRequest =
                new CreateCustomerRequest(
                        "Gabriel",
                        "gabriel@gmail.com",
                        "123456"
                );

        return builder;
    }

    public CreateCustomerRequest build() {
        return createCustomerRequest;
    }
}