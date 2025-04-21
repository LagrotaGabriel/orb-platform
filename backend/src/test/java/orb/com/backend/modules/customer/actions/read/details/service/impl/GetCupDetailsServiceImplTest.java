package orb.com.backend.modules.customer.actions.read.details.service.impl;

import orb.com.backend.modules.cup.actions.read.details.service.impl.GetCupDetailsServiceImpl;
import orb.com.backend.modules.cup.models.dto.CupResponse;
import orb.com.backend.modules.cup.models.entity.CupEntity;
import orb.com.backend.modules.cup.models.entity.mock.CupEntityMock;
import orb.com.backend.modules.cup.repository.CupRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;
import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@DisplayName("Service: GetCupDetails")
class GetCupDetailsServiceImplTest {

    @InjectMocks
    GetCupDetailsServiceImpl getCupDetailsServiceImpl;

    @Mock
    CupRepository cupRepository;

    @Test
    @DisplayName("Should get cup details by id successfully")
    void shouldGetCupDetailsByIdSuccessfully() {

        CupEntity cupEntityMock = CupEntityMock.builder().build();

        cupEntityMock.setId(UUID.randomUUID());
        when(cupRepository.findById(any(UUID.class))).thenReturn(Optional.of(cupEntityMock));

        CupResponse response = getCupDetailsServiceImpl.getCupDetails(cupEntityMock.getId());

        Assertions.assertNotNull(response);

        Assertions.assertEquals(
                cupEntityMock.getId(),
                response.id()
        );

        verify(cupRepository).findById(cupEntityMock.getId());
    }
}
