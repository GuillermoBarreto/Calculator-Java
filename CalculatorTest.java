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

    private static void checkString(String name, String actual, String expected) {
        if (!actual.equals(expected)) {
            System.out.println("FAIL " + name + ": expected \"" + expected + "\" but got \"" + actual + "\"");
            failures++;
        } else {
            System.out.println("PASS " + name);
        }
    }

    private static void checkThrows(String name, Runnable action, String expectedMessagePart) {
        try {
            action.run();
            System.out.println("FAIL " + name + ": expected IllegalArgumentException");
            failures++;
        } catch (IllegalArgumentException expected) {
            String message = expected.getMessage();
            if (message != null && message.contains(expectedMessagePart)) {
                System.out.println("PASS " + name);
            } else {
                System.out.println("FAIL " + name + ": message \"" + message
                        + "\" did not contain \"" + expectedMessagePart + "\"");
                failures++;
            }
        } catch (Throwable unexpected) {
            // A different error type means the code failed for the wrong
            // reason; report it instead of letting the runner crash.
            System.out.println("FAIL " + name + ": unexpected "
                    + unexpected.getClass().getSimpleName() + ": " + unexpected.getMessage());
            failures++;
        }
    }

    public static void main(String[] args) {
        check("add", Calculator.calculate(2, '+', 3), 5);
        check("subtract", Calculator.calculate(5, '-', 8), -3);
        check("multiply", Calculator.calculate(2.5, '*', 4), 10);
        check("divide", Calculator.calculate(7, '/', 2), 3.5);
        checkThrows("divide by zero", () -> Calculator.calculate(1, '/', 0), "zero");
        checkThrows("unknown operator", () -> Calculator.calculate(1, '%', 2), "Invalid operator");
        checkTrue("operator '+' is valid", Calculator.isValidOperator('+'));
        checkTrue("operator '-' is valid", Calculator.isValidOperator('-'));
        checkTrue("operator '*' is valid", Calculator.isValidOperator('*'));
        checkTrue("operator '/' is valid", Calculator.isValidOperator('/'));
        checkTrue("operator '%' is invalid", !Calculator.isValidOperator('%'));
        checkTrue("operator 'x' is invalid", !Calculator.isValidOperator('x'));

        checkString("format whole number drops .0", Calculator.formatResult(5), "5");
        checkString("format fraction keeps decimals", Calculator.formatResult(3.5), "3.5");
        checkString("format negative zero as 0", Calculator.formatResult(-0.0), "0");
        checkString("format large whole number", Calculator.formatResult(8e15), "8000000000000000");
        checkString("format huge value falls back to scientific", Calculator.formatResult(1e16), "1.0E16");

        if (failures > 0) {
            System.out.println(failures + " check(s) failed");
            System.exit(1);
        }
        System.out.println("All checks passed.");
    }
}
