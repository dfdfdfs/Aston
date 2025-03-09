public class Main {
    public static void main(String[] args) {
        Circle circle = new Circle(5, "red", "black");
        Rectangle rectangle = new Rectangle(4, 6, "blue", "green");
        Triangle triangle = new Triangle(3, 4, 5, "yellow", "purple");

        System.out.println("Circle:");
        circle.displayInfo();
        System.out.println("\nRectangle:");
        rectangle.displayInfo();
        System.out.println("\nTriangle:");
        triangle.displayInfo();
    }
}