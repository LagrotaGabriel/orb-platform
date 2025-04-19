package orb.com.backend.modules.metrics.models.dto.response;

import orb.com.backend.modules.metrics.models.dto.response.mock.CupMetricsResponseMock;
import orb.com.backend.modules.metrics.models.entity.mock.CupMetricsEntityMock;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Response: CupMetrics")
class CupMetricsResponseTest {

    @Test
    @DisplayName("Should test mock object")
    void shouldTestMockObject() {

        CupMetricsResponse cupMetricsResponse = CupMetricsResponseMock.builder().build();

        Assertions.assertEquals(
                "CupMetricsResponse[id=bcdc5961-b48b-424f-8958-746713fffc92, " +
                        "syncDateTime=2025-02-05T11:53, temperature=20.0, actualVolume=200.0, " +
                        "remainingVolume=200.0, batteryPercentage=100.0, isClosed=true]",
                cupMetricsResponse.toString()
        );
    }

    @Test
    @DisplayName("Should test createFromEntity method")
    void shouldTestCreateFromEntityMethod() {

        CupMetricsResponse cupMetricsResponse = CupMetricsResponse.createFromEntity(
                CupMetricsEntityMock.builder().build()
        );

        Assertions.assertEquals(
                "CupMetricsResponse[id=bcdc5961-b48b-424f-8958-746713fffc92, " +
                        "syncDateTime=2025-04-16T15:57, temperature=20.0, actualVolume=200.0, " +
                        "remainingVolume=200.0, batteryPercentage=100.0, isClosed=true]",
                cupMetricsResponse.toString()
        );
    }
}
