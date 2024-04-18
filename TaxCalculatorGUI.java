import javax.swing.*;

public class TaxCalculatorGUI {
    public static void main(String[] args) {
        // Create GUI components
        JTextField incomeField = new JTextField(10);
        String[] ageGroups = {"Under 65", "65 and older", "75 and older"};
        JComboBox<String> ageGroupComboBox = new JComboBox<>(ageGroups);

        // Create panel and add components
        JPanel panel = new JPanel();
        panel.add(new JLabel("Income: "));
        panel.add(incomeField);
        panel.add(new JLabel("Age Group: "));
        panel.add(ageGroupComboBox);

        // Show input dialog
        int result = JOptionPane.showConfirmDialog(null, panel, "Tax Calculator", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            // Get user input
            double income = Double.parseDouble(incomeField.getText());
            int ageGroupIndex = ageGroupComboBox.getSelectedIndex() + 1; // Add 1 to match age group numbering

            // Calculate tax obligation
            double tax = TaxCalculatorService.calculateTax(income, ageGroupIndex);

            // Display tax obligation
            JOptionPane.showMessageDialog(null, "Your tax obligation for the year is: R" + tax);
        }
    }
}
