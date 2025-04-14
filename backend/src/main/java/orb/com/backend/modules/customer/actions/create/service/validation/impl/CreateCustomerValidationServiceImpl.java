package orb.com.backend.modules.customer.actions.create.service.validation.impl;

import lombok.RequiredArgsConstructor;
import orb.com.backend.exceptions.models.DuplicateResourceException;
import orb.com.backend.modules.customer.actions.create.service.validation.CreateCustomerValidationService;
import orb.com.backend.modules.customer.repository.CustomerRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateCustomerValidationServiceImpl implements CreateCustomerValidationService {

    private final CustomerRepository customerRepository;

    @Override
    public void validateIfCustomerEmailAlreadyExists(String email) {

        if (customerRepository.existsByEmail(email)) {
            throw new DuplicateResourceException("Customer with email " + email + " already exists.");
        }
    }
}
