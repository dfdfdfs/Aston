package org.example;
import org.testng.Assert;
import org.testng.annotations.Test;

public class IntegerComparisonTest {

    @Test
    public void testGreaterThan() {
        Assert.assertEquals(IntegerComparison.compare(5, 3), "5 is greater than 3", "Should return '5 is greater than 3'");
    }

    @Test
    public void testLessThan() {
        Assert.assertEquals(IntegerComparison.compare(3, 5), "3 is less than 5", "Should return '3 is less than 5'");
    }

    @Test
    public void testEquals() {
        Assert.assertEquals(IntegerComparison.compare(5, 5), "5 is equal to 5", "Should return '5 is equal to 5'");
    }

    @Test
    public void testNegativeGreaterThan() {
        Assert.assertEquals(IntegerComparison.compare(-2, -5), "-2 is greater than -5", "Should return '-2 is greater than -5'");
    }

    @Test
    public void testNegativeLessThan() {
        Assert.assertEquals(IntegerComparison.compare(-5, -2), "-5 is less than -2", "Should return '-5 is less than -2'");
    }
}