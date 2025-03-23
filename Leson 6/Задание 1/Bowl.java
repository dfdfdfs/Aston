
public class Bowl {
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
            foodAmount = 0; // Prevents negative food amount
        }
    }

    public void addFood(int amount) {
        foodAmount += amount;
        System.out.println("Added " + amount + " food to the bowl.");
    }
}