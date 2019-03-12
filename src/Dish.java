import java.util.ArrayList;

public class Dish {

    String name;
    String [] ingredients;
    int preparationTime;
    String [] tags;
    String seasonRequirements; // this is for holiday and season-appropriate food
    static int dishQuantity = 0;
    static ArrayList<Dish> dishes = new ArrayList<Dish>();

    public Dish(String name, String[] ingredients, int preparationTime, String[] tags, String seasonRequirements) {
        this.name = name;
        this.ingredients = ingredients;
        this.preparationTime = preparationTime;
        this.tags = tags;
        this.seasonRequirements = seasonRequirements;
        dishQuantity++;
        dishes.add(this);
    }

    public String getName() {
        return name;
    }

    public String[] getIngredients() {
        return ingredients;
    }

    public int getPreparationTime() {
        return preparationTime;
    }

    public String[] getTags() {
        return tags;
    }

    public void setTags(String[] tags) {
        this.tags = tags;
    }

    public String getSeasonRequirements() {
        return seasonRequirements;
    }

    public static int getDishQuantity() {
        return dishQuantity;
    }

    public static ArrayList<Dish> getDishes() {
        return dishes;
    }
}
