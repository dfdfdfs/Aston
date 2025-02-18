public class Main {

    public static void main(String[] args) {
        System.out.println("Is 2024 a leap year? " + isLeapYear(2024));
        System.out.println("Is 2100 a leap year? " + isLeapYear(2100));
        System.out.println("Is 2000 a leap year? " + isLeapYear(2000));
    }


    public static boolean isLeapYear(int year) {
        if (year % 400 == 0) {
            return true;
        } else if (year % 100 == 0) {
            return false;
        } else return year % 4 == 0;
    }
}