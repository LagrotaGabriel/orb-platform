package orb.com.backend.modules.customer.actions.create.service.validation;

public interface CreateCustomerValidationService {

    void validateIfCustomerEmailAlreadyExists(String email);
}