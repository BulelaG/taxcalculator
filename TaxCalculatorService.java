public class TaxCalculatorService {
    // Method to calculate tax obligation based on income and age group for 2024 tax year
    public static double calculateTax(double income, int ageGroup) {
        // Validate input income
        if (income <= 0) {
            throw new IllegalArgumentException("Income must be positive.");
        }

        // Get tax brackets and rates for 2024 tax year
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

        // Apply tax threshold based on age group
        double threshold = TaxRates.getTaxThreshold(ageGroup);
        if (income <= threshold) {
            tax = 0; // No tax if income is below the threshold
        }

        // Apply rebate based on age group
        double rebate = getRebateForAgeGroup(ageGroup);
        tax -= rebate;

        // Ensure tax is non-negative
        return Math.max(0, tax);
    }

    private static double getRebateForAgeGroup(int ageGroup) {
        switch (ageGroup) {
            case 1: // Under 65
                return 0; // No rebate for this group
            case 2: // 65 and older
                return 9444; // Secondary rebate
            case 3: // 75 and older
                return 3145; // Tertiary rebate
            default:
                throw new IllegalArgumentException("Invalid age group.");
        }
    }
}
