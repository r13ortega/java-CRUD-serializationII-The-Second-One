import java.io.*;
import java.util.ArrayList;

public class Serialization {
    public static void saveData(ArrayList<BoardGame> b){
        //method does load successfully
        try {
            FileOutputStream fileOut = new FileOutputStream("BoardGames.ser");
            //fileOut does load successfully
            //responsible for opening a connection to a file
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            //out does load successfully
            out.writeObject(b);
            //writing the object that we passed in = where we're directly writing the file
            out.close();
            fileOut.close();
            System.out.println("Serialized Array data is saved!!!");
        } catch (IOException i) {
            i.printStackTrace();
            //history of all the methods that were called - allow us to see where the code went wrong.
        }
    }
    public static void loadData(ArrayList<BoardGame> board){//I hate this
        //ArrayList<BoardGame> board;
        try {
            //read object from a file
            FileInputStream file = new FileInputStream("BoardGames.ser");
            //create a connection to a file
            ObjectInputStream in = new ObjectInputStream(file);
            //method for deserialize of an object
            board = (ArrayList<BoardGame>) in.readObject();
            //read object  and convert data to type BoardGame
            in.close();
            file.close();
            System.out.println("ArrayList has been deserialized!! OMG!");
            System.out.println(board.size());
        } catch (IOException z){
            z.printStackTrace();
        } catch (ClassNotFoundException f){
            f.printStackTrace();
        }
    }
}
