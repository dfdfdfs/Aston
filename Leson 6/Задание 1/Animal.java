
public abstract class Animal {
    protected String name;
    protected int runLimit;
    protected int swimLimit;
    private static int animalCount = 0;

    public Animal(String name, int runLimit, int swimLimit) {
        this.name = name;
        this.runLimit = runLimit;
        this.swimLimit = swimLimit;
        animalCount++;
    }

    public void run(int distance) {
        if (distance <= runLimit) {
            System.out.println(name + " ran " + distance + " m.");
        } else {
            System.out.println(name + " could not run " + distance + " m. Max distance is " + runLimit + " m.");
        }
    }

    public void swim(int distance) {
        if (swimLimit == 0) {
            System.out.println(name + " can't swim.");
            return;
        }

        if (distance <= swimLimit) {
            System.out.println(name + " swam " + distance + " m.");
        } else {
            System.out.println(name + " could not swim " + distance + " m. Max distance is " + swimLimit + " m.");
        }
    }

    public String getName() {
        return name;
    }

    public static int getAnimalCount() {
        return animalCount;
    }
}