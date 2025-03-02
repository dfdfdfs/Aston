// Животное
class Animal {
    private static int animalCount = 0;
    protected String name;

    public Animal(String name) {
        this.name = name;
        animalCount++;
    }

    public void run(int distance) {
        System.out.println(name + " пробежал " + distance + " м.");
    }

    public void swim(int distance) {
        System.out.println(name + " проплыл " + distance + " м.");
    }


    public static int getAnimalCount() {
        return animalCount;
    }
}

// Кот
class Cat extends Animal {
    private static int catCount = 0;
    private boolean satiety;
    private final int maxRunDistance = 200;


    public Cat(String name) {
        super(name);
        catCount++;
        this.satiety = false; // коты при создании голодны
    }


    @Override
    public void run(int distance) {
        if (distance <= maxRunDistance) {
            System.out.println(name + " пробежал " + distance + " м.");
        } else {
            System.out.println(name + " не может пробежать " + distance + " м. Максимальная дистанция: " + maxRunDistance + " м.");
        }
    }

    @Override
    public void swim(int distance) {
        System.out.println("Коты не умеют плавать.");
    }


    public boolean isSatiety() {
        return satiety;
    }

    public void setSatiety(boolean satiety) {
        this.satiety = satiety;
    }


    public void eat(Bowl bowl) {
        if (bowl.getFoodAmount() > 0) {
            if (bowl.getFoodAmount() >= 0) { // Проверка, хватает ли еды в миске
                bowl.decreaseFood(bowl.getFoodAmount());
                setSatiety(true);
                System.out.println(name + " поел из миски.");


            } else {
                System.out.println(name + " не стал есть, недостаточно еды в миске.");
            }
        } else {
            System.out.println("В миске нет еды!");
        }
    }



    public static int getCatCount() {
        return catCount;
    }
}

// Собака
class Dog extends Animal {
    private static int dogCount = 0;
    private final int maxRunDistance = 500;
    private final int maxSwimDistance = 10;

    public Dog(String name) {
        super(name);
        dogCount++;
    }

    @Override
    public void run(int distance) {
        if (distance <= maxRunDistance) {
            System.out.println(name + " пробежал " + distance + " м.");
        } else {
            System.out.println(name + " не может пробежать " + distance + " м. Максимальная дистанция: " + maxRunDistance + " м.");
        }
    }

    @Override
    public void swim(int distance) {
        if (distance <= maxSwimDistance) {
            System.out.println(name + " проплыл " + distance + " м.");
        } else {
            System.out.println(name + " не может проплыть " + distance + " м. Максимальная дистанция: " + maxSwimDistance + " м.");
        }
    }

    public static int getDogCount() {
        return dogCount;
    }
}


// Миска
class Bowl {
    private int foodAmount;

    public Bowl(int foodAmount) {
        this.foodAmount = foodAmount;
    }

    public int getFoodAmount() {
        return foodAmount;
    }

    public void decreaseFood(int amount) {
        if (foodAmount >= amount) {
            foodAmount -= amount;
        } else {
            foodAmount = 0; // Чтобы не было отрицательного количества еды
        }

    }

    public void addFood(int amount) {
        foodAmount += amount;
        System.out.println("В миску добавлено " + amount + " еды.");
    }
}


public class Main {
    public static void main(String[] args) {

        Cat cat1 = new Cat("Барсик");
        Cat cat2 = new Cat("Мурка");
        Cat cat3 = new Cat("Пушок");

        Dog dog1 = new Dog("Бобик");
        Dog dog2 = new Dog("Рекс");

        System.out.println("Количество котов: " + Cat.getCatCount());
        System.out.println("Количество собак: " + Dog.getDogCount());
        System.out.println("Количество животных: " + Animal.getAnimalCount());


        Bowl bowl = new Bowl(50);
        System.out.println("Количество еды в миске: " + bowl.getFoodAmount());

        Cat[] cats = {cat1, cat2, cat3};

        for (Cat cat : cats) {
            cat.eat(bowl);
            System.out.println(cat.name + " сытость: " + cat.isSatiety());
        }


        System.out.println("Количество еды в миске после еды котов: " + bowl.getFoodAmount());

        bowl.addFood(30);
        System.out.println("Количество еды в миске после добавления: " + bowl.getFoodAmount());


        dog1.run(400);
        dog2.swim(5);

        cat1.run(250);
        cat2.swim(2);
    }
}