package orb.com.backend.modules.cup.actions.create.dto;

import orb.com.backend.modules.cup.actions.create.dto.mock.CreateCupRequestMock;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Request: CreateCup")
class CreateCupRequestTest {

    @Test
    @DisplayName("Should test mock object")
    void shouldTestMockObject() {

        CreateCupRequest createCupRequest = CreateCupRequestMock.builder().build();

        Assertions.assertEquals(
                "CreateCupRequest[model=ONE, color=BLACK]",
                createCupRequest.toString()
        );
    }
}
