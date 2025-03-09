class Bowl {
    private int food;

    public Bowl(int food) {
        this.food = food;
    }

    public int getFood() {
        return food;
    }

    public void setFood(int food) {
        if (food >= 0) {
            this.food = food;
        } else {
            System.out.println("Нельзя положить отрицательное количество еды в миску!");
        }
    }

    public void addFood(int amount) {
        if (amount > 0) {
            food += amount;
            System.out.println("В миску добавлено " + amount + " еды.");
        } else {
            System.out.println("Нельзя добавить отрицательное или нулевое количество еды.");
        }
    }
}