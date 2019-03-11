public class Dish {

    String name;
    String [] tags;
    int preparationTime;
    String time; // this is for holiday and season-appropriate food
    String [] ingredients;

    public Dish(String[] tags, int preparationTime, String time, String[] ingredients) {
        this.tags = tags;
        this.preparationTime = preparationTime;
        this.time = time;
        this.ingredients = ingredients;
    }
}
