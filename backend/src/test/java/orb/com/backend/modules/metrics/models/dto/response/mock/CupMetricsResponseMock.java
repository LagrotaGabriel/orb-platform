package orb.com.backend.modules.metrics.models.dto.response.mock;

import orb.com.backend.modules.metrics.models.dto.response.CupMetricsResponse;

import java.time.LocalDateTime;
import java.util.UUID;

public class CupMetricsResponseMock {

    CupMetricsResponse cupMetricsResponse;

    private CupMetricsResponseMock() {
    }

    public static CupMetricsResponseMock builder() {

        CupMetricsResponseMock builder = new CupMetricsResponseMock();

        builder.cupMetricsResponse =
                new CupMetricsResponse(
                        UUID.fromString("bcdc5961-b48b-424f-8958-746713fffc92"),
                        LocalDateTime.of(2025, 2, 5, 11, 53, 0),
                        20.0,
                        200.0,
                        200.0,
                        100.0,
                        true
                );

        return builder;
    }

    public CupMetricsResponse build() {
        return cupMetricsResponse;
    }
}
