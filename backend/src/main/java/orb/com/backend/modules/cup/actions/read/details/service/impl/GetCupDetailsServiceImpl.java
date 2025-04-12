package orb.com.backend.modules.cup.actions.read.details.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import orb.com.backend.exceptions.models.EntityNotFoundException;
import orb.com.backend.modules.cup.actions.read.details.service.GetCupDetailsService;
import orb.com.backend.modules.cup.models.dto.CupResponse;
import orb.com.backend.modules.cup.models.entity.CupEntity;
import orb.com.backend.modules.cup.repository.CupRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class GetCupDetailsServiceImpl implements GetCupDetailsService {

    private final CupRepository cupRepository;

    @Override
    public CupResponse getCupDetails(UUID id) {

        CupEntity cupEntity = cupRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Cup not found with id: " + id));

        log.info("Cup details retrieved successfully. Id: {}", cupEntity.getId());
        return CupResponse.createFromEntity(cupEntity);
    }
}
