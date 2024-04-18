// TaxCalculator.java
public class TaxCalculator {
    public static void main(String[] args) {
        // Get user input for income and age
        double income = UserInput.getIncome();
        int age = UserInput.getAge();

        // Calculate tax obligation
        double tax = TaxCalculatorService.calculateTax(income, age);

        // Display tax obligation
        System.out.println("Your tax obligation for the year is: R" + tax);
    }
}
