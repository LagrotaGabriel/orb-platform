package orb.com.backend.modules.cup.models.enums;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Enum: CupColor")
public class CupColorEnumTest {

    @Test
    @DisplayName("Should contain expected values")
    void shouldContainExpectedValues() {

        CupColorEnum[] expectedValues = {CupColorEnum.BLACK, CupColorEnum.WHITE, CupColorEnum.GREY, CupColorEnum.PINK};

        assertEquals(expectedValues.length, CupColorEnum.values().length, "The number of enum values is incorrect.");

        for (CupColorEnum color : expectedValues) {
            assertNotNull(color, "The enum value should not be null.");
        }
    }

    @Test
    @DisplayName("Should have unique values")
    void shouldHaveUniqueValues() {

        CupColorEnum[] values = CupColorEnum.values();
        for (int i = 0; i < values.length; i++) {
            for (int j = i + 1; j < values.length; j++) {
                assertNotNull(values[i], "The enum value should not be null.");
                assertNotNull(values[j], "The enum value should not be null.");
                assertNotEquals(values[i], values[j], "The enum values should be unique.");
            }
        }
    }
}
