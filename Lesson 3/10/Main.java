import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int[] arr10 = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        System.out.println("Original array: " + Arrays.toString(arr10));
        invertArray(arr10);
        System.out.println("Inverted array: " + Arrays.toString(arr10));
    }


    public static void invertArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (arr[i] == 0) ? 1 : 0;
        }
    }

}