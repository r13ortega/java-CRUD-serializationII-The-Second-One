import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static ArrayList<BoardGame> list = new ArrayList<>();
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Hello, Welcome to Jurassic... um I mean Game Board Manager\n" +
                "Now would you like to load your data?\n" +
                "Type (Yes) to load\n" +
                "Type (No) to continue without loading\n");
        String answer = scan.nextLine();
        if (answer.equalsIgnoreCase("Yes")){
            loadData();
        } else if (answer.equalsIgnoreCase("No")) {
            System.out.println("moving to the CRUD");
        }
        MyMethods.CRUD(list);

        System.out.println("Now would you like to save your new BoardGame List?\n" +
                "Type (Yes) to save your list\n" +
                "or hit ENTER to end the Board Game Manager\n");
        String end = scan.nextLine();
        if (end.equalsIgnoreCase("Yes")){
            Serialization.saveData(list);
            System.out.println("data has been saved successfully...\n" +
                    "or it looks like it anyways :)\n");
        }
        System.out.println("Ending.... Good Bye");
    }
    public static void loadData(){
        //ArrayList<BoardGame> board;
        try {
            //read object from a file
            FileInputStream file = new FileInputStream("BoardGames.ser");
            //create a connection to a file
            ObjectInputStream in = new ObjectInputStream(file);
            //method for deserialize of an object
            list = (ArrayList<BoardGame>) in.readObject();
            //read object  and convert data to type BoardGame
            in.close();
            file.close();
            System.out.println("ArrayList has been deserialized!! OMG!");
            System.out.println(list.size());
        } catch (IOException z){
            z.printStackTrace();
        } catch (ClassNotFoundException f){
            f.printStackTrace();
        }
    }
}
