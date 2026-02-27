import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PackageSorterTest {

    // STANDARD cases
    @Test
    void shouldReturnStandardWhenNotBulkyAndNotHeavy() {
        String result = PackageSorter.sort(50, 50, 50, 10);
        assertEquals("STANDARD", result);
    }

    // BULKY due to dimension
    @Test
    void shouldReturnSpecialWhenDimensionExceedsThreshold() {
        String result = PackageSorter.sort(150, 50, 50, 10);
        assertEquals("SPECIAL", result);
    }

    // BULKY due to volume
    @Test
    void shouldReturnSpecialWhenVolumeExceedsThreshold() {
        String result = PackageSorter.sort(100, 100, 100, 10); // 1,000,000 cm³
        assertEquals("SPECIAL", result);
    }

    // HEAVY case
    @Test
    void shouldReturnSpecialWhenHeavyOnly() {
        String result = PackageSorter.sort(50, 50, 50, 20);
        assertEquals("SPECIAL", result);
    }

    // REJECTED case
    @Test
    void shouldReturnRejectedWhenBulkyAndHeavy() {
        String result = PackageSorter.sort(200, 200, 200, 25);
        assertEquals("REJECTED", result);
    }

    // Boundary tests
    @Test
    void shouldTreatExactThresholdDimensionAsBulky() {
        String result = PackageSorter.sort(150, 10, 10, 5);
        assertEquals("SPECIAL", result);
    }

    @Test
    void shouldTreatExactThresholdMassAsHeavy() {
        String result = PackageSorter.sort(10, 10, 10, 20);
        assertEquals("SPECIAL", result);
    }

    // Invalid input
    @Test
    void shouldThrowExceptionForInvalidInput() {
        assertThrows(IllegalArgumentException.class, () -> {
            PackageSorter.sort(-1, 10, 10, 10);
        });
    }
}
