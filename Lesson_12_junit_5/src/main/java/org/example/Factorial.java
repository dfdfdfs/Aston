package org.example;
import java.util.Scanner;

public class Factorial {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a non-negative integer: "); // Введите целое неотрицательное число
        int n = scanner.nextInt();

        if (n < 0) {
            System.out.println("Factorial is not defined for negative numbers."); // Факториал не определен для отрицательных чисел
        } else {
            long factorial = calculateFactorial(n);
            System.out.println("The factorial of " + n + " is " + factorial); // Факториал числа ... равен ...
        }

        scanner.close();
    }

    public static long calculateFactorial(int n) {
        if (n == 0) {
            return 1; // Base case: factorial of 0 is 1
        } else {
            return n * calculateFactorial(n - 1); // Recursive call
        }
    }
}