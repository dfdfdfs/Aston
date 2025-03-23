package org.example;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CompareNumbersTest {

    @Test
    void testFirstGreaterThanSecond() {
        assertEquals("The first number is greater than the second.", CompareNumbersHelper.compare(5, 3), "5 should be greater than 3");
    }

    @Test
    void testFirstLessThanSecond() {
        assertEquals("The first number is less than the second.", CompareNumbersHelper.compare(3, 5), "3 should be less than 5");
    }

    @Test
    void testNumbersAreEqual() {
        assertEquals("The numbers are equal.", CompareNumbersHelper.compare(3, 3), "3 should be equal to 3");
    }

    // Helper class to perform the comparison
    static class CompareNumbersHelper {
        static String compare(int num1, int num2) {
            if (num1 > num2) {
                return "The first number is greater than the second.";
            } else if (num1 < num2) {
                return "The first number is less than the second.";
            } else {
                return "The numbers are equal.";
            }
        }
    }
}