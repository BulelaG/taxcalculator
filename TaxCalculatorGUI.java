import javax.swing.*;

public class TaxCalculatorGUI {
    public static void main(String[] args) {
        // Create GUI components
        JTextField incomeField = new JTextField(10);

        // Create panel and add components
        JPanel panel = new JPanel();
        panel.add(new JLabel("Income: "));
        panel.add(incomeField);

        // Show input dialog
        int result = JOptionPane.showConfirmDialog(null, panel, "Tax Calculator", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            // Get user input
            double income = Double.parseDouble(incomeField.getText());

            // Calculate tax obligation
            double tax = TaxCalculatorService.calculateTax(income);

            // Display tax obligation
            JOptionPane.showMessageDialog(null, "Your tax obligation for the year is: R" + tax);
        }
    }
}
