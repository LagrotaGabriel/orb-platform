package orb.com.backend.modules.customer.actions.create.service.business;

import orb.com.backend.modules.customer.actions.create.dto.CreateCustomerRequest;
import orb.com.backend.modules.customer.models.dto.response.CustomerResponse;

public interface CreateCustomerService {

    CustomerResponse create(CreateCustomerRequest createCustomerRequest);
}
