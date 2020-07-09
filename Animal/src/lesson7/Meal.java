package lesson7;

public class Meal {
    private  String name;
    private int nutritionalValue;

    public Meal(String name, int nutritionalValue) {
        this.name = name;
        setNutritionalValue(nutritionalValue);
    }

    private void setNutritionalValue(int nutritionalValue) {
        if (nutritionalValue >= 0) {
            this.nutritionalValue = nutritionalValue;
        }
        else {
            this.nutritionalValue = 0;
        }
    }

    @Override
    public String toString() {
        return String.format("Nutritional value = %d kkal", nutritionalValue);
    }

    @Override
    public int hashCode() {
        return nutritionalValue;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Meal) {
            if (this.nutritionalValue == ((Meal) obj).nutritionalValue) {
                return true;
            }
        }
        return false;
    }
}
