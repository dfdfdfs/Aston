public class Main {

    public static void main(String[] args) {
        System.out.println(isNumberNegative(-5));
        System.out.println(isNumberNegative(10));
        System.out.println(isNumberNegative(0));
    }


    public static boolean isNumberNegative(int number) {
        return number < 0;
    }
}