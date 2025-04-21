package orb.com.backend.modules.cup.actions.create.service.impl;

import orb.com.backend.modules.cup.actions.create.dto.CreateCupRequest;
import orb.com.backend.modules.cup.actions.create.dto.mock.CreateCupRequestMock;
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

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@DisplayName("Service: CreateCup")
class CreateCupServiceImplTest {

    @InjectMocks
    CreateCupServiceImpl createCupService;

    @Mock
    CupRepository cupRepository;

    @Test
    @DisplayName("Should create cup successfully")
    void shouldCreateCupSuccessfully() {

        CupEntity mockCreatedCup = CupEntityMock.builder().build();
        CreateCupRequest mockCupRequest = CreateCupRequestMock.builder().build();

        when(cupRepository.save(any())).thenReturn(mockCreatedCup);

        Assertions.assertDoesNotThrow(
                () -> createCupService.create(
                        mockCupRequest
                )
        );

        verify(
                cupRepository,
                times(1)).save(any(CupEntity.class)
        );
    }

    @Test
    @DisplayName("Should throw exception when cup email already exists")
    void shouldThrowExceptionWhenCupCreationFails() {

        CreateCupRequest createCupRequest = CreateCupRequestMock.builder().build();

        when(cupRepository.save(any())).thenThrow(new RuntimeException("Mock error"));

        Assertions.assertThrows(
                RuntimeException.class,
                () -> createCupService.create(
                        createCupRequest
                )
        );

        verify(
                cupRepository,
                times(1)).save(any(CupEntity.class)
        );
    }
}
