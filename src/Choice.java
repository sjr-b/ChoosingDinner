import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Scanner;
import java.util.Random;

public class Choice {

    Dish [] previousThree;
    String irreleventLines;
    boolean ableToDoMore;

    public Choice() {
        this.previousThree = new Dish [3];
        this.ableToDoMore = true;
        this.irreleventLines = "";
    }

    public String executeChoice(int option, Scanner sc){
        if (option == 1){ // choose a meal randomly -- INCORPORATE PREV THREE
            System.out.println(chooseDish(sc));
            return continueOrNot(sc);
        } else if (option == 2){ // list the dishes -- DONE
            System.out.println(listDishes());
            return continueOrNot(sc);
        } else if (option == 3){ // add a dish -- DOUBLE CHECK
            System.out.println(addDish(sc));
            return continueOrNot(sc);
        } else if (option == 4){ // remove a dish -- DONE
            System.out.println(removeDish(sc));
            return continueOrNot(sc);
        } else if (option == 5){ // add a tag to a dish -- TEST
            System.out.println(addTag(sc));
            return continueOrNot(sc);
        } else if (option == 6){ // input last three meals -- DONE
            System.out.println(inputLastThreeDays(sc));
            return continueOrNot(sc);
        }
        return "Oops, something went wrong. Did you input a valid number?";
    }

    public String chooseDish (Scanner sc){
        if (checkTodayForDishRequirement() > Dish.dishQuantity) {
            System.out.println("Please keep in mind that any restrictions you put on the dish will be overruled if a dish" +
                    " is mandatory for this day.");
            System.out.println("So if it is international pancake day, the only suggestion that you will recieve will" +
                    " be for pancakes.");
            System.out.println("Is there a tag that you would like to use? If so, please type the tag below. If not," +
                    " simply type 'no'.");
            this.irreleventLines = sc.nextLine();
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
            System.out.println("Is there a tag that you want to exclude? If so, please type the tag below. If not," +
                    " simply type 'no'.");
            String tagExclude = sc.nextLine();
            System.out.println("Are there any three ingredients that you would like to exclude? If so, please type them" +
                    " below. If not, just type 'no'.");
            String ingredient1Exclude = sc.nextLine();
            String ingredient2Exclude = sc.nextLine();
            String ingredient3Exclude = sc.nextLine();
            System.out.println("");
            return randomDish(tag, ingredient1, ingredient2, ingredient3, tagExclude, ingredient1Exclude, ingredient2Exclude, ingredient3Exclude);
        } else {
            int placement = checkTodayForDishRequirement();
            System.out.println("Your dish is: " + Dish.dishes.get(placement).name);
            System.out.println("This dish is made of: " + Dish.dishes.get(placement).getIngredients());
            return "This dish requires " + Dish.dishes.get(placement).getPreparationTime() + " minutes to cook.";
        }
    }

    public String randomDish(String tag, String ingredient1, String ingredient2, String ingredient3, String tagExclude, String ingredient1Exclude, String ingredient2Exclude, String ingredient3Exclude){
        ArrayList<Dish> options = Dish.dishes;
        options = includeWanted(options, tag);
        options = includeWanted(options, ingredient1);
        options = includeWanted(options, ingredient2);
        options = includeWanted(options, ingredient3);
        options = excludeUnwanted(options, tagExclude);
        options = excludeUnwanted(options, ingredient1Exclude);
        options = excludeUnwanted(options, ingredient2Exclude);
        options = excludeUnwanted(options, ingredient3Exclude);
        if (options.size() < 0){
            return "Oops! Your requirements were too strict, and none of the dishes satsify them. The program will now" +
                    " restart, and you can choose a new dish again. Please use less strict parameters. Thank you!";
        }
        int choiceSelection = new Random().nextInt(options.size());
        while (timeCheck(options.get(choiceSelection)) == false){
            choiceSelection = new Random().nextInt(options.size());
        }
        System.out.println("Your dish is: " + Dish.dishes.get(choiceSelection).name);
        System.out.println("This dish is made of: " + Dish.dishes.get(choiceSelection).getIngredients());
        return "This dish requires " + Dish.dishes.get(choiceSelection).getPreparationTime() + " minutes to cook.";
    }

    public ArrayList<Dish> includeWanted(ArrayList<Dish> options, String necessary){
        if (necessary.equals("no") == false) {
            for (int a = 0; a < options.size(); a++){
                if (Arrays.asList(options.get(a).tags).contains(necessary) == false && Arrays.asList(options.get(a).ingredients).contains(necessary) == false){
                    options.remove(a);
                    a--;
                }
                if (options.size() < 0){
                    System.out.println("Oops! Your parameters were too strict. Unfortunately, the program cannot take this. It will now restart.");
                    ArrayList<Dish> end = new ArrayList<Dish>();
                    return end;
                }
            }
        }
        return options;
    }

    public ArrayList<Dish> excludeUnwanted(ArrayList<Dish> options, String exclusion){
        if (exclusion.equals("no") == false){
            for (int a = 0; a < options.size(); a++){
                if (Arrays.asList(options.get(a).tags).contains(exclusion) || Arrays.asList(options.get(a).ingredients).contains(exclusion)){
                    options.remove(a);
                    a--;
                }
            }
        }
        return options;
    }

    public boolean timeCheck(Dish meal){
        if (meal.seasonRequirements != "none" && meal.seasonRequirements != getSeason()){
            return false;
        }
        this.previousThree[0] = Dish.dishes.get(0);
        this.previousThree[1] = Dish.dishes.get(1);
        this.previousThree[2] = Dish.dishes.get(2);
        for (int a = 0; a < 3; a++){
            if (this.previousThree[a] == meal){
                return false;
            }
        }
        return true;
    }

    public String getSeason(){
        int [] today = {Calendar.getInstance().get(Calendar.MONTH), Calendar.getInstance().get(Calendar.DAY_OF_MONTH)};
        if (today[0] < 2 || today[0] == 11 && today[1] >= 21 || today[0] == 2 && today[1] < 20){ // complete months of winter, first half of winter, second half
            return "winter";
        } else if (today[0] == 3 || today[0] == 4 || today[0] == 2 || today[0] == 5 && today[1] < 21){
            return "spring";
        } else if (today[0] == 6 || today[0] == 7 || today[0] == 5 || today[0] == 8 && today[1] < 22){
            return "summer";
        } else {
            return "fall";
        }
    }

    public String listDishes(){
        int amount = Dish.getDishQuantity();
        for (int a = 0; a < amount - 2; a++){
            String number = String.valueOf(a + 1);
            System.out.println( number + ". " + Dish.dishes.get(a).name + " (Cooking time: "
                    + String.valueOf(Dish.dishes.get(a).preparationTime) + ", Tags: "
                    + Dish.dishes.get(a).getTagsAsString() + ")");
        }
        return String.valueOf(amount) + ". " + Dish.dishes.get(amount - 1).name + " (Cooking time: "
                + String.valueOf(Dish.dishes.get(amount - 1).preparationTime) + ", tags: "
                + Dish.dishes.get(amount - 1).getTagsAsString() + ")";
    }

    public String addDish(Scanner sc){
        System.out.println("What do you want to name your dish?");
        this.irreleventLines += sc.nextLine();
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
            System.out.println("Please input all of the tags that you want to be attached to this dish.");
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
        return "Your dish '" + newDish.name + "' has been added to the list of options!";
    }

    public String removeDish(Scanner sc){
        System.out.println("Here is a list of the meals: ");
        System.out.println(listDishes());
        System.out.println("What meal would you like to delete? Please type the name with the correct capitalization" +
                " and spelling.");
        String dishName = sc.nextLine();
        for (int a = 0; a < Dish.dishes.size(); a++){
            if (dishName.equals(Dish.dishes.get(a).name)){
                Dish.dishes.remove(a);
                Dish.dishQuantity--;
                a--;
            }
        }
        return dishName + " has been deleted.";
    }

    public String addTag(Scanner sc){
        System.out.println("Here are all of the dishes, including their tags.");
        System.out.println(Dish.getNamesAsString());
        System.out.println("");
        System.out.println("Which dish do you want to add a tag too? Please make sure to type the name with the" +
                " correct spelling and capitalization.");
        this.irreleventLines = sc.nextLine();
        String dishName = sc.nextLine();
        String tag = "";
        for (int a = 0; a < Dish.dishQuantity; a++){
            if (dishName.equals(Dish.dishes.get(a).name)){
                System.out.println("Currently, the tags for " + dishName + " are as follows:");
                System.out.println(Dish.dishes.get(a).getTagsAsString());
                System.out.println("What tag would you like to add to the dish?");
                tag = sc.nextLine();
                String [] tags = new String [Dish.dishes.get(a).tags.length + 1];
                for (int b = 0; b < Dish.dishes.get(a).tags.length; b++){
                    tags[b] = Dish.dishes.get(a).tags[b];
                }
                tags[Dish.dishes.get(a).tags.length] = tag;
                Dish.dishes.get(a).setTags(tags);
                return "The tag '" + tag + "' has been added to the dish!";
            }
        }
        return "Oops! Something went wrong. You likely inputted the dish's name incorrectly. The process is now restarting.";
    }

    public String [] removeZeroPosition(String [] temporary){
        String [] result = new String [temporary.length-1];
        for (int a = 0; a < temporary.length-1; a++){
            result[a] = temporary[a+1];
        }
        return result;
    }

    public String inputLastThreeDays(Scanner sc){
        System.out.println("What were the last three meals that you had? Keep in mind, they have to be one of the" +
                " meals that are in this program. The meals are all listed below.");
        System.out.println(Dish.getNamesAsString());
        System.out.println("Okay, now please say what you had in the past few days.");
        System.out.print("What you eat three days ago?");
        System.out.println("");
        this.irreleventLines += sc.nextLine();
        String dishNameLast = sc.nextLine();
        inputIntoPreviousThreeArray(dishNameLast,2);
        System.out.println("What did you eat two days ago?");
        String dishNameMed = sc.nextLine();
        inputIntoPreviousThreeArray(dishNameMed, 1);
        System.out.println("What did you eat yesterday?");
        String dishNameYesterday = sc.nextLine();
        inputIntoPreviousThreeArray(dishNameYesterday, 0);
        return "Okay, tags have been added!";
    }

    public void inputIntoPreviousThreeArray(String dishName, int placementInArray){
        for (int a = 0; a < Dish.dishQuantity; a++){
            String name = Dish.dishes.get(a).name;
            if (dishName.equals(name)){
                previousThree[placementInArray] = Dish.dishes.get(a);
            }
        }
    }

    public String continueOrNot(Scanner sc){
        System.out.println("");
        System.out.println("Would you like to continue the program or quit it? If you would like to end this program," +
                " please type 'quit' (without the quotation marks).");
        System.out.println("If you want to continue, feel free to type anything else, or just hit enter.");
        this.irreleventLines = sc.nextLine();
        String result = sc.nextLine();
        if (result.equals("quit")){
            this.ableToDoMore = false;
            return "This program has ended! Hopefully you found something good to cook today. Come back soon!";
        } else {
            return "Thanks for sticking around! You can now choose what else you want to do.";
        }
    }

    public int checkTodayForDishRequirement(){
        for (int a = 0; a < Dish.dishQuantity; a++){
            if (Dish.dishes.get(a).day != null && Dish.dishes.get(a).day[0] == Calendar.getInstance().get(Calendar.MONTH)
            && Dish.dishes.get(a).day[1] == Calendar.getInstance().get(Calendar.DAY_OF_MONTH)){
                return a;
            }
        }
        return Dish.dishQuantity + 1000;
    }

}
