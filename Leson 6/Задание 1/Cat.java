
public class Cat extends Animal {
    private static int catCount = 0;
    private boolean isFull; // Indicates if the cat is full

    public Cat(String name) {
        super(name, 200, 0);  // Cat's run limit is 200m, swim limit is 0m (can't swim)
        this.isFull = false; // Cats are hungry by default
        catCount++;
    }

    public static int getCatCount() {
        return catCount;
    }

    public boolean isFull() {
        return isFull;
    }

    public void eat(Bowl bowl, int amount) {
        if (bowl.getFoodAmount() >= amount) {
            bowl.decreaseFood(amount);
            isFull = true;
            System.out.println(name + " ate " + amount + " food from the bowl.");
        } else {
            System.out.println(name + " didn't eat because there wasn't enough food in the bowl.");
        }
    }

    public void setFull(boolean full) {
        isFull = full;
    }
}