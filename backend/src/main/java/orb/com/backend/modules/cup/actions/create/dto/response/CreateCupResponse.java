package orb.com.backend.modules.cup.actions.create.dto.response;

import orb.com.backend.modules.cup.models.entity.CupEntity;
import orb.com.backend.modules.cup.models.enums.CupColorEnum;
import orb.com.backend.modules.cup.models.enums.CupModelEnum;

import java.time.LocalDateTime;
import java.util.UUID;

public record CreateCupResponse(
        UUID id,
        LocalDateTime creationLocalDateTime,
        LocalDateTime lastSyncDateTime,
        boolean isActivated,
        CupModelEnum model,
        CupColorEnum color
) {
    public static CreateCupResponse createFromEntity(CupEntity cupEntity) {
        return new CreateCupResponse(
                cupEntity.getId(),
                cupEntity.getCreationLocalDateTime(),
                cupEntity.getLastSyncDateTime(),
                cupEntity.getIsActivated(),
                cupEntity.getModel(),
                cupEntity.getColor()
        );
    }
}
