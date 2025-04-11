package orb.com.backend.modules.cup.actions.create.controller.impl;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import orb.com.backend.modules.cup.actions.create.controller.CreateCupSwagger;
import orb.com.backend.modules.cup.actions.create.dto.CreateCupRequest;
import orb.com.backend.modules.cup.actions.create.service.CreateCupService;
import orb.com.backend.modules.cup.models.dto.CupResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class CreateCupController implements CreateCupSwagger {

    private final CreateCupService createCupService;

    @Override
    public ResponseEntity<CupResponse> createNewCup(@Valid @RequestBody CreateCupRequest createCupRequest) {

        log.info("Endpoint responsible for creating a new cup accessed");
        return ResponseEntity.status(HttpStatus.CREATED).body(
                createCupService.create(
                        createCupRequest
                )
        );
    }
}
