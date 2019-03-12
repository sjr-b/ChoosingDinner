public class Runner {

    public static void main(String[] args) {
        // These are the default dishes.
        String [] latkeIngredients = {"potato", "pepper", "butter"};
        String [] latkeTags = {"favorite"};
        Dish latke = new Dish("latke", latkeIngredients, 60, latkeTags, "none");
        String [] stirFryIngredients = {"beef", "bell pepper", "onion", "water chesnut", "rice"};
        String [] stirFryTags = {""};
        Dish stirFry = new Dish("stir fry", stirFryIngredients, 45, stirFryTags, "none");
        String [] albondigasIngredients = {"beef", "rice", "egg", "celery", "carrot", "potato"};
        String [] albondigasTags = {""};
        Dish albondigas = new Dish("albondigas", albondigasIngredients, 90, albondigasTags, "winter");
        String [] porkAndSalsaIngredients = {"pork", "onion", "salsa", "green bean", "rice"};
        String [] porkAndSalsaTags = {""};
        Dish porkAndSalsa = new Dish("pork and salsa", porkAndSalsaIngredients,45, porkAndSalsaTags, "none");
        String [] beefAndPotatoesIngredients = {"beef", "potato", "onion", "mushroom"};
        String [] beefAndPotatoesTags = {""};
        Dish beefAndPotatoes = new Dish("beef and potatoes", beefAndPotatoesIngredients, 45, beefAndPotatoesTags, "none");
        String [] penneIngredients = {"chicken", "pesto", "penne"};
        String [] penneTags = {"favorite"};
        Dish penne = new Dish ("penne", penneIngredients, 30, penneTags, "none");
        String [] picnicIngredients = {"baguette", "pirociutto", "cheese", "apple", "roast beef", "salami", "fruit salad", "pasta salad"};
        String [] picnicTags = {"favorite"};
        Dish picnic = new Dish ("picnic dinner", penneIngredients, 10, penneTags, "summer");
        String [] tacosIngredients = {"chicken", "guacamole", "tortilla", "bean", "rice", "cilantro", "onion"};
        String [] tacosTags = {"favorite"};
        Dish tacos = new Dish ("chicken tacos", tacosIngredients, 20, tacosTags, "none");
    }

}