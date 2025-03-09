interface Shape {
    double getPerimeter();
    double getArea();

    String getFillColor();
    void setFillColor(String color);

    String getBorderColor();
    void setBorderColor(String color);

    default void displayInfo() {
        System.out.println("Perimeter: " + getPerimeter());
        System.out.println("Area: " + getArea());
        System.out.println("Fill Color: " + getFillColor());
        System.out.println("Border Color: " + getBorderColor());
    }
}