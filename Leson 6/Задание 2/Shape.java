
public interface Shape {

    double getArea();

    // Default method to calculate perimeter. Can be overridden by specific shapes if needed.
    default double getPerimeter() {
        return 0.0; // Default implementation. Specific shapes should override if applicable.
    }

    String getFillColor();

    void setFillColor(String color);

    String getBorderColor();

    void setBorderColor(String color);
}