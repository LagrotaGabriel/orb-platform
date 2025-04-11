package orb.com.backend.exceptions.models;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder
@ToString
public class StandardError {

    private String localDateTime;
    private Integer status;
    private String error;
    private String path;
}
