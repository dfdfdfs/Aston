package org.example;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ArithmeticOperationsTest {

    @Test
    void testAddition() {
        assertEquals(5, ArithmeticOperationsHelper.add(2, 3), "2 + 3 should be 5");
    }

    @Test
    void testSubtraction() {
        assertEquals(1, ArithmeticOperationsHelper.subtract(3, 2), "3 - 2 should be 1");
    }

    @Test
    void testMultiplication() {
        assertEquals(6, ArithmeticOperationsHelper.multiply(2, 3), "2 * 3 should be 6");
    }

    @Test
    void testDivision() {
        assertEquals(2.0, ArithmeticOperationsHelper.divide(6, 3), 0.001, "6 / 3 should be 2.0");
    }

    @Test
    void testDivisionByZero() {
        assertEquals(Double.NaN, ArithmeticOperationsHelper.divide(5, 0), 0.001, "Division by zero should return NaN"); // Or throw an exception
    }

    // Helper class to perform the arithmetic operations
    static class ArithmeticOperationsHelper {
        static int add(int a, int b) {
            return a + b;
        }

        static int subtract(int a, int b) {
            return a - b;
        }

        static int multiply(int a, int b) {
            return a * b;
        }

        static double divide(int a, int b) {
            if (b == 0) {
                return Double.NaN; // Handle division by zero
            }
            return (double) a / b;
        }
    }
}