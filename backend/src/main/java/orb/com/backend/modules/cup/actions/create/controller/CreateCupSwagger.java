package orb.com.backend.modules.cup.actions.create.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import orb.com.backend.exceptions.models.StandardError;
import orb.com.backend.modules.cup.actions.create.dto.CreateCupRequest;
import orb.com.backend.modules.cup.models.dto.CupResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Tag(name = "Cup creation")
@RequestMapping("/api/v1/orb/cup")
public interface CreateCupSwagger {

    @PostMapping
    @Operation(summary = "Creates a new cup")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Cup created successfully",
                    content = {@Content(mediaType = "application/json", schema = @Schema(implementation = CupResponse.class))}),

            @ApiResponse(responseCode = "400", description = "Validation error in request data",
                    content = {@Content(mediaType = "application/json", schema = @Schema(implementation = StandardError.class))}),

            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = {@Content(mediaType = "application/json", schema = @Schema(implementation = StandardError.class))})
    })
    ResponseEntity<CupResponse> createNewCup(@Valid @RequestBody CreateCupRequest createCupRequest);
}
