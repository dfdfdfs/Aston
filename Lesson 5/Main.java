import java.util.Arrays;

// Класс "Товар"
class Product {
    private String name;
    private String productionDate;
    private String manufacturer;
    private String countryOfOrigin;
    private int price;
    private boolean isReserved;

    // Конструктор класса
    public Product(String name, String productionDate, String manufacturer, String countryOfOrigin, int price, boolean isReserved) {
        this.name = name;
        this.productionDate = productionDate;
        this.manufacturer = manufacturer;
        this.countryOfOrigin = countryOfOrigin;
        this.price = price;
        this.isReserved = isReserved;
    }

    // Метод для вывода информации об объекте в консоль
    public void displayInfo() {
        System.out.println("Название: " + name);
        System.out.println("Дата производства: " + productionDate);
        System.out.println("Производитель: " + manufacturer);
        System.out.println("Страна происхождения: " + countryOfOrigin);
        System.out.println("Цена: " + price);
        System.out.println("Состояние бронирования: " + (isReserved ? "Забронировано" : "Не забронировано"));
        System.out.println("-----------------------");
    }
}

// Класс "Park" с внутренним классом
class Park {
    private String name;
    private Attraction[] attractions;

    public Park(String name, Attraction[] attractions) {
        this.name = name;
        this.attractions = attractions;
    }

    // Внутренний класс "Attraction"
    static class Attraction {
        private String attractionName;
        private String operatingHours;
        private double cost;

        public Attraction(String attractionName, String operatingHours, double cost) {
            this.attractionName = attractionName;
            this.operatingHours = operatingHours;
            this.cost = cost;
        }

        public void displayAttractionInfo() {
            System.out.println("Аттракцион: " + attractionName);
            System.out.println("Время работы: " + operatingHours);
            System.out.println("Стоимость: " + cost);
            System.out.println("-----------------------");
        }
    }
    public void displayParkInfo() {
        System.out.println("Парк: " + name);
        for (Attraction attraction : attractions) {
            attraction.displayAttractionInfo();
        }
    }
}

public class Main {
    public static void main(String[] args) {
        // 2. Создание массива из 5 товаров
        Product[] productsArray = new Product[5];
        productsArray[0] = new Product("Samsung S25 Ultra", "01.02.2025", "Samsung Corp.", "Korea", 5599, true);
        productsArray[1] = new Product("Iphone 15 Pro", "15.09.2024", "Apple", "USA", 1199, false);
        productsArray[2] = new Product("Sony WH-1000XM5", "05.05.2022", "Sony", "Japan", 349, true);
        productsArray[3] = new Product("Canon EOS R6", "20.07.2020", "Canon", "Japan", 2499, false);
        productsArray[4] = new Product("LG OLED TV", "10.03.2023", "LG", "South Korea", 1999, true);

        // Вывод информации о товарах
        System.out.println("Информация о товарах:");
        for (Product product : productsArray) {
            product.displayInfo();
        }

        // 3. Создание класса Park с внутренним классом
        Park.Attraction[] attractions = new Park.Attraction[3];
        attractions[0] = new Park.Attraction("Американские горки", "10:00 - 22:00", 15.0);
        attractions[1] = new Park.Attraction("Колесо обозрения", "11:00 - 23:00", 10.0);
        attractions[2] = new Park.Attraction("Карусель", "10:00 - 21:00", 5.0);

        Park park = new Park("Парк развлечений", attractions);

        park.displayParkInfo();
    }
}