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
        return "Oops! Something went wrong. Please make sure that you only inputted one digit, and that that digit is a valid option";
    }

    public String chooseDish(){
        int choice = new Random().nextInt(Dish.dishQuantity);
        String choiceName = "";
        return choiceName;
    }

    public String listDishes(){
        String result = "";
        for (int a = 0; a < Dish.dishQuantity; a++){
            String number = String.valueOf(a);
            result += number + ". " + Dish.dishes.get(a).name + " (Cooking time: " + String.valueOf(Dish.dishes.get(a).preparationTime) + ", Tags: " + Dish.dishes.get(a).getTags() + ") || ";
        }
        result = result.substring(0, result.length() - 4);
        return result;
    }

}
