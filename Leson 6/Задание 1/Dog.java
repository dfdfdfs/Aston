class Dog extends Animal {
    private static int dogCount = 0;
    private final int maxRunDistance = 500;
    private final int maxSwimDistance = 10;

    public Dog(String name) {
        super(name);
        dogCount++;
    }

    public static int getDogCount() {
        return dogCount;
    }

    @Override
    public void run(int distance) {
        if (distance <= maxRunDistance) {
            super.run(distance);
        } else {
            System.out.println(name + " не может пробежать " + distance + " м. Максимальная дистанция для собаки " + maxRunDistance + " м.");
        }
    }

    @Override
    public void swim(int distance) {
        if (distance <= maxSwimDistance) {
            super.swim(distance);
        } else {
            System.out.println(name + " не может проплыть " + distance + " м. Максимальная дистанция для собаки " + maxSwimDistance + " м.");
        }
    }
}