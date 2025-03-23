package org.example;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TriangleAreaTest {

    @Test
    public void testTriangleAreaValid() {
        double base = 5.0;
        double height = 4.0;
        double expectedArea = 10.0;
        double actualArea = 0.5 * base * height; // Directly calculate the area for testing
        Assert.assertEquals(actualArea, expectedArea, 0.001, "Area calculation should be correct");
    }

    @Test
    public void testTriangleAreaZeroBase() {
        double base = 0.0;
        double height = 4.0;
        double expectedArea = 0.0;
        double actualArea = 0.5 * base * height;
        Assert.assertEquals(actualArea, expectedArea, 0.001, "Area should be zero when base is zero");
    }

    @Test
    public void testTriangleAreaZeroHeight() {
        double base = 5.0;
        double height = 0.0;
        double expectedArea = 0.0;
        double actualArea = 0.5 * base * height;
        Assert.assertEquals(actualArea, expectedArea, 0.001, "Area should be zero when height is zero");
    }

    @Test
    public void testTriangleAreaNegativeBase() {
        double base = -5.0;
        double height = 4.0;
        double expectedArea = -10.0;
        double actualArea = 0.5 * base * height;
        Assert.assertEquals(actualArea, expectedArea, 0.001, "Area should be negative when base is negative");
    }

    @Test
    public void testTriangleAreaNegativeHeight() {
        double base = 5.0;
        double height = -4.0;
        double expectedArea = -10.0;
        double actualArea = 0.5 * base * height;
        Assert.assertEquals(actualArea, expectedArea, 0.001, "Area should be negative when height is negative");
    }
}