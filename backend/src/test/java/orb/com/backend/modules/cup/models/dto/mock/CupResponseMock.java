package orb.com.backend.modules.cup.models.dto.mock;

import orb.com.backend.modules.cup.models.dto.CupResponse;
import orb.com.backend.modules.cup.models.enums.CupColorEnum;
import orb.com.backend.modules.cup.models.enums.CupModelEnum;

import java.time.LocalDateTime;
import java.util.UUID;

public class CupResponseMock {

    CupResponse cupResponse;

    private CupResponseMock() {
    }

    public static CupResponseMock builder() {

        CupResponseMock builder = new CupResponseMock();

        builder.cupResponse =
                new CupResponse(
                        UUID.fromString("bcdc5961-b48b-424f-8958-746713fffc92"),
                        LocalDateTime.of(2025, 2, 5, 11, 53, 0),
                        LocalDateTime.of(2025, 2, 5, 11, 53, 0),
                        true,
                        CupModelEnum.ONE,
                        CupColorEnum.BLACK,
                        null
                );

        return builder;
    }

    public CupResponse build() {
        return cupResponse;
    }
}
