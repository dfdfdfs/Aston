import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PhoneBook {
    // Хранит фамилии и соответствующие им номера телефонов
    private Map<String, List<String>> phoneBook;

    // Конструктор
    public PhoneBook() {
        phoneBook = new HashMap<>();
    }

    // Метод для добавления записи
    public void add(String lastName, String phoneNumber) {
        // Если фамилия уже существует, добавляем номер в существующий список
        if (!phoneBook.containsKey(lastName)) {
            phoneBook.put(lastName, new ArrayList<>());
        }
        phoneBook.get(lastName).add(phoneNumber);
    }

    // Метод для получения номеров телефонов по фамилии
    public List<String> get(String lastName) {
        return phoneBook.getOrDefault(lastName, new ArrayList<>());
    }

    // Пример использования
    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();
        
        // Добавляем записи
        phoneBook.add("Иванов", "123-456");
        phoneBook.add("Иванов", "789-012");
        phoneBook.add("Петров", "345-678");
        
        // Получаем номера телефонов по фамилии
        System.out.println("Телефоны Иванова: " + phoneBook.get("Иванов"));
        System.out.println("Телефоны Петрова: " + phoneBook.get("Петров"));
     //   System.out.println("Телефоны Сидорова: " + phoneBook.get("Сидоров")); // Не существует
    }
}
