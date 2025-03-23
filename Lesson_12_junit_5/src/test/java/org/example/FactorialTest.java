package org.example;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class FactorialTest {

    @Test
    void testFactorialZero() {
        assertEquals(1, Factorial.calculateFactorial(0), "Factorial of 0 should be 1");
    }

    @Test
    void testFactorialPositive() {
        assertEquals(120, Factorial.calculateFactorial(5), "Factorial of 5 should be 120");
    }

    @Test
    void testFactorialLarge() {
        assertEquals(3628800, Factorial.calculateFactorial(10), "Factorial of 10 should be 3628800");
    }

    @Test
    void testFactorialOne() {
        assertEquals(1, Factorial.calculateFactorial(1), "Factorial of 1 should be 1");
    }

    @Test
    void testFactorialNegative() {

        assertDoesNotThrow(() -> Factorial.calculateFactorial(-1), "Factorial calculation shouldn't crash with negative input.");
    }
}