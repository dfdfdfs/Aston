public class Main {

    public static void main(String[] args) {
        printStringNTimes("Hello", 3);
    }


    public static void printStringNTimes(String str, int n) {
        for (int i = 0; i < n; i++) {
            System.out.println(str);
        }
    }
}