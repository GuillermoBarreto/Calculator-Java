/**
 * Assertion-based checks for Calculator.calculate.
 * Run with: javac Calculator.java CalculatorTest.java && java CalculatorTest
 */
public class CalculatorTest {
    private static int failures = 0;

    private static void check(String name, double actual, double expected) {
        if (Double.compare(actual, expected) != 0) {
            System.out.println("FAIL " + name + ": expected " + expected + " but got " + actual);
            failures++;
        } else {
            System.out.println("PASS " + name);
        }
    }

    private static void checkTrue(String name, boolean condition) {
        if (!condition) {
            System.out.println("FAIL " + name);
            failures++;
        } else {
            System.out.println("PASS " + name);
        }
    }

    private static void checkThrows(String name, Runnable action) {
        try {
            action.run();
            System.out.println("FAIL " + name + ": expected IllegalArgumentException");
            failures++;
        } catch (IllegalArgumentException expected) {
            System.out.println("PASS " + name);
        }
    }

    public static void main(String[] args) {
        check("add", Calculator.calculate(2, '+', 3), 5);
        check("subtract", Calculator.calculate(5, '-', 8), -3);
        check("multiply", Calculator.calculate(2.5, '*', 4), 10);
        check("divide", Calculator.calculate(7, '/', 2), 3.5);
        checkThrows("divide by zero", () -> Calculator.calculate(1, '/', 0));
        checkThrows("unknown operator", () -> Calculator.calculate(1, '%', 2));
        checkTrue("operator '+' is valid", Calculator.isValidOperator('+'));
        checkTrue("operator '-' is valid", Calculator.isValidOperator('-'));
        checkTrue("operator '*' is valid", Calculator.isValidOperator('*'));
        checkTrue("operator '/' is valid", Calculator.isValidOperator('/'));
        checkTrue("operator '%' is invalid", !Calculator.isValidOperator('%'));
        checkTrue("operator 'x' is invalid", !Calculator.isValidOperator('x'));

        if (failures > 0) {
            System.out.println(failures + " check(s) failed");
            System.exit(1);
        }
        System.out.println("All checks passed.");
    }
}
