import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int[][] matrix = createDiagonalMatrix(5);
        System.out.println("Diagonal matrix:");
        printMatrix(matrix);
    }


    public static int[][] createDiagonalMatrix(int size) {
        int[][] matrix = new int[size][size];
        for (int i = 0; i < size; i++) {
            matrix[i][i] = 1;
        }
        return matrix;
    }
    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }
    }
}