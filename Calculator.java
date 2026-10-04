import java.util.Scanner;

/**
 * A small command-line calculator. Reads two numbers and an operator from
 * standard input, prints the result, and exits.
 */
public class Calculator {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) { // closed automatically
            System.out.println("=== My Personal Calculator ===");

            System.out.print("Enter first number: ");
            if (!scanner.hasNextDouble()) {
                System.out.println("Error: Please enter a valid number.");
                return;
            }
            double num1 = scanner.nextDouble();

            System.out.print("Enter operator (+, -, *, /): ");
            String operatorInput = scanner.next();
            if (operatorInput.length() != 1) {
                System.out.println("Error: Please enter a single character operator.");
                return;
            }
            char operator = operatorInput.charAt(0);
            if (!isValidOperator(operator)) {
                System.out.println("Error: Invalid operator: '" + operator + "'. Use one of +, -, *, /.");
                return;
            }

            System.out.print("Enter second number: ");
            if (!scanner.hasNextDouble()) {
                System.out.println("Error: Please enter a valid number.");
                return;
            }
            double num2 = scanner.nextDouble();

            try {
                double result = calculate(num1, operator, num2);
                System.out.println("Result: " + formatResult(result));
            } catch (IllegalArgumentException exception) {
                System.out.println("Error: " + exception.getMessage());
            }
            System.out.println("==================================");
        }
    }

    /**
     * Formats a result for display: whole numbers print without a trailing ".0".
     * Package-visible (like isValidOperator) so the formatting rules can be
     * covered by CalculatorTest.
     */
    static String formatResult(double value) {
        if (Double.isFinite(value) && value == Math.floor(value) && Math.abs(value) < 9e15) {
            return String.valueOf((long) value);
        }
        return String.valueOf(value);
    }

    /**
     * Returns true for the supported operators: +, -, *, /.
     */
    static boolean isValidOperator(char operator) {
        return operator == '+' || operator == '-' || operator == '*' || operator == '/';
    }

    /**
     * Applies the operator to the two numbers. Kept separate from main so the
     * math can be tested without console input.
     *
     * @throws IllegalArgumentException for an unknown operator or division by zero
     */
    static double calculate(double num1, char operator, double num2) {
        switch (operator) {
            case '+':
                return num1 + num2;
            case '-':
                return num1 - num2;
            case '*':
                return num1 * num2;
            case '/':
                if (num2 == 0) {
                    throw new IllegalArgumentException("Division by zero is not allowed.");
                }
                return num1 / num2;
            default:
                throw new IllegalArgumentException(
                        "Invalid operator: '" + operator + "'. Use one of +, -, *, /.");
        }
    }
}
