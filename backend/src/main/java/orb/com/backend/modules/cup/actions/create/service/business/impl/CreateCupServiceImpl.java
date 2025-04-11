package orb.com.backend.modules.cup.actions.create.service.business.impl;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import orb.com.backend.modules.cup.actions.create.dto.request.CreateCupRequest;
import orb.com.backend.modules.cup.actions.create.dto.response.CreateCupResponse;
import orb.com.backend.modules.cup.actions.create.service.business.CreateCupService;
import orb.com.backend.modules.cup.models.entity.CupEntity;
import orb.com.backend.modules.cup.repository.CupRepository;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class CreateCupServiceImpl implements CreateCupService {

    private final CupRepository cupRepository;

    @Override
    @Transactional
    public CreateCupResponse create(CreateCupRequest request) {

        CupEntity cupEntity = new CupEntity(request.model(), request.color());

        try {
            CupEntity savedCup = cupRepository.save(cupEntity);
            log.info("Cup created successfully. Id: {}", savedCup.getId());

            return CreateCupResponse.createFromEntity(savedCup);

        } catch (DataIntegrityViolationException dataIntegrityViolationException) {
            log.error("Data integrity violation occurred while creating a new cup: {}", dataIntegrityViolationException.getMessage());
            throw new InternalError("An error occurred while creating a new cup");
        } catch (Exception exception) {
            log.error("An unexpected error occurred while creating a new cup: {}", exception.getMessage());
            throw new InternalError("An unexpected error occurred while creating a new cup");
        }
    }
}
