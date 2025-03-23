package org.example;
import java.util.Scanner;

public class TriangleArea {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the length of side a: "); // Введите длину стороны a
        double a = scanner.nextDouble();

        System.out.print("Enter the length of side b: "); // Введите длину стороны b
        double b = scanner.nextDouble();

        System.out.print("Enter the length of side c: "); // Введите длину стороны c
        double c = scanner.nextDouble();

        if (a + b > c && a + c > b && b + c > a) { // Triangle existence check
            double s = (a + b + c) / 2; // Semi-perimeter
            double area = Math.sqrt(s * (s - a) * (s - b) * (s - c)); // Heron's formula
            System.out.println("The area of the triangle is " + area); // Площадь треугольника равна ...
        } else {
            System.out.println("A triangle with these sides does not exist."); // Треугольник с такими сторонами не существует
        }

        scanner.close();
    }
}