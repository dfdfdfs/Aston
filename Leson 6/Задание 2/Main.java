
public class Main {

    public static void main(String[] args) {
        Circle circle = new Circle(5);
        circle.setFillColor("Red");
        circle.setBorderColor("Black");

        Rectangle rectangle = new Rectangle(4, 6);
        rectangle.setFillColor("Blue");
        rectangle.setBorderColor("Green");

        Triangle triangle = new Triangle(3, 4, 5);
        triangle.setFillColor("Yellow");
        triangle.setBorderColor("Orange");

        ShapeCalculator.printShapeDetails(circle);
        ShapeCalculator.printShapeDetails(rectangle);
        ShapeCalculator.printShapeDetails(triangle);
    }
}