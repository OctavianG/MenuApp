package app.menuapp;

public class Food {

    private String foodName;
    private String category;
    private int weight;
    private double calories;

    public Food(String foodName, String category, int weight, double calories) {
        this.foodName = foodName;
        this.category = category;
        this.weight = weight;
        this.calories = calories * (weight / 100d);
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getWeight() {
        return this.weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public double getCalories() {
        return this.calories;
    }

    // calories for the hole food
    public void setCalories (double calories) {
        this.calories = calories * ( double) this.weight / 100d;
    }

    @Override
    public String toString() {
        return foodName + ";" + category + ";" + weight + ";" + calories;
    }
}
