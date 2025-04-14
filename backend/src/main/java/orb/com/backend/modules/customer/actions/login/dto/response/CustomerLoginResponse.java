package orb.com.backend.modules.customer.actions.login.dto.response;

import java.util.Date;

public record CustomerLoginResponse(
        Date loginDateTime,
        Date sessionEndDateTime,
        String jwtToken
) {
}
