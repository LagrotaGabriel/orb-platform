package orb.com.backend.modules.cup.models.entity.mock;

import orb.com.backend.modules.cup.models.entity.CupEntity;
import orb.com.backend.modules.cup.models.enums.CupColorEnum;
import orb.com.backend.modules.cup.models.enums.CupModelEnum;
import orb.com.backend.modules.metrics.models.entity.mock.CupMetricsEntityMock;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.UUID;

public class CupEntityMock {

    CupEntity cupEntity;

    private CupEntityMock() {
    }

    public static CupEntityMock builder() {

        CupEntityMock builder = new CupEntityMock();

        builder.cupEntity = new CupEntity();
        builder.cupEntity.setId(UUID.fromString("bcdc5961-b48b-424f-8958-746713fffc92"));
        builder.cupEntity.setCreationLocalDateTime(LocalDateTime.of(2025, 4, 16, 15, 57, 0));
        builder.cupEntity.setLastSyncDateTime(LocalDateTime.of(2025, 4, 16, 15, 57, 0));
        builder.cupEntity.setIsActivated(true);
        builder.cupEntity.setModel(CupModelEnum.ONE);
        builder.cupEntity.setColor(CupColorEnum.BLACK);

        return builder;
    }

    public CupEntityMock withMetrics() {

        this.cupEntity.setMetrics(
                Collections.singletonList(CupMetricsEntityMock.builder().build())
        );

        return this;
    }

    public CupEntity build() {
        return cupEntity;
    }
}
