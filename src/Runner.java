import java.util.Scanner;

public class Runner {

    public static void main(String[] args) {
        // These are the default dishes.
        String [] latkeIngredients = {"potato", "pepper", "butter"};
        String [] latkeTags = {"favorite"};
        Dish latke = new Dish("Latke", latkeIngredients, 60, latkeTags, "none");
        String [] stirFryIngredients = {"beef", "bell pepper", "onion", "water chesnut", "rice"};
        String [] stirFryTags = {""};
        Dish stirFry = new Dish("Stir fry", stirFryIngredients, 45, stirFryTags, "none");
        String [] albondigasIngredients = {"beef", "rice", "egg", "celery", "carrot", "potato"};
        String [] albondigasTags = {""};
        Dish albondigas = new Dish("Albondigas", albondigasIngredients, 90, albondigasTags, "winter");
        String [] porkAndSalsaIngredients = {"pork", "onion", "salsa", "green bean", "rice"};
        String [] porkAndSalsaTags = {""};
        Dish porkAndSalsa = new Dish("Pork and salsa", porkAndSalsaIngredients,45, porkAndSalsaTags, "none");
        String [] beefAndPotatoesIngredients = {"beef", "potato", "onion", "mushroom"};
        String [] beefAndPotatoesTags = {""};
        Dish beefAndPotatoes = new Dish("Beef and potatoes", beefAndPotatoesIngredients, 45, beefAndPotatoesTags, "none");
        String [] penneIngredients = {"chicken", "pesto", "penne"};
        String [] penneTags = {"favorite"};
        Dish penne = new Dish("Penne", penneIngredients, 30, penneTags, "none");
        String [] picnicIngredients = {"baguette", "pirociutto", "cheese", "apple", "roast beef", "salami", "fruit salad", "pasta salad"};
        String [] picnicTags = {"favorite"};
        Dish picnic = new Dish("Picnic dinner", penneIngredients, 10, penneTags, "summer");
        String [] tacosIngredients = {"chicken", "guacamole", "tortilla", "bean", "rice", "cilantro", "onion"};
        String [] tacosTags = {"favorite"};
        Dish tacos = new Dish("Chicken tacos", tacosIngredients, 20, tacosTags, "none");

        Scanner sc = new Scanner(System.in);
        System.out.println("This is a program designed to help you choose what to have for dinner. Here are some options for what you can do at this time:");
        System.out.println("1. Choose a completely random meal.");
        System.out.println("2. List the available meals.");
        System.out.println("3. Add a meal.");
        System.out.println("4. Add a tag to one of the existing meals.");
        System.out.println("5. Input what you've had for dinner in the past three days.");
        System.out.println("6. Quit program.");
        System.out.println("Please input the appropriate number for which option you would like to continue with.");
        int option = sc.nextInt();
        Choice ch = new Choice();
        System.out.println(ch.executeChoice(option));
    }

}