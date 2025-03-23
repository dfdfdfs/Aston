package org.example;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ArithmeticOperationsTest {

    @Test
    public void testAddition() {
        Assert.assertEquals(ArithmeticOperations.add(5, 3), 8, "Addition should be correct");
    }

    @Test
    public void testSubtraction() {
        Assert.assertEquals(ArithmeticOperations.subtract(5, 3), 2, "Subtraction should be correct");
    }

    @Test
    public void testMultiplication() {
        Assert.assertEquals(ArithmeticOperations.multiply(5, 3), 15, "Multiplication should be correct");
    }

    @Test
    public void testDivision() {
        Assert.assertEquals(ArithmeticOperations.divide(15, 3), 5.0, 0.001, "Division should be correct");
    }

    @Test(expectedExceptions = ArithmeticException.class)
    public void testDivisionByZero() {
        ArithmeticOperations.divide(10, 0);
    }

    @Test
    public void testAdditionNegative() {
        Assert.assertEquals(ArithmeticOperations.add(-5, 3), -2, "Addition with negative number should be correct");
    }
}