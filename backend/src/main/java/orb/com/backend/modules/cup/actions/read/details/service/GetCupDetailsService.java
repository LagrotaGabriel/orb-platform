package orb.com.backend.modules.cup.actions.read.details.service;

import orb.com.backend.modules.cup.models.dto.CupResponse;

import java.util.UUID;

public interface GetCupDetailsService {
    CupResponse getCupDetails(UUID id);
}
