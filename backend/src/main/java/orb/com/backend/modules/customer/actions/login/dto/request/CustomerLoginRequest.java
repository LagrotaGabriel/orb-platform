package orb.com.backend.modules.customer.actions.login.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.Parameter;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public record CustomerLoginRequest(

        @JsonProperty("email")
        @NotEmpty(message = "Customer email is required for login")
        @Parameter(name = "Customer email", example = "customer@mail.com", required = true)
        @Size(max = 60, message = "Customer email must have a maximum of {max} characters")
        @Email(message = "Invalid customer email. Use a valid email pattern")
        String email,

        @JsonProperty("password")
        @NotEmpty(message = "Customer password is required for login")
        @Parameter(name = "Customer password", example = "password123", required = true)
        String password
) {
}
