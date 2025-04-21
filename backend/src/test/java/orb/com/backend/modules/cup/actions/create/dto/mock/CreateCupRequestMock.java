package orb.com.backend.modules.cup.actions.create.dto.mock;

import orb.com.backend.modules.cup.actions.create.dto.CreateCupRequest;
import orb.com.backend.modules.cup.models.enums.CupColorEnum;
import orb.com.backend.modules.cup.models.enums.CupModelEnum;

public class CreateCupRequestMock {

    CreateCupRequest createCupRequest;

    private CreateCupRequestMock() {
    }

    public static CreateCupRequestMock builder() {

        CreateCupRequestMock builder = new CreateCupRequestMock();

        builder.createCupRequest =
                new CreateCupRequest(
                        CupModelEnum.ONE,
                        CupColorEnum.BLACK
                );

        return builder;
    }

    public CreateCupRequest build() {
        return createCupRequest;
    }
}
