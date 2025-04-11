package orb.com.backend.modules.cup.actions.create.service.business;

import orb.com.backend.modules.cup.actions.create.dto.request.CreateCupRequest;
import orb.com.backend.modules.cup.actions.create.dto.response.CreateCupResponse;

public interface CreateCupService {
    CreateCupResponse create(CreateCupRequest request);
}
