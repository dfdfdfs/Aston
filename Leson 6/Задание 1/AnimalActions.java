import java.util.Random;

public class AnimalActions {

    public void runSimulation() {
        // Create animals
        Dog dogBobik = new Dog("Bobik");
        Cat catBarsik = new Cat("Barsik");
        Cat catMurzik = new Cat("Murzik");

        // Test animal actions
        dogBobik.run(400);
        dogBobik.swim(8);
        catBarsik.run(150);
        catBarsik.swim(5); // Cats can't swim

        // Animal counts
        System.out.println("Total animals: " + Animal.getAnimalCount());
        System.out.println("Total dogs: " + Dog.getDogCount());
        System.out.println("Total cats: " + Cat.getCatCount());

        // Feeding the cats
        Bowl bowl = new Bowl(50);
        Cat[] cats = {catBarsik, catMurzik};

        feedCats(cats, bowl);

        // Print cat satiety information
        for (Cat cat : cats) {
            System.out.println(cat.getName() + " is full: " + cat.isFull());
        }

        // Add more food to the bowl
        bowl.addFood(30);
        feedCats(cats, bowl);

        // Print updated cat satiety information
        for (Cat cat : cats) {
            System.out.println(cat.getName() + " is full: " + cat.isFull());
        }
    }

    private void feedCats(Cat[] cats, Bowl bowl) {
        Random random = new Random();
        for (Cat cat : cats) {
            if (!cat.isFull()) {
                int amountToEat = random.nextInt(30) + 5; // Cats want to eat between 5 and 34 food
                cat.eat(bowl, amountToEat);
            } else {
                System.out.println(cat.getName() + " is already full.");
            }
        }
    }
}