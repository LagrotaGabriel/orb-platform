package orb.com.backend.modules.cup.repository;

import orb.com.backend.modules.cup.models.entity.CupEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CupRepository extends JpaRepository<CupEntity, UUID> {
}
