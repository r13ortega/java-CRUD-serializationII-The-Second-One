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
    }
}
