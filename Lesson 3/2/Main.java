public class Main {

    public static void main(String[] args) {
        checkSumSign();
    }


    public static void checkSumSign() {
        int a = 5;
        int b = 99;
        int sum = a + b;

        if (sum >= 0) {
            System.out.println("Сумма положительная");
        } else {
            System.out.println("Сумма отрицательная");
        }
    }
}