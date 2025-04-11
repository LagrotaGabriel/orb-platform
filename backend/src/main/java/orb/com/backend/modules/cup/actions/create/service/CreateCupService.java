package orb.com.backend.modules.cup.actions.create.service;

import orb.com.backend.modules.cup.actions.create.dto.CreateCupRequest;
import orb.com.backend.modules.cup.models.dto.CupResponse;

public interface CreateCupService {
    CupResponse create(CreateCupRequest request);
}
