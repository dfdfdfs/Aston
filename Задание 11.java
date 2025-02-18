import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int[] arr11 = fillArrayWithNumbers(100);
        System.out.println("Array filled with numbers from 1 to 100: " + Arrays.toString(arr11));
    }


    public static int[] fillArrayWithNumbers(int length) {
        int[] arr = new int[length];
        for (int i = 0; i < length; i++) {
            arr[i] = i + 1;
        }
        return arr;
    }

}