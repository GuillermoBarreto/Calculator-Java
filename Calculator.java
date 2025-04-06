import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // declared as 'scanner'

        double num1, num2, result = 0;
        char operator;

        System.out.println("=== My Personal Calculator ===");

        System.out.print("Enter first number: ");
        num1 = scanner.nextDouble(); // using 'scanner'

        System.out.print("Enter operator (+, -, *, /): ");
        operator = scanner.next().charAt(0); // fixed typo: was 'chartAt'

        System.out.print("Enter second number: ");
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
