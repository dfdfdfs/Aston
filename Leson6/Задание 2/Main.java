import java.awt.Color;

/**
 * Интерфейс Shape определяет общие методы для всех геометрических фигур.
 */
interface Shape {
    /**
     * Вычисляет площадь фигуры.
     *
     * @return Площадь фигуры.
     */
    double calculateArea();

    /**
     * Вычисляет периметр фигуры.
     *
     * @return Периметр фигуры.
     */
    default double calculatePerimeter() {
        return 0.0; // Значение по умолчанию (должно быть переопределено в конкретных классах)
    }

    /**
     * Возвращает цвет заливки фигуры.
     *
     * @return Цвет заливки.
     */
    String getFillColorName();

    /**
     * Устанавливает цвет заливки фигуры.
     *
     * @param color Цвет заливки.
     */
    void setFillColor(Color color);

    /**
     * Возвращает цвет границы фигуры.
     *
     * @return Цвет границы.
     */
    String getBorderColorName();

    /**
     * Устанавливает цвет границы фигуры.
     *
     * @param color Цвет границы.
     */
    void setBorderColor(Color color);

    /**
     * Выводит информацию о фигуре в консоль.
     */
    void displayInfo();

    Color getFillColor();

    Color getBorderColor();
}

/**
 * Класс Circle представляет круг и реализует интерфейс Shape.
 */
class Circle implements Shape {
    private double radius; // Радиус круга
    private Color fillColor; // Цвет заливки круга
    private Color borderColor; // Цвет границы круга

    /**
     * Конструктор класса Circle.
     *
     * @param radius      Радиус круга.
     * @param fillColor   Цвет заливки.
     * @param borderColor Цвет границы.
     */
    public Circle(double radius, Color fillColor, Color borderColor) {
        this.radius = radius;
        this.fillColor = fillColor;
        this.borderColor = borderColor;
    }

    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public double calculatePerimeter() {
        return 2 * Math.PI * radius;
    }

    @Override
    public String getFillColorName() {
        return getColorName(fillColor);
    }

    @Override
    public void setFillColor(Color color) {
        this.fillColor = color;
    }

    @Override
    public String getBorderColorName() {
        return getColorName(borderColor);
    }

    @Override
    public void setBorderColor(Color color) {
        this.borderColor = color;
    }

    @Override
    public void displayInfo() {
        System.out.println("Фигура: Круг");
        System.out.println("Площадь: " + calculateArea());
        System.out.println("Периметр: " + calculatePerimeter());
        System.out.println("Цвет заливки: " + getFillColorName());
        System.out.println("Цвет границы: " + getBorderColorName());
        System.out.println("----------------------");
    }

    private String getColorName(Color color) {
        if (color.equals(Color.RED)) {
            return "Красный";
        } else if (color.equals(Color.GREEN)) {
            return "Зеленый";
        } else if (color.equals(Color.BLUE)) {
            return "Синий";
        } else if (color.equals(Color.BLACK)) {
            return "Черный";
        } else if (color.equals(Color.YELLOW)) {
            return "Желтый";
        } else if (color.equals(Color.ORANGE)) {
            return "Оранжевый";
        } else if (color.equals(Color.CYAN)) {
            return "Голубой";
        } else {
            return "Неизвестный";
        }
    }

    @Override
    public Color getFillColor() {
        return fillColor;
    }

    @Override
    public Color getBorderColor() {
        return borderColor;
    }
}

/**
 * Класс Rectangle представляет прямоугольник и реализует интерфейс Shape.
 */
class Rectangle implements Shape {
    private double length; // Длина прямоугольника
    private double width; // Ширина прямоугольника
    private Color fillColor; // Цвет заливки прямоугольника
    private Color borderColor; // Цвет границы прямоугольника

    /**
     * Конструктор класса Rectangle.
     *
     * @param length      Длина прямоугольника.
     * @param width       Ширина прямоугольника.
     * @param fillColor   Цвет заливки.
     * @param borderColor Цвет границы.
     */
    public Rectangle(double length, double width, Color fillColor, Color borderColor) {
        this.length = length;
        this.width = width;
        this.fillColor = fillColor;
        this.borderColor = borderColor;
    }

    @Override
    public double calculateArea() {
        return length * width;
    }

    @Override
    public double calculatePerimeter() {
        return 2 * (length + width);
    }

    @Override
    public String getFillColorName() {
        return getColorName(fillColor);
    }

    @Override
    public void setFillColor(Color color) {
        this.fillColor = color;
    }

    @Override
    public String getBorderColorName() {
        return getColorName(borderColor);
    }

    @Override
    public void setBorderColor(Color color) {
        this.borderColor = color;
    }

    @Override
    public void displayInfo() {
        System.out.println("Фигура: Прямоугольник");
        System.out.println("Площадь: " + calculateArea());
        System.out.println("Периметр: " + calculatePerimeter());
        System.out.println("Цвет заливки: " + getFillColorName());
        System.out.println("Цвет границы: " + getBorderColorName());
        System.out.println("----------------------");
    }

    private String getColorName(Color color) {
        if (color.equals(Color.RED)) {
            return "Красный";
        } else if (color.equals(Color.GREEN)) {
            return "Зеленый";
        } else if (color.equals(Color.BLUE)) {
            return "Синий";
        } else if (color.equals(Color.BLACK)) {
            return "Черный";
        } else if (color.equals(Color.YELLOW)) {
            return "Желтый";
        } else if (color.equals(Color.ORANGE)) {
            return "Оранжевый";
        } else if (color.equals(Color.CYAN)) {
            return "Голубой";
        } else {
            return "Неизвестный";
        }
    }

    @Override
    public Color getFillColor() {
        return fillColor;
    }

    @Override
    public Color getBorderColor() {
        return borderColor;
    }
}

/**
 * Класс Triangle представляет треугольник и реализует интерфейс Shape.
 */
class Triangle implements Shape {
    private double side1; // Первая сторона треугольника
    private double side2; // Вторая сторона треугольника
    private double side3; // Третья сторона треугольника
    private double height; // Высота треугольника (для вычисления площади)
    private Color fillColor; // Цвет заливки треугольника
    private Color borderColor; // Цвет границы треугольника

    /**
     * Конструктор класса Triangle.
     *
     * @param side1       Первая сторона.
     * @param side2       Вторая сторона.
     * @param side3       Третья сторона.
     * @param height      Высота треугольника.
     * @param fillColor   Цвет заливки.
     * @param borderColor Цвет границы.
     */
    public Triangle(double side1, double side2, double side3, double height, Color fillColor, Color borderColor) {
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
        this.height = height;
        this.fillColor = fillColor;
        this.borderColor = borderColor;
    }

    @Override
    public double calculateArea() {
        // Используем формулу Герона для вычисления площади, если известны только стороны (необязательно)
        // double s = (side1 + side2 + side3) / 2;
        // return Math.sqrt(s * (s - side1) * (s - side2) * (s - side3));

        return 0.5 * side1 * height; // Используем основание и высоту для вычисления площади
    }

    @Override
    public double calculatePerimeter() {
        return side1 + side2 + side3;
    }

    @Override
    public String getFillColorName() {
        return getColorName(fillColor);
    }

    @Override
    public void setFillColor(Color color) {
        this.fillColor = color;
    }

    @Override
    public String getBorderColorName() {
        return getColorName(borderColor);
    }

    @Override
    public void setBorderColor(Color color) {
        this.borderColor = color;
    }

    @Override
    public void displayInfo() {
        System.out.println("Фигура: Треугольник");
        System.out.println("Площадь: " + calculateArea());
        System.out.println("Периметр: " + calculatePerimeter());
        System.out.println("Цвет заливки: " + getFillColorName());
        System.out.println("Цвет границы: " + getBorderColorName());
        System.out.println("----------------------");
    }

    private String getColorName(Color color) {
        if (color.equals(Color.RED)) {
            return "Красный";
        } else if (color.equals(Color.GREEN)) {
            return "Зеленый";
        } else if (color.equals(Color.BLUE)) {
            return "Синий";
        } else if (color.equals(Color.BLACK)) {
            return "Черный";
        } else if (color.equals(Color.YELLOW)) {
            return "Желтый";
        } else if (color.equals(Color.ORANGE)) {
            return "Оранжевый";
        } else if (color.equals(Color.CYAN)) {
            return "Голубой";
        } else {
            return "Неизвестный";
        }
    }

    @Override
    public Color getFillColor() {
        return fillColor;
    }

    @Override
    public Color getBorderColor() {
        return borderColor;
    }
}

/**
 * Главный класс Main, содержащий метод main.
 */
public class Main {
    /**
     * Главный метод программы.
     *
     * @param args Аргументы командной строки.
     */
    public static void main(String[] args) {
        // Создаем экземпляры фигур
        Circle circle = new Circle(5, Color.RED, Color.BLACK);
        Rectangle rectangle = new Rectangle(4, 6, Color.BLUE, Color.GREEN);
        Triangle triangle = new Triangle(3, 4, 5, 4, Color.YELLOW, Color.ORANGE);

        // Выводим информацию о каждой фигуре
        circle.displayInfo();
        rectangle.displayInfo();
        triangle.displayInfo();

        // Пример изменения цвета фигуры и повторного вывода информации
        rectangle.setFillColor(Color.CYAN);
        rectangle.displayInfo(); // Повторно выводим информацию для отображения нового цвета
    }
}