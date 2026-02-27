public class PackageSorter {

    private static final long BULKY_VOLUME_THRESHOLD = 1_000_000L;
    private static final int BULKY_DIMENSION_THRESHOLD = 150;
    private static final int HEAVY_MASS_THRESHOLD = 20;

    /**
     * Sorts a package into the correct stack based on its dimensions and mass.
     *
     * @param width  Width in centimeters
     * @param height Height in centimeters
     * @param length Length in centimeters
     * @param mass   Mass in kilograms
     * @return "STANDARD", "SPECIAL", or "REJECTED"
     */
    public static String sort(int width, int height, int length, int mass) {

        // Basic input validation
        if (width <= 0 || height <= 0 || length <= 0 || mass <= 0) {
            throw new IllegalArgumentException("All dimensions and mass must be positive values.");
        }

        boolean isBulky = isBulky(width, height, length);
        boolean isHeavy = isHeavy(mass);

        if (isBulky && isHeavy) {
            return "REJECTED";
        }

        if (isBulky || isHeavy) {
            return "SPECIAL";
        }

        return "STANDARD";
    }

    private static boolean isBulky(int width, int height, int length) {
        long volume = (long) width * height * length;

        return volume >= BULKY_VOLUME_THRESHOLD
                || width >= BULKY_DIMENSION_THRESHOLD
                || height >= BULKY_DIMENSION_THRESHOLD
                || length >= BULKY_DIMENSION_THRESHOLD;
    }

    private static boolean isHeavy(int mass) {
        return mass >= HEAVY_MASS_THRESHOLD;
    }

    // Simple test harness
    public static void main(String[] args) {
        System.out.println(sort(50, 50, 50, 10));     // STANDARD
        System.out.println(sort(200, 50, 50, 10));    // SPECIAL (bulky dimension)
        System.out.println(sort(100, 100, 100, 10));  // SPECIAL (bulky volume)
        System.out.println(sort(50, 50, 50, 25));     // SPECIAL (heavy)
        System.out.println(sort(200, 200, 200, 25));  // REJECTED (bulky + heavy)
    }
}
