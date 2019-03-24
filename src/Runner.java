import java.util.Scanner;

public class Runner {

    public static void main(String[] args) {

        // MAKE SURE TO GO THROUGH EVERYTHING AT THE END AND MAKE IT READABLE!! - Sincerely, your past self who can't do
        // it now because she needs to go to the CCC

        // These are the default dishes.
        String [] latkeIngredients = {"potato", "pepper", "butter"};
        String [] latkeTags = {"favorite", "long"};
        Dish latke = new Dish("Latke", latkeIngredients, 60, latkeTags, "none", null);
        String [] stirFryIngredients = {"beef", "bell pepper", "onion", "water chestnut", "rice"};
        String [] stirFryTags = {""};
        Dish stirFry = new Dish("Stir fry", stirFryIngredients, 45, stirFryTags, "none", null);
        String [] albondigasIngredients = {"beef", "rice", "egg", "celery", "carrot", "potato"};
        String [] albondigasTags = {""};
        Dish albondigas = new Dish("Albondigas", albondigasIngredients, 90, albondigasTags, "winter", null);
        String [] porkAndSalsaIngredients = {"pork", "onion", "salsa", "green bean", "rice"};
        String [] porkAndSalsaTags = {""};
        Dish porkAndSalsa = new Dish("Pork and salsa", porkAndSalsaIngredients,45, porkAndSalsaTags, "none", null);
        String [] beefAndPotatoesIngredients = {"beef", "potato", "onion", "mushroom"};
        String [] beefAndPotatoesTags = {""};
        Dish beefAndPotatoes = new Dish("Beef and potatoes", beefAndPotatoesIngredients, 45, beefAndPotatoesTags, "none", null);
        String [] penneIngredients = {"chicken", "pesto", "penne"};
        String [] penneTags = {"favorite", "easy"};
        Dish penne = new Dish("Penne", penneIngredients, 30, penneTags, "none", null);
        String [] picnicIngredients = {"baguette", "pirociutto", "cheese", "apple", "roast beef", "salami", "fruit salad", "pasta salad"};
        String [] picnicTags = {"favorite"};
        Dish picnic = new Dish("Picnic dinner", penneIngredients, 10, penneTags, "summer", null);
        String [] tacosIngredients = {"chicken", "guacamole", "tortilla", "bean", "rice", "cilantro", "onion"};
        String [] tacosTags = {"favorite"};
        Dish tacos = new Dish("Chicken tacos", tacosIngredients, 20, tacosTags, "none", null);
        String [] haggisIngredients = {"liver", "heart", "onion", "pepper", "coriander seeds", "bouillon cube", "oatmeal"};
        String [] haggisTags = {""};
        int [] haggisDate = {0, 25};
        Dish haggis = new Dish("Haggis", haggisIngredients, 40, haggisTags, "none", haggisDate);
        String [] collegeSaladIngredients = {"lettuce", "olive oil", "dill", "salt", "pepper"};
        String [] collegeSaladTags = {"favorite", "cheap", "easy"};
//        int [] collegeSaladDate = {2, 24};
        Dish collegeSalad = new Dish("Cabbage salad", collegeSaladIngredients, 15, collegeSaladTags, "none", null);

        Scanner sc = new Scanner(System.in);
        Choice ch = new Choice();
        System.out.println("This is a program designed to help you choose what to have for dinner.");
        System.out.println("");
        while (ch.ableToDoMore){
            System.out.println("Here are some options for what you can do at this time:");
            System.out.println("1. Choose a meal.");
            System.out.println("2. List the available meals.");
            System.out.println("3. Add a meal.");
            System.out.println("4. Remove a meal.");
            System.out.println("5. Add a tag to one of the existing meals.");
            System.out.println("6. Input what you've had for dinner in the past three days.");
            System.out.println("Please input the appropriate number for which option you would like to continue with.");
            int option = sc.nextInt();
            System.out.println(ch.executeChoice(option, sc));
            System.out.println("");
            System.out.println(" --- ");
            System.out.println("");
        }
    }

}