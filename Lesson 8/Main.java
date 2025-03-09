public class Main {

    // Пользовательский класс исключения для неправильного размера массива
    static class MyArraySizeException extends Exception {
        public MyArraySizeException(String message) {
            super(message);
        }
    }

    // Пользовательский класс исключения для некорректных данных в массиве
    static class MyArrayDataException extends Exception {
        public MyArrayDataException(String message) {
            super(message);
        }

        public MyArrayDataException(int row, int col) {
            super("Некорректные данные в строке " + row + ", столбце " + col);
        }
    }

    // Метод для обработки двумерного строкового массива
    public static int processArray(String[][] arr) throws MyArraySizeException, MyArrayDataException {
        // Проверяем, является ли размер массива 4x4
        if (arr.length != 4 || arr[0].length != 4) {
            throw new MyArraySizeException("Массив должен быть размером 4x4.");
        }

        int sum = 0;
        // Проходимся по всем элементам массива
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                try {
                    // Преобразуем строковый элемент в целое число и добавляем к сумме
                    sum += Integer.parseInt(arr[i][j]);
                } catch (NumberFormatException e) {
                    // Если преобразование не удалось, бросаем исключение MyArrayDataException
                    throw new MyArrayDataException(i, j);
                }
            }
        }

        // Возвращаем сумму элементов массива
        return sum;
    }

    public static void main(String[] args) {
        // Пример массива с корректными данными
        String[][] validArray = {
                {"1", "2", "3", "4"},
                {"5", "6", "7", "8"},
                {"9", "10", "11", "12"},
                {"13", "14", "15", "16"}
        };

        // Пример массива с некорректными данными
        String[][] invalidDataArray = {
                {"1", "2", "3", "4"},
                {"5", "6", "7", "abc"},
                {"9", "10", "11", "12"},
                {"13", "14", "15", "16"}
        };

        // Пример массива неправильного размера
        String[][] invalidSizeArray = {
                {"1", "2", "3"},
                {"4", "5", "6"},
                {"7", "8", "9"}
        };

        // Обрабатываем массив с корректными данными
        try {
            int sum = processArray(validArray);
            System.out.println("Сумма элементов корректного массива: " + sum);
        } catch (MyArraySizeException e) {
            System.err.println("Ошибка: " + e.getMessage());
        } catch (MyArrayDataException e) {
            System.err.println("Ошибка: " + e.getMessage());
        }

        // Обрабатываем массив с некорректными данными
        try {
            int sum = processArray(invalidDataArray);
            System.out.println("Сумма элементов массива с некорректными данными: " + sum); // Не выполнится, если исключение
        } catch (MyArraySizeException e) {
            System.err.println("Ошибка: " + e.getMessage());
        } catch (MyArrayDataException e) {
            System.err.println("Ошибка: " + e.getMessage());
        }

        // Обрабатываем массив неправильного размера
        try {
            int sum = processArray(invalidSizeArray);
            System.out.println("Сумма элементов массива неправильного размера: " + sum);  // Не выполнится, если исключение
        } catch (MyArraySizeException e) {
            System.err.println("Ошибка: " + e.getMessage());
        } catch (MyArrayDataException e) {
            System.err.println("Ошибка: " + e.getMessage());
        }

        // Пример генерации и перехвата ArrayIndexOutOfBoundsException:
        int[] simpleArray = {10, 20, 30};
        try {
            int value = simpleArray[5]; // Пытаемся получить доступ к недопустимому индексу
            System.out.println(value); // Это не выполнится
        } catch (ArrayIndexOutOfBoundsException e) {
            System.err.println("Перехвачено ArrayIndexOutOfBoundsException: Индекс за пределами массива!");
        }
    }
}