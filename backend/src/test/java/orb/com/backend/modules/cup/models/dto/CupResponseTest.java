package orb.com.backend.modules.cup.models.dto;

import orb.com.backend.modules.cup.models.dto.mock.CupResponseMock;
import orb.com.backend.modules.cup.models.entity.mock.CupEntityMock;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Response: Cup")
class CupResponseTest {

    @Test
    @DisplayName("Should test mock object")
    void shouldTestMockObject() {

        CupResponse cupResponse = CupResponseMock.builder().build();

        Assertions.assertEquals(
                "CupResponse[id=bcdc5961-b48b-424f-8958-746713fffc92, " +
                        "creationLocalDateTime=2025-02-05T11:53, lastSyncDateTime=2025-02-05T11:53, " +
                        "isActivated=true, model=ONE, color=BLACK, lastMetric=null]",
                cupResponse.toString()
        );
    }

    @Test
    @DisplayName("Should test createFromEntity method without metrics")
    void shouldTestCreateFromEntityMethodWithoutMetrics() {

        CupResponse cupResponse = CupResponse.createFromEntity(
                CupEntityMock.builder().build()
        );

        Assertions.assertEquals(
                "CupResponse[id=bcdc5961-b48b-424f-8958-746713fffc92, " +
                        "creationLocalDateTime=2025-04-16T15:57, lastSyncDateTime=2025-04-16T15:57, " +
                        "isActivated=true, model=ONE, color=BLACK, lastMetric=null]",
                cupResponse.toString()
        );
    }

    @Test
    @DisplayName("Should test createFromEntity method with metrics")
    void shouldTestCreateFromEntityMethodWithMetrics() {

        CupResponse cupResponse = CupResponse.createFromEntity(
                CupEntityMock.builder().withMetrics().build()
        );

        Assertions.assertEquals(
                "CupResponse[id=bcdc5961-b48b-424f-8958-746713fffc92, " +
                        "creationLocalDateTime=2025-04-16T15:57, lastSyncDateTime=2025-04-16T15:57, " +
                        "isActivated=true, model=ONE, color=BLACK, " +
                        "lastMetric=CupMetricsResponse[id=bcdc5961-b48b-424f-8958-746713fffc92, " +
                        "syncDateTime=2025-04-16T15:57, temperature=20.0, actualVolume=200.0, " +
                        "remainingVolume=200.0, batteryPercentage=100.0, isClosed=true]]",
                cupResponse.toString()
        );
    }
}
