package orb.com.backend.modules.cup.models.enums;

import lombok.Getter;

@Getter
public enum CupModelEnum {

    ONE(3.14, 750.00);

    private final double radius;
    private final double volumeCapacity;

    CupModelEnum(double radius, double volumeCapacity) {
        this.radius = radius;
        this.volumeCapacity = volumeCapacity;
    }
}
