import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double num1, num2, result = 0
        char operator;

        System.out.println("My personal calculator");

        System.out.println("Enter first number:");
        num1 = scanner.nextDouble();

        System.out.print("Enter operator (+, -, *, ./): ");
        operator = scanner.next().chartAt(0);

        System.out.print("Enter second number: ");
        num2 = scanner.nextDouble();

        switch(operator) {
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
            if (num2 != 0)
            result = num1 / num2;
            else {
                System.out.println("Error: Division by zero is not allowe.");
                return;
            }          
            break;
            default:
            System.out.println("Error: Invalid operator.");
            return;  
        }
        System.out.println("Result: " + result);
        System.out.print("==================================");
    }
}