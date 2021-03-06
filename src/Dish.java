import java.util.ArrayList;

public class Dish {

    String name;
    String [] ingredients;
    int preparationTime;
    String [] tags;
    String seasonRequirements; // this is for holiday and season-appropriate food
    int [] day;
    static int dishQuantity = 0;
    static ArrayList<Dish> dishes = new ArrayList<Dish>();

    public Dish(String name, String[] ingredients, int preparationTime, String[] tags, String seasonRequirements, int [] day) {
        this.name = name;
        this.ingredients = ingredients;
        this.preparationTime = preparationTime;
        this.tags = tags;
        this.seasonRequirements = seasonRequirements;
        this.day = day;
        dishQuantity++;
        dishes.add(this);
    }

    public String getIngredients() {
        String ingredientList = "";
        for (int a = 0; a < this.ingredients.length; a++){
            ingredientList += this.ingredients[a] + ", ";
        }
        ingredientList = ingredientList.substring(0, ingredientList.length() - 2);
        return ingredientList;
    }

    public int getPreparationTime() {
        return this.preparationTime;
    }

    public String getTagsAsString() {
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

}
