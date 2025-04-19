package orb.com.backend.modules.cup.models.enums;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Enum: CupModel")
public class CupModelEnumTest {

    @Test
    @DisplayName("Should contain the expected values with their correct properties")
    void shouldContainExpectedValuesWithCorrectProperties() {

        CupModelEnum[] expectedValues = {CupModelEnum.ONE};

        CupModelEnum[] actualValues = CupModelEnum.values();

        assertEquals(expectedValues.length, actualValues.length, "The number of enum values is incorrect.");

        for (CupModelEnum model : expectedValues) {
            assertNotNull(model, "The enum value should not be null.");
            assertEquals(3.14, model.getRadius(), "The radius of model ONE is incorrect.");
            assertEquals(750.00, model.getVolumeCapacity(), "The volume capacity of model ONE is incorrect.");
        }
    }

    @Test
    @DisplayName("Should ensure that enum values are unique")
    void shouldEnsureEnumValuesAreUnique() {

        CupModelEnum[] values = CupModelEnum.values();

        for (int i = 0; i < values.length; i++) {
            for (int j = i + 1; j < values.length; j++) {
                assertNotNull(values[i], "The enum value should not be null.");
                assertNotNull(values[j], "The enum value should not be null.");
                assertNotEquals(values[i], values[j], "The enum values should be unique.");
            }
        }
    }

    @Test
    @DisplayName("Should return the correct properties for each enum value")
    void shouldReturnCorrectPropertiesForEachValue() {

        CupModelEnum model = CupModelEnum.ONE;

        double radius = model.getRadius();
        double capacity = model.getVolumeCapacity();

        assertEquals(3.14, radius, "The radius of model ONE is incorrect.");
        assertEquals(750.00, capacity, "The volume capacity of model ONE is incorrect.");
    }
}
