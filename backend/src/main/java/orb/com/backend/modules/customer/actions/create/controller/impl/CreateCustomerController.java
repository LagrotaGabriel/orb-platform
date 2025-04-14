package orb.com.backend.modules.customer.actions.create.controller.impl;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import orb.com.backend.modules.customer.actions.create.controller.CreateCustomerSwagger;
import orb.com.backend.modules.customer.actions.create.dto.CreateCustomerRequest;
import orb.com.backend.modules.customer.actions.create.service.business.CreateCustomerService;
import orb.com.backend.modules.customer.models.dto.response.CustomerResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class CreateCustomerController implements CreateCustomerSwagger {

    private final CreateCustomerService createCustomerService;

    @Override
    public ResponseEntity<CustomerResponse> createNewCustomer(@Valid @RequestBody CreateCustomerRequest createCustomerRequest) {

        log.info("Endpoint responsible for creating a new customer accessed");
        return ResponseEntity.status(HttpStatus.CREATED).body(
                createCustomerService.create(
                        createCustomerRequest
                )
        );
    }
}
