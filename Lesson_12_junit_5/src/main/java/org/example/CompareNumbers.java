package org.example;
import java.util.Scanner;

public class CompareNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the first integer: "); // Введите первое целое число
        int num1 = scanner.nextInt();

        System.out.print("Enter the second integer: "); // Введите второе целое число
        int num2 = scanner.nextInt();

        if (num1 > num2) {
            System.out.println("The first number is greater than the second."); // Первое число больше второго
        } else if (num1 < num2) {
            System.out.println("The first number is less than the second."); // Первое число меньше второго
        } else {
            System.out.println("The numbers are equal."); // Числа равны
        }

        scanner.close();
    }
}