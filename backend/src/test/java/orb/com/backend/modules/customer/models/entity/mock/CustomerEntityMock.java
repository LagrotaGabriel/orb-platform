package orb.com.backend.modules.customer.models.entity.mock;

import orb.com.backend.modules.customer.models.entity.CustomerEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.time.LocalDateTime;
import java.util.UUID;

public class CustomerEntityMock {

    CustomerEntity customerEntity;

    private CustomerEntityMock() {
    }

    public static CustomerEntityMock builder() {

        CustomerEntityMock builder = new CustomerEntityMock();

        builder.customerEntity = new CustomerEntity();
        builder.customerEntity.setId(UUID.fromString("bcdc5961-b48b-424f-8958-746713fffc92"));
        builder.customerEntity.setCreationDateTime(LocalDateTime.of(2025, 4, 16, 15, 57, 0));
        builder.customerEntity.setName("Gabriel Lagrota");
        builder.customerEntity.setEmail("gabriel@gmail.com");
        builder.customerEntity.setPassword(new BCryptPasswordEncoder().encode("123456"));

        return builder;
    }

    public CustomerEntity build() {
        return customerEntity;
    }
}
