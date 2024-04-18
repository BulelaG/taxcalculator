// TaxCalculatorService.java
public class TaxCalculatorService {
    // Method to calculate tax obligation based on income
    public static double calculateTax(double income) {
        // Validate input income
        if (income <= 0) {
            throw new IllegalArgumentException("Income must be positive.");
        }

        // Get tax brackets and rates
        double[] brackets = TaxRates.getTaxBrackets();
        double[] rates = TaxRates.getTaxRates();

        // Validate tax brackets and rates
        if (brackets.length != rates.length) {
            throw new IllegalStateException("Tax brackets and rates are not properly defined.");
        }

        // Calculate tax based on income
        double tax = 0;
        int i = 0;
        while (i < brackets.length && income > brackets[i]) {
            if (i == 0) {
                tax += rates[i] * Math.min(income, brackets[i + 1] - brackets[i]);
            } else {
                tax += rates[i] * Math.min(income - brackets[i - 1], brackets[i] - brackets[i - 1]);
            }
            i++;
        }
        if (income > brackets[brackets.length - 1]) {
            tax += rates[brackets.length - 1] * (income - brackets[brackets.length - 1]);
        }

        // Ensure tax is non-negative
        return Math.max(0, tax);
    }
}
