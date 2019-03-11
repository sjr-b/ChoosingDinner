public class Dish {

    String name;
    String [] ingredients;
    int preparationTime;
    String [] tags;
    String seasonRequirements; // this is for holiday and season-appropriate food

    public Dish(String name, String[] ingredients, int preparationTime, String[] tags, String seasonRequirements) {
        this.name = name;
        this.ingredients = ingredients;
        this.preparationTime = preparationTime;
        this.tags = tags;
        this.seasonRequirements = seasonRequirements;
    }

}
