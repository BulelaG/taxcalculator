// TaxRates.java
public class TaxRates {
    // Method to get tax brackets
    public static double[] getTaxBrackets() {
        return new double[] { 0, 237100, 370500, 512800, 673000, 857900, 1817000 };
    }

    // Method to get tax rates
    public static double[] getTaxRates() {
        return new double[] { 0.18, 0.26, 0.31, 0.36, 0.39, 0.41, 0.45 };
    }

    // Method to get tax rebates
    public static double[] getTaxRebates() {
        return new double[] { 17235, 9444, 3145 };
    }

    // Method to get tax thresholds
    public static double[] getTaxThresholds() {
        return new double[] { 95750, 148217, 165689 };
    }
}
