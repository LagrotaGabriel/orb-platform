package orb.com.backend.modules.customer.repository;

import orb.com.backend.modules.customer.models.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CustomerRepository extends JpaRepository<CustomerEntity, UUID> {

    boolean existsByEmail(String email);
}