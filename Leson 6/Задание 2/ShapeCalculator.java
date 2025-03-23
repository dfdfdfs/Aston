
public class ShapeCalculator {

    public static void printShapeDetails(Shape shape) {
        System.out.println("Area: " + shape.getArea());
        System.out.println("Perimeter: " + shape.getPerimeter());
        System.out.println("Fill Color: " + shape.getFillColor());
        System.out.println("Border Color: " + shape.getBorderColor());
        System.out.println("----------------------");
    }
}