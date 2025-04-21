package orb.com.backend.modules.metrics.models.entity.mock;

import orb.com.backend.modules.metrics.models.entity.CupMetricsEntity;

import java.time.LocalDateTime;
import java.util.UUID;

public class CupMetricsEntityMock {

    CupMetricsEntity cupMetricsEntity;

    private CupMetricsEntityMock() {
    }

    public static CupMetricsEntityMock builder() {

        CupMetricsEntityMock builder = new CupMetricsEntityMock();

        builder.cupMetricsEntity = new CupMetricsEntity();
        builder.cupMetricsEntity.setId(UUID.fromString("bcdc5961-b48b-424f-8958-746713fffc92"));
        builder.cupMetricsEntity.setSyncDateTime(LocalDateTime.of(2025, 4, 16, 15, 57, 0));
        builder.cupMetricsEntity.setTemperature(20.0);
        builder.cupMetricsEntity.setActualVolume(200.0);
        builder.cupMetricsEntity.setRemainingVolume(200.0);
        builder.cupMetricsEntity.setBatteryPercentage(100.0);
        builder.cupMetricsEntity.setClosed(true);

        return builder;
    }

    public CupMetricsEntity build() {
        return cupMetricsEntity;
    }
}
