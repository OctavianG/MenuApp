package app.menuapp;

public class Food {

    private String foodName;
    private String category;
    private int weight;
    private float calories;

    public Food(String foodName, String category, int weight, int calories) {
        this.foodName = foodName;
        this.category = category;
        this.weight = weight;
        this.calories = calories * (weight / 100);
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
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public float getCalories() {
        return calories;
    }

    // calories for the hole food
    public void setCalories(float calories) {
        this.calories = calories * ((float) this.weight / 100);
    }
}
