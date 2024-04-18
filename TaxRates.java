// TaxRates.java
public class TaxRates {
    // Method to get tax brackets for 2024 tax year
    public static double[] getTaxBrackets() {
        return new double[] { 0, 237100, 370500, 512800, 673000, 857900, 1817000 };
    }

    // Method to get tax rates for 2024 tax year
    public static double[] getTaxRates() {
        return new double[] { 0.18, 0.26, 0.31, 0.36, 0.39, 0.41, 0.45 };
    }

    // Method to get tax rebates for 2024 tax year
    public static double[] getTaxRebates() {
        return new double[] { 17235, 9444, 3145 }; // Primary, Secondary, Tertiary rebates
    }

    // Method to get tax thresholds based on age group for 2024 tax year
    public static double getTaxThreshold(int ageGroup) {
        switch (ageGroup) {
            case 1: // Under 65
                return 95750;
            case 2: // 65 and older
                return 148217;
            case 3: // 75 and older
                return 165689;
            default:
                throw new IllegalArgumentException("Invalid age group.");
        }
    }
}
