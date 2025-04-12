package orb.com.backend.modules.cup.actions.read.details.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import orb.com.backend.exceptions.models.StandardError;
import orb.com.backend.modules.cup.models.dto.CupResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.UUID;

@Tag(name = "Get cup details")
@RequestMapping("/api/v1/orb/cup")
public interface GetCupDetailsSwagger {

    @GetMapping("/{id}")
    @Operation(summary = "Get cup details by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Cup details retrieved successfully",
                    content = {@Content(mediaType = "application/json", schema = @Schema(implementation = CupResponse.class))}),

            @ApiResponse(responseCode = "400", description = "Invalid cup ID format",
                    content = {@Content(mediaType = "application/json", schema = @Schema(implementation = StandardError.class))}),

            @ApiResponse(responseCode = "404", description = "Cup not found",
                    content = {@Content(mediaType = "application/json", schema = @Schema(implementation = StandardError.class))}),

            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = {@Content(mediaType = "application/json", schema = @Schema(implementation = StandardError.class))})
    })
    ResponseEntity<CupResponse> getCupDetails(@PathVariable("id") UUID id);
}