package orb.com.backend.modules.customer.models.entity;

import orb.com.backend.modules.customer.models.entity.mock.CustomerEntityMock;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@DisplayName("Entity: Customer")
class CustomerEntityTest {

    @Test
    @DisplayName("Should test mock object")
    void shouldTestMockObject() {

        CustomerEntity customerEntity = CustomerEntityMock.builder().build();

        Assertions.assertNotNull(
                customerEntity
        );
    }

    @Test
    @DisplayName("Should test AllArgsConstructor")
    void shouldTestAllArgsConstructor() {

        CustomerEntity customerEntity = new CustomerEntity(
                "Gabriel Lagrota",
                "gabriel@gmail.com",
                new BCryptPasswordEncoder().encode("123456")
        );

        Assertions.assertNotNull(customerEntity.toString());
    }
}
