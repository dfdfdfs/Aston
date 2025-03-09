import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int[] arr14 = createArrayWithValue(7, 5);
        System.out.println("Array filled with value: " + Arrays.toString(arr14));
    }


    public static int[] createArrayWithValue(int len, int initialValue) {
        int[] arr = new int[len];
        Arrays.fill(arr, initialValue);
        return arr;
    }
}