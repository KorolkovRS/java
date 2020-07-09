package lesson7;

/**
 * Миска, из котрой можно есть.
 * Поле meal - количество еды в миске.
 */

public class Bowl {
    private int meal;

    /**
     * Положить еду в миску.
     * @param quantity количество еды, которое необходимо полдожить в миску.
     */
    public synchronized void putMeal(int quantity) {
        meal += quantity;
    }

    /**
     * Геттер.
     * @return meal.
     */
    public int getMeal() {
        return meal;
    }

    /**
     * Забрать еду из миски.
     * @param takingMeal количество еды, котророе необходимо взять.
     * @return takingMeal, если в миске есть необходимое количество еды или meal, если еды недостаточно.
     */
    public synchronized int takeMeal(int takingMeal) {
        if (meal >= takingMeal) {
            meal -= takingMeal;
            return takingMeal;
        } else {
            int temp = meal;
            meal = 0;
            return temp;
        }
    }

    public boolean isEmpty() {
        return (meal == 0);
    }

    @Override
    public String toString() {
        return meal + " servings of food";
    }
}
