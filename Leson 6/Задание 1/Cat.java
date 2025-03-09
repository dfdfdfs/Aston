class Cat extends Animal {
    private static int catCount = 0;
    private final int maxRunDistance = 200;
    private boolean isFull = false; // Поле сытости
    
    public Cat(String name) {
        super(name);
        catCount++;
    }

    public static int getCatCount() {
        return catCount;
    }

    @Override
    public void run(int distance) {
        if (distance <= maxRunDistance) {
            super.run(distance);
        } else {
            System.out.println(name + " не может пробежать " + distance + " м. Максимальная дистанция для кота " + maxRunDistance + " м.");
        }
    }

    @Override
    public void swim(int distance) {
        System.out.println(name + " не умеет плавать.");
    }

    public boolean isFull() {
        return isFull;
    }

    public void setFull(boolean full) {
        isFull = full;
    }
}