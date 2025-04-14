package orb.com.backend.modules.customer.actions.create.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.Parameter;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public record CreateCustomerRequest(

        @JsonProperty("name")
        @NotEmpty(message = "Customer name must be provided")
        @Parameter(name = "Customer name", example = "Gabriel Lagrota", required = true)
        @Size(max = 60, message = "Customer name must have a maximum of {max} characters")
        String name,

        @JsonProperty("email")
        @NotEmpty(message = "Customer email must be provided")
        @Parameter(name = "Customer email", example = "customermail@mail.com", required = true)
        @Size(max = 60, message = "Customer email must have a maximum of {max} characters")
        @Email(message = "Invalid customer email. Use a valid email pattern")
        String email,

        @JsonProperty("password")
        @NotEmpty(message = "Customer password must be provided")
        @Parameter(name = "Customer password", example = "Password123", required = true)
        @Size(max = 32, message = "Customer password must have a maximum of {max} characters")
        String password
) {
}
