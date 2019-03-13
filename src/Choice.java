import java.util.Calendar;
import java.util.Random;

public class Choice {

    Dish [] previousThree;

    public Choice() {
        this.previousThree = new Dish [3];
    }

    public String executeChoice(int option){
        if (option == 1){
            return chooseDish();
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

    public String chooseDish(){
        int choiceSelection = new Random().nextInt(Dish.dishQuantity);
        while (Dish.dishes.get(choiceSelection).day[0] == Calendar.getInstance().get(Calendar.MONTH)
                && Dish.dishes.get(choiceSelection).day[1] == Calendar.getInstance().get(Calendar.DAY_OF_MONTH)
                /*|| Dish.dishes.get(choiceSelection).seasonRequirements == Calendar.getInstance().getCalendarType(Calendar.S)*/
                ){ // work on the seasons
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

}
