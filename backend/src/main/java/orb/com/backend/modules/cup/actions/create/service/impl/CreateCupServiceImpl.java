package orb.com.backend.modules.cup.actions.create.service.impl;


import lombok.RequiredArgsConstructor;
import orb.com.backend.annotations.LogExecution;
import orb.com.backend.modules.cup.actions.create.dto.CreateCupRequest;
import orb.com.backend.modules.cup.actions.create.service.CreateCupService;
import orb.com.backend.modules.cup.models.dto.CupResponse;
import orb.com.backend.modules.cup.models.entity.CupEntity;
import orb.com.backend.modules.cup.repository.CupRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@LogExecution
@RequiredArgsConstructor
public class CreateCupServiceImpl implements CreateCupService {

    private final CupRepository cupRepository;

    @Override
    @Transactional
    public CupResponse create(CreateCupRequest request) {

        CupEntity cupEntity = new CupEntity(request.model(), request.color());

        try {
            CupEntity savedCup = cupRepository.save(cupEntity);
            return CupResponse.createFromEntity(savedCup);

        } catch (Exception exception) {
            throw new RuntimeException("An unexpected error occurred while creating a new cup", exception);
        }
    }
}
