package org.example;
import java.util.Scanner;



 class IntegerComparison {

    public static String compare(int num1, int num2) {
        if (num1 > num2) {
            return num1 + " is greater than " + num2;
        } else if (num1 < num2) {
            return num1 + " is less than " + num2;
        } else {
            return num1 + " is equal to " + num2;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the first integer: ");
        int num1 = scanner.nextInt();

        System.out.print("Enter the second integer: ");
        int num2 = scanner.nextInt();

        String comparisonResult = compare(num1, num2);
        System.out.println(comparisonResult);
    }
}