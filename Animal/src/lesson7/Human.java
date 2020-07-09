package lesson7;

public class Human implements PuttingFood, Runnable {
    private Bowl bowl;
    private int meal = 20;

    @Override
    public void run() {
        Thread current = Thread.currentThread();
        while (!current.isInterrupted()) {
            putFood(meal);
            System.out.printf("Human add %d servings. %d servings left\n", meal, bowl.getMeal());
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                break;
            }
        }
    }

    @Override
    public void takeBowl(Bowl bowl) {
        this.bowl = bowl;
    }

    @Override
    public void putFood(int meal) {
        if (bowl != null) {
            bowl.putMeal(meal);
        }
    }
}
