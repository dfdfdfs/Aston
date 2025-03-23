package org.example;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TriangleAreaTest {

    @Test
    void testValidTriangle() {
        assertEquals(6.0, calculateTriangleArea(3, 4, 5), 0.001, "Area of 3-4-5 triangle should be 6.0");
    }

    @Test
    void testEquilateralTriangle() {
        assertEquals(4.330, calculateTriangleArea(3, 3, 3), 0.001, "Area of equilateral triangle with side 3 should be approximately 4.330");
    }

    @Test
    void testInvalidTriangle() {
        assertEquals(Double.NaN, calculateTriangleArea(1, 2, 5), 0.001, "Area of invalid triangle should be NaN");
    }

    @Test
    void testZeroSide() {
        assertEquals(0.0, calculateTriangleArea(0, 5, 5), 0.001, "Area should be 0 if one side is zero");
    }

    // Helper method to calculate triangle area for testing purposes
    private double calculateTriangleArea(double a, double b, double c) {
        if (a + b > c && a + c > b && b + c > a && a > 0 && b > 0 && c > 0) {
            double s = (a + b + c) / 2;
            return Math.sqrt(s * (s - a) * (s - b) * (s - c));
        } else {
            return Double.NaN; // Returning NaN if the triangle is invalid or has a zero side
        }
    }
}