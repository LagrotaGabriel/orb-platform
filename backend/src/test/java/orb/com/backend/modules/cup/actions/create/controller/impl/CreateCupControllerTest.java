package orb.com.backend.modules.cup.actions.create.controller.impl;

import orb.com.backend.modules.cup.actions.create.dto.CreateCupRequest;
import orb.com.backend.modules.cup.actions.create.dto.mock.CreateCupRequestMock;
import orb.com.backend.modules.cup.actions.create.service.CreateCupService;
import orb.com.backend.modules.cup.models.dto.CupResponse;
import orb.com.backend.modules.cup.models.dto.mock.CupResponseMock;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@DisplayName("Controller: CreateCup")
class CreateCupControllerTest {

    @InjectMocks
    CreateCupController createCupController;

    @Mock
    CreateCupService createCupService;

    @Test
    @DisplayName("Should create cup successfully")
    void shouldCreateCupSuccessFully() {

        CupResponse expectedResponse = CupResponseMock.builder().build();
        CreateCupRequest createCupRequestMock = CreateCupRequestMock.builder().build();

        when(createCupService.create(any())).thenReturn(expectedResponse);

        ResponseEntity<CupResponse> controllerResponse =
                createCupController.createNewCup(
                        createCupRequestMock
                );

        Assertions.assertNotNull(controllerResponse);
        Assertions.assertNotNull(controllerResponse.getBody());

        Assertions.assertEquals(
                HttpStatus.CREATED,
                controllerResponse.getStatusCode()
        );

        Assertions.assertEquals(
                expectedResponse,
                controllerResponse.getBody()
        );
    }
}
