import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Scanner;
import java.util.Random;

public class Choice {

    Dish [] previousThree;
    boolean ableToDoMore;

    public Choice() {
        this.previousThree = new Dish [3];
        this.ableToDoMore = true;
    }

    public String executeChoice(int option){
        if (option == 1){ // choose a meal
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
        } else if (option == 2){ // list options
            return listDishes();
        } else if (option == 3){ // add a dish
            Scanner sc = new Scanner(System.in);
            System.out.println("What do you want to name your dish?");
            String name = sc.nextLine();
            System.out.println("How many ingredients does it take to make this dish?");
            int ingredientAmount = sc.nextInt();
            String [] temporaryList = new String [ingredientAmount+1];
            System.out.println("Please write down all of the ingredients in singular form and in lower case (so instead of saying " +
                    "'Potatoes', say 'potato'). After each ingredient, hit enter, and then type in the next ingredient.");
            for (int a = 0; a <= ingredientAmount; a++){
                temporaryList[a] = sc.nextLine();
            }
            String [] ingredientList = removeZeroPosition(temporaryList);
            System.out.println("How long does it take to cook this dish?");
            int time = sc.nextInt();
            System.out.println("How many tags do you want to add to this dish? Please only respond with a number.");
            int tagNumber = sc.nextInt();
            String [] tags = new String [tagNumber];
            if (tagNumber != 0){
                System.out.println("Please input all of the tags that you want to be attatched to this dish.");
                String [] tagsTemporary = new String [tagNumber+1];
                for (int b = 0; b <= tagNumber; b++){
                    tagsTemporary[b] = sc.nextLine();
                }
                tags = removeZeroPosition(tagsTemporary);
            } else {
                tags[0] = "";
            }
            System.out.println("Are there any seasonal requirements for this dish? Can it only be cooked during a " +
                    "particular season? If so, type the name of that season (winter, spring, summer, fall). If not, just say 'no'.");
            String season = sc.nextLine();
            System.out.println("Can this dish only be eaten on a certain day? If so, say yes. If not, say no.");
            String dayRequirementConfirm = sc.nextLine();
            int [] day = new int [2];
            if (dayRequirementConfirm.equals("yes")){
                System.out.println("What is the number of the month? Please remember to start counting at 0. So 0 is " +
                        "January, 1 is February, etc.");
                day[0] = sc.nextInt();
                System.out.println("What is the day? You don't have to start the counting from zero on this one.");
                day[1] = sc.nextInt();
            } else {
                day = null;
            }
            Dish newDish = new Dish(name, ingredientList, time, tags, season, day);
            return "Your dish '" + name + "' has been added to the list of options!";
        } else if (option == 4){ // remove a dish

        } else if (option == 5){ // add a tag to a dish

        } else if (option == 6){ // input last three meals

        } else if (option == 7){ // end the program
            ableToDoMore = false;
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

    public String createDish(){
        String informUser = "You have created ";
        return informUser;
    }

    public ArrayList<Dish> removeUnwanted(ArrayList<Dish> options, String necessary){
        if (necessary.equals("no") == false) {
            for (int a = 0; a < options.size(); a++){
                if (Arrays.asList(options.get(a).tags).contains(necessary) == false && Arrays.asList(options.get(a).ingredients).contains(necessary) == false){
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

    public String [] removeZeroPosition(String [] temporary){
        String [] result = new String [temporary.length-1];
        for (int a = 0; a < temporary.length-1; a++){
            result[a] = temporary[a+1];
        }
        return result;
    }

}
