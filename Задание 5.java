public class Main {

    public static void main(String[] args) {
        System.out.println(isSumInInterval(5, 7));
        System.out.println(isSumInInterval(1, 2));   
    }


    public static boolean isSumInInterval(int num1, int num2) {
        int sum = num1 + num2;
        return sum >= 10 && sum <= 20;
    }
}