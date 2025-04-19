package orb.com.backend.modules.metrics.models.entity;

import orb.com.backend.modules.metrics.models.entity.mock.CupMetricsEntityMock;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Entity: CupMetrics")
class CupMetricsEntityTest {

    @Test
    @DisplayName("Should test mock object")
    void shouldTestMockObject() {

        CupMetricsEntity cupMetricsEntity = CupMetricsEntityMock.builder().build();

        Assertions.assertEquals(
                "CupMetricsEntity(id=bcdc5961-b48b-424f-8958-746713fffc92, " +
                        "syncDateTime=2025-04-16T15:57, temperature=20.0, actualVolume=200.0, " +
                        "remainingVolume=200.0, batteryPercentage=100.0, isClosed=true)",
                cupMetricsEntity.toString()
        );
    }
}
