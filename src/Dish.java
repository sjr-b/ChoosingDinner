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
        return this.name;
    }

    public String[] getIngredients() {
        return this.ingredients;
    }

    public int getPreparationTime() {
        return this.preparationTime;
    }

    public String getTags() {
        String result = "";
        for (int a = 0; a < this.tags.length; a++){
            if (tags[a] != ""){
                result += tags[a] + ", ";
            } else {
                result += "none, ";
            }
        }
        result = result.substring(0, result.length() - 2);
        return result;
    }

    public void setTags(String[] tags) {
        this.tags = tags;
    }

    public String getSeasonRequirements() {
        return this.seasonRequirements;
    }

    public static int getDishQuantity() {
        return dishQuantity;
    }

    public static ArrayList<Dish> getDishes() {
        return dishes;
    }
}
