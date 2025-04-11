package orb.com.backend.modules.cup.actions.create.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.Parameter;
import jakarta.validation.constraints.NotNull;
import orb.com.backend.modules.cup.models.enums.CupColorEnum;
import orb.com.backend.modules.cup.models.enums.CupModelEnum;

public record CreateCupRequest(

        @JsonProperty("model")
        @NotNull(message = "Cup model cannot be null")
        @Parameter(name = "Cup model", example = "ONE", required = true)
        CupModelEnum model,

        @JsonProperty("color")
        @NotNull(message = "Cup color cannot be null")
        @Parameter(name = "Cup color", example = "RED", required = true)
        CupColorEnum color
) {
}
