package orb.com.backend.exceptions.models;

import orb.com.backend.exceptions.models.mock.StandardErrorMock;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
@DisplayName("Exception: StandartError")
class StandardErrorTest {

    @Test
    @DisplayName("Deve testar mock")
    void deveTestarMock() {

        StandardError standardError = StandardErrorMock.builder().build();

        Assertions.assertEquals(
                "StandardError(localDateTime=2021-10-01T10:00, status=400, error=Bad Request, path=/api/v1/petshop/colaborador)",
                standardError.toString()
        );
    }
}
