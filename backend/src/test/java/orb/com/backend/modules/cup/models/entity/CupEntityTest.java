package orb.com.backend.modules.cup.models.entity;

import orb.com.backend.modules.cup.models.entity.mock.CupEntityMock;
import orb.com.backend.modules.cup.models.enums.CupColorEnum;
import orb.com.backend.modules.cup.models.enums.CupModelEnum;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Entity: Cup")
public class CupEntityTest {

    @Test
    @DisplayName("Should test mock object")
    void shouldTestMockObject() {

        CupEntity cupEntity = CupEntityMock.builder().build();

        Assertions.assertEquals(
                "CupEntity(id=bcdc5961-b48b-424f-8958-746713fffc92, " +
                        "creationLocalDateTime=2025-04-16T15:57, lastSyncDateTime=2025-04-16T15:57, " +
                        "isActivated=true, model=ONE, color=BLACK, metrics=[])",
                cupEntity.toString()
        );
    }

    @Test
    @DisplayName("Should test AllArgsConstructor")
    void shouldTestAllArgsConstructor() {

        CupEntity cupEntity = new CupEntity(
                CupModelEnum.ONE,
                CupColorEnum.BLACK
        );

        Assertions.assertNotNull(cupEntity.toString());
    }
}