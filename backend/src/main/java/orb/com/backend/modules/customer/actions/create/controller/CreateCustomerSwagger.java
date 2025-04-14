package orb.com.backend.modules.customer.actions.create.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import orb.com.backend.exceptions.models.StandardError;
import orb.com.backend.modules.customer.actions.create.dto.CreateCustomerRequest;
import orb.com.backend.modules.customer.models.dto.response.CustomerResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Tag(name = "Customer creation")
@RequestMapping("/api/v1/orb/customer")
public interface CreateCustomerSwagger {

    @PostMapping
    @Operation(summary = "Creates a new customer")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Customer created successfully",
                    content = {@Content(mediaType = "application/json", schema = @Schema(implementation = CustomerResponse.class))}),

            @ApiResponse(responseCode = "400", description = "Validation error in request data",
                    content = {@Content(mediaType = "application/json", schema = @Schema(implementation = StandardError.class))}),

            @ApiResponse(responseCode = "409", description = "Customer with the same mail already exists",
                    content = {@Content(mediaType = "application/json", schema = @Schema(implementation = StandardError.class))}),

            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = {@Content(mediaType = "application/json", schema = @Schema(implementation = StandardError.class))})
    })
    ResponseEntity<CustomerResponse> createNewCustomer(@Valid @RequestBody CreateCustomerRequest createCustomerRequest);
}
