package orb.com.backend.exceptions.models.mock;

import orb.com.backend.exceptions.models.StandardError;

import java.time.LocalDateTime;

public class StandardErrorMock {

    private StandardError standardError;

    private StandardErrorMock() {
    }

    public static StandardErrorMock builder() {

        StandardErrorMock builder = new StandardErrorMock();

        builder.standardError =
                StandardError.builder()
                        .localDateTime(String.valueOf(LocalDateTime.of(2021, 10, 1, 10, 0, 0)))
                        .status(400)
                        .error("Bad Request")
                        .path("/api/v1/petshop/colaborador")
                        .build();

        builder.standardError.setLocalDateTime(builder.standardError.getLocalDateTime());
        builder.standardError.setStatus(builder.standardError.getStatus());
        builder.standardError.setError(builder.standardError.getError());
        builder.standardError.setPath(builder.standardError.getPath());

        return builder;
    }

    public StandardError build() {
        return standardError;
    }
}