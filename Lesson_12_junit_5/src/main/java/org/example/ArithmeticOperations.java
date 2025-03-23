package org.example;
import java.util.Scanner;

public class ArithmeticOperations {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the first integer: "); // Введите первое целое число
        int num1 = scanner.nextInt();

        System.out.print("Enter the second integer: "); // Введите второе целое число
        int num2 = scanner.nextInt();

        System.out.println("Sum: " + (num1 + num2)); // Сумма
        System.out.println("Difference: " + (num1 - num2)); // Разность
        System.out.println("Product: " + (num1 * num2)); // Произведение

        if (num2 != 0) {
            System.out.println("Quotient: " + (double) num1 / num2); // Частное
        } else {
            System.out.println("Division by zero is not allowed."); // Деление на ноль недопустимо
        }

        scanner.close();
    }
}