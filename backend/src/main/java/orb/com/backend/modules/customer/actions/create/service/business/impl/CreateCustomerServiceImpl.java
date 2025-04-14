package orb.com.backend.modules.customer.actions.create.service.business.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import orb.com.backend.modules.customer.actions.create.dto.CreateCustomerRequest;
import orb.com.backend.modules.customer.actions.create.service.business.CreateCustomerService;
import orb.com.backend.modules.customer.actions.create.service.validation.CreateCustomerValidationService;
import orb.com.backend.modules.customer.models.dto.response.CustomerResponse;
import orb.com.backend.modules.customer.models.entity.CustomerEntity;
import orb.com.backend.modules.customer.repository.CustomerRepository;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class CreateCustomerServiceImpl implements CreateCustomerService {

    private final CreateCustomerValidationService validationService;
    private final CustomerRepository customerRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public CustomerResponse create(CreateCustomerRequest createCustomerRequest) {

        validationService.validateIfCustomerEmailAlreadyExists(createCustomerRequest.email());

        String encodedPassword = passwordEncoder.encode(createCustomerRequest.password());

        CustomerEntity customerEntity =
                new CustomerEntity(
                        createCustomerRequest.name(),
                        createCustomerRequest.email(),
                        encodedPassword
                );

        try {
            CustomerEntity savedCustomer = customerRepository.save(customerEntity);
            log.info("Customer created successfully. Id: {}", savedCustomer.getId());
            return CustomerResponse.createFromEntity(savedCustomer);
        } catch (DataIntegrityViolationException dataIntegrityViolationException) {
            log.error("Data integrity violation occurred while creating a new customer: {}", dataIntegrityViolationException.getMessage());
            throw new InternalError("An error occurred while creating a new customer");
        } catch (Exception exception) {
            log.error("An unexpected error occurred while creating a new customer: {}", exception.getMessage());
            throw new InternalError("An unexpected error occurred while creating a new customer");
        }
    }
}