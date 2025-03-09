import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Создание животных
        Dog dog1 = new Dog("Бобик");
        Cat cat1 = new Cat("Мурзик");
        Cat cat2 = new Cat("Васька");

        // Действия животных
        dog1.run(600);
        dog1.run(400);
        dog1.swim(5);
        cat1.run(150);
        cat1.swim(15);

        // Подсчет созданных животных
        System.out.println("Всего животных: " + Animal.getAnimalCount());
        System.out.println("Собак: " + Dog.getDogCount());
        System.out.println("Котов: " + Cat.getCatCount());

        // Работа с миской и котами
        Bowl bowl = new Bowl(30);
        List<Cat> cats = new ArrayList<>();
        cats.add(cat1);
        cats.add(cat2);

        // Покормить котов
        for (Cat cat : cats) {
            int amountToEat = (int) (Math.random() * 20) + 1; // Случайное количество еды для кота
            if (bowl.getFood() >= amountToEat) {
                bowl.setFood(bowl.getFood() - amountToEat);
                cat.setFull(true);
                System.out.println(cat.name + " съел " + amountToEat + " еды. В миске осталось " + bowl.getFood() + " еды.");
            } else {
                System.out.println(cat.name + " не смог покушать, еды в миске недостаточно.");
            }
        }

        // Вывести информацию о сытости котов
        System.out.println("\nИнформация о сытости котов:");
        for (Cat cat : cats) {
            System.out.println(cat.name + ": " + (cat.isFull() ? "Сыт" : "Голоден"));
        }

        // Добавить еду в миску
        bowl.addFood(20);
    }
}