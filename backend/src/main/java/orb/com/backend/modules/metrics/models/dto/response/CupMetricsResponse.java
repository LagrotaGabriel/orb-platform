package orb.com.backend.modules.metrics.models.dto.response;

import orb.com.backend.modules.metrics.models.entity.CupMetricsEntity;

import java.time.LocalDateTime;
import java.util.UUID;

public record CupMetricsResponse(
        UUID id,
        LocalDateTime syncDateTime,
        Double temperature,
        Double actualVolume,
        Double remainingVolume,
        Double batteryPercentage,
        boolean isClosed
) {
    public static CupMetricsResponse createFromEntity(CupMetricsEntity cupMetricsEntity) {
        return new CupMetricsResponse(
                cupMetricsEntity.getId(),
                cupMetricsEntity.getSyncDateTime(),
                cupMetricsEntity.getTemperature(),
                cupMetricsEntity.getActualVolume(),
                cupMetricsEntity.getRemainingVolume(),
                cupMetricsEntity.getBatteryPercentage(),
                cupMetricsEntity.isClosed()
        );
    }
}
