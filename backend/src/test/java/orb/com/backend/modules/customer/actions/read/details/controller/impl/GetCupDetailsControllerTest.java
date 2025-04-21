package orb.com.backend.modules.customer.actions.read.details.controller.impl;

import orb.com.backend.modules.cup.actions.read.details.controller.impl.GetCupDetailsController;
import orb.com.backend.modules.cup.actions.read.details.service.GetCupDetailsService;
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

import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@DisplayName("Controller: GetCupDetails")
class GetCupDetailsControllerTest {

    @InjectMocks
    GetCupDetailsController getCupDetailsController;

    @Mock
    GetCupDetailsService getCupDetailsService;

    @Test
    @DisplayName("Should get cup details by id successfully")
    void shouldGetCupDetailsByIdSuccessFully() {

        CupResponse expectedresponse = CupResponseMock.builder().build();
        UUID mockId = expectedresponse.id();

        when(getCupDetailsService.getCupDetails(any())).thenReturn(expectedresponse);

        ResponseEntity<CupResponse> controllerResponse =
                getCupDetailsController.getCupDetails(
                        mockId
                );

        Assertions.assertNotNull(controllerResponse);
        Assertions.assertNotNull(controllerResponse.getBody());

        Assertions.assertEquals(
                HttpStatus.OK,
                controllerResponse.getStatusCode()
        );

        Assertions.assertEquals(
                expectedresponse,
                controllerResponse.getBody()
        );
    }
}
