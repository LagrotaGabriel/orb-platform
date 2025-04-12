package orb.com.backend.modules.cup.actions.read.details.controller.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import orb.com.backend.modules.cup.actions.read.details.controller.GetCupDetailsSwagger;
import orb.com.backend.modules.cup.actions.read.details.service.GetCupDetailsService;
import orb.com.backend.modules.cup.models.dto.CupResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@Slf4j
@RestController
@RequiredArgsConstructor
public class GetCupDetailsController implements GetCupDetailsSwagger {

    private final GetCupDetailsService getCupDetailsService;

    @Override
    public ResponseEntity<CupResponse> getCupDetails(UUID id) {

        log.info("Endpoint responsible for retrieving cup details accessed");
        return ResponseEntity.status(HttpStatus.OK).body(
                getCupDetailsService.getCupDetails(
                        id
                )
        );
    }
}
