import java.util.Scanner;

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

            System.out.print("Enter second number: ");
            if (!scanner.hasNextDouble()) {
                System.out.println("Error: Please enter a valid number.");
                return;
            }
            double num2 = scanner.nextDouble();

            try {
                double result = calculate(num1, operator, num2);
                System.out.println("Result: " + result);
            } catch (IllegalArgumentException exception) {
                System.out.println("Error: " + exception.getMessage());
            }
            System.out.println("==================================");
        }
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
