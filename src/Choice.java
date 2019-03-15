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
        while (timeCheck(options.get(choiceSelection)) == false){ // WORK ON SEASON CHECK!
            choiceSelection = new Random().nextInt(Dish.dishQuantity);
        }
        String choiceInfo = "Your dish is: " + Dish.dishes.get(choiceSelection).name
                + " || This dish is made of: " + Dish.dishes.get(choiceSelection).getIngredients()
                + " || This dish requires " + Dish.dishes.get(choiceSelection).getPreparationTime() + " minutes to cook.";
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
        String result = necessary;
        if (result != "no" == false) {
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
        int [] today = {Calendar.getInstance().get(Calendar.MONTH), Calendar.getInstance().get(Calendar.DAY_OF_MONTH)};
        if (today[0] < 2 || today[0] == 11 && today[1] >= 21 || today[0] == 2 && today[1] < 20){ // complete months of winter, first half of winter, second half
            return "winter";
        } else if (today[0] == 3 || today[0] == 4 || today[0] == 2 && today[1] >= 20 || today[0] == 5 && today[1] < 21){
            return "spring";
        } else if (today[0] == 6 || today[0] == 7 || today[0] == 5 && today[1] >= 21 || today[0] == 8 && today[1] < 22){
            return "summer";
        } else {
            return "fall";
        }
    }

    public boolean timeCheck(Dish meal){
        if (meal.day != null && meal.day[0] != Calendar.getInstance().get(Calendar.MONTH) && meal.day[1] != Calendar.getInstance().get(Calendar.DAY_OF_MONTH)){
            return false;
        }
        if (meal.seasonRequirements != "none" && meal.seasonRequirements != seasonCheck()){
            return false;
        }
        return true;
    }

}
