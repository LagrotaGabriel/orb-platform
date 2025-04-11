package orb.com.backend.modules.cup.models.dto;

import orb.com.backend.modules.cup.models.entity.CupEntity;
import orb.com.backend.modules.cup.models.enums.CupColorEnum;
import orb.com.backend.modules.cup.models.enums.CupModelEnum;

import java.time.LocalDateTime;
import java.util.UUID;

public record CupResponse(
        UUID id,
        LocalDateTime creationLocalDateTime,
        LocalDateTime lastSyncDateTime,
        boolean isActivated,
        CupModelEnum model,
        CupColorEnum color
) {
    public static CupResponse createFromEntity(CupEntity cupEntity) {
        return new CupResponse(
                cupEntity.getId(),
                cupEntity.getCreationLocalDateTime(),
                cupEntity.getLastSyncDateTime(),
                cupEntity.getIsActivated(),
                cupEntity.getModel(),
                cupEntity.getColor()
        );
    }
}
