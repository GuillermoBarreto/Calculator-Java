import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) { // closed automatically
            double num1, num2, result = 0;

            System.out.println("=== My Personal Calculator ===");

            System.out.print("Enter first number: ");
            if (!scanner.hasNextDouble()) {
                System.out.println("Error: Please enter a valid number.");
                return;
            }
            num1 = scanner.nextDouble();

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
            num2 = scanner.nextDouble();

            switch (operator) {
                case '+':
                    result = num1 + num2;
                    break;
                case '-':
                    result = num1 - num2;
                    break;
                case '*':
                    result = num1 * num2;
                    break;
                case '/':
                    if (num2 != 0) {
                        result = num1 / num2;
                    } else {
                        System.out.println("Error: Division by zero is not allowed.");
                        return;
                    }
                    break;
                default:
                    System.out.println("Error: Invalid operator.");
                    return;
            }

            System.out.println("Result: " + result);
            System.out.println("==================================");
        }
    }
}
