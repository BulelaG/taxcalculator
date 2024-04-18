// UserInput.java
import javax.swing.JOptionPane;

public class UserInput {
    // Method to get user input for income
    public static double getIncome() {
        return Double.parseDouble(JOptionPane.showInputDialog("Enter your income: "));
    }

    // Method to get user input for age
    public static int getAge() {
        String[] options = {"Under 65", "65 and older", "75 and older"};
        int choice = JOptionPane.showOptionDialog(null, "Select your age group:", "Age Selection",
                JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);

        switch (choice) {
            case 0:
                return 64; // Under 65
            case 1:
                return 65; // 65 and older
            case 2:
                return 75; // 75 and older
            default:
                return 0; // Default value
        }
    }
}
