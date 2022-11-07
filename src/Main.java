import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<BoardGame> list = new ArrayList<>();
        Scanner scan = new Scanner(System.in);

        System.out.println("Hello, Welcome to Jurassic... um I mean Game Board Manager" +
                "Now would you like to load your data?" +
                "Type (Yes) to load" +
                "Type (No) to continue without loading");
        String answer = scan.nextLine();
        if (answer.equalsIgnoreCase("Yes")){
            Serialization.loadData(list);
        } else if (answer.equalsIgnoreCase("No")) {
            System.out.println("moving to the CRUD");
        }
        MyMethods.CRUD(list);

        System.out.println("Now would you like to save your new BoardGame List?" +
                "Type (Yes) to save your list" +
                "or hit ENTER to end the Board Game Manager");
        String end = scan.nextLine();
        if (end.equalsIgnoreCase("Yes")){
            Serialization.saveData(list);
            System.out.println("data has been saved successfully..." +
                    "or it looks like it anyways :)");
        }
        System.out.println("Ending.... Good Bye");
    }
}
