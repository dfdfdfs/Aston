
public class Dog extends Animal {
    private static int dogCount = 0;

    public Dog(String name) {
        super(name, 500, 10);  // Dog's run limit is 500m, swim limit is 10m
        dogCount++;
    }

    public static int getDogCount() {
        return dogCount;
    }
}