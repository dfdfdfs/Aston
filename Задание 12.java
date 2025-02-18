import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int[] arr12 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        System.out.println("Original array: " + Arrays.toString(arr12));
        multiplyLessThan6(arr12);
        System.out.println("Modified array: " + Arrays.toString(arr12));
    }


    public static void multiplyLessThan6(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 6) {
                arr[i] *= 2;
            }
        }
    }

}