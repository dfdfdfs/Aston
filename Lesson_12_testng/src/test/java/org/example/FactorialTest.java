package org.example;

import org.testng.Assert;
import org.testng.annotations.Test;

public class FactorialTest {

    @Test
    public void testFactorialZero() {
        Assert.assertEquals(Factorial.calculateFactorial(0), 1, "Factorial of 0 should be 1");
    }

    @Test
    public void testFactorialPositive() {
        Assert.assertEquals(Factorial.calculateFactorial(5), 120, "Factorial of 5 should be 120");
    }

    @Test
    public void testFactorialOne() {
        Assert.assertEquals(Factorial.calculateFactorial(1), 1, "Factorial of 1 should be 1");
    }

    @Test(expectedExceptions = StackOverflowError.class) // Or use IllegalArgumentException if you throw that instead
    public void testFactorialNegative() {
        Factorial.calculateFactorial(-1); // Factorial of negative number should cause stack overflow.
        //Alternatively you can add an exception if the number is negative in the calculateFactorial function
    }

    @Test
    public void testFactorialLarge() {
        Assert.assertEquals(Factorial.calculateFactorial(12), 479001600, "Factorial of 12 should be 479001600");
    }
}