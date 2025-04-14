package orb.com.backend.modules.customer.models.dto.response;

import orb.com.backend.modules.customer.models.entity.CustomerEntity;

import java.util.UUID;

public record CustomerResponse(
        UUID id,
        String name,
        String email
) {
    public static CustomerResponse createFromEntity(CustomerEntity customerEntity) {
        return new CustomerResponse(
                customerEntity.getId(),
                customerEntity.getName(),
                customerEntity.getEmail()
        );
    }
}
