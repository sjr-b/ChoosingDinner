import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Scanner;
import java.util.Random;

public class Choice {

    Dish [] previousThree;

    public Choice() {
        this.previousThree = new Dish [3];
    }

    public String executeChoice(int option){
        if (option == 1){
            Scanner sc = new Scanner(System.in);
            System.out.println("Are there a tag that you would like to use? If so, please type the tag below. If not," +
                    " simply type 'no'.");
            String tag = sc.nextLine();
            System.out.println("Are there any ingredients that you would like to use? You may specify up to three " +
                    "ingredients. ");
            System.out.println("Please make sure to type them in singular form (so do not say 'potatoes', say 'potato'). " +
                    "If you don't want to specify any specific ingredients, just type 'no'.");
            System.out.println("Now please type in the three ingredients that you want to use. " +
                    "Just type 'no' three times if you don't want to use any.");
            String ingredient1 = sc.nextLine();
            String ingredient2 = sc.nextLine();
            String ingredient3 = sc.nextLine();
            return chooseDish(tag, ingredient1, ingredient2, ingredient3);
        } else if (option == 2){
            return listDishes();
        } else if (option == 3){

        } else if (option == 4){

        } else if (option == 5){

        } else if (option == 6){

        }
        return "Oops! Something went wrong. Please make sure that you only inputted one digit, " +
                "and that that digit is a valid option";
    }

    public String chooseDish(String tag, String ingredient1, String ingredient2, String ingredient3){
        ArrayList<Dish> options = Dish.dishes;
        options = removeUnwanted(options, tag);
        options = removeUnwanted(options, ingredient1);
        options = removeUnwanted(options, ingredient2);
        options = removeUnwanted(options, ingredient3);
        int choiceSelection = new Random().nextInt(options.size());
        while (Dish.dishes.get(choiceSelection).day[0] == Calendar.getInstance().get(Calendar.MONTH)
                && Dish.dishes.get(choiceSelection).day[1] == Calendar.getInstance().get(Calendar.DAY_OF_MONTH)
                || Dish.dishes.get(choiceSelection).seasonRequirements == seasonCheck()){ // WORK ON SEASON CHECK!
            choiceSelection = new Random().nextInt(Dish.dishQuantity);
        }
        String choiceInfo = "Your dish is " + Dish.dishes.get(choiceSelection).name
                + ". This dish is made of " + Dish.dishes.get(choiceSelection).getIngredients()
                + ", and requires " + Dish.dishes.get(choiceSelection).getPreparationTime() + " to cook.";
        /* keep going here */
        return choiceInfo;
    }

    public String listDishes(){
        String result = "";
        for (int a = 0; a < Dish.dishQuantity; a++){
            String number = String.valueOf(a);
            result += number + ". " + Dish.dishes.get(a).name + " (Cooking time: "
                    + String.valueOf(Dish.dishes.get(a).preparationTime) + ", Tags: "
                    + Dish.dishes.get(a).getTags() + ") || ";
        }
        result = result.substring(0, result.length() - 4);
        return result;
    }

    public ArrayList<Dish> removeUnwanted(ArrayList<Dish> options, String necessary){
        if (necessary != "no") {
            for (int a = 0; a < options.size(); a++){
                if (Arrays.asList(options.get(a).tags).contains(necessary) == false){
                    options.remove(a);
                    a--;
                }
            }
        }
        return options;
    }

    public String seasonCheck(){
        String season = "";
        int [] today = {Calendar.getInstance().get(Calendar.MONTH), Calendar.getInstance().get(Calendar.DAY_OF_MONTH)};
        if (today[0] < 2 || today[0] == 11 && today[1] >= 21 || today[0] == 2 && today[1] < 20){ // complete months of winter, first half of winter, second half
            season = "winter";
        } // spring: complete, first, second
        return season;
    }

}
