import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class MyMethods {
    Scanner scan = new Scanner(System.in);

    public void CRUD(ArrayList<BoardGame> bg) {
        boolean keepRunning = true;
        //CollectionOfBG theBoardGame = new CollectionOfBG();
        Scanner scan = new Scanner(System.in);
        Serialization.loadData(bg);
        while (keepRunning) {
            System.out.println("Type (C) to save a new Board Games \n" +
                    "Type (R) to read all Board Games \n" +
                    "Type (U) to update a Board Game\n" +
                    "Type (D) to remove a Board Game\n \n" +
                    "Type (S) to save newly added Board Games\n" +
                    "Type (Q) to quit");
            String answer = scan.nextLine();
            if (answer.equalsIgnoreCase("C")) {
                create(bg);
            } else if (answer.equalsIgnoreCase("R")) {
                read(bg);
            } else if (answer.equalsIgnoreCase("U")) {
                update(bg);
            } else if (answer.equalsIgnoreCase("D")) {
                delete(bg);
            } else if (answer.equalsIgnoreCase("Q")) {
                keepRunning = false;
            }
        }
    }
    public void create(ArrayList<BoardGame> b){
        System.out.println("Let's add a new board game\n" +
                "Please enter in the (Name) of the Board Game");
        scan.nextLine();
        String bGName = scan.nextLine();
        System.out.println("Please enter in the minimum number of players needed to play");
        int minPlayers = scan.nextInt();
        scan.nextLine();
        System.out.println("Please enter in the maximum number of players needed to play");
        int maxPlayers = scan.nextInt();
        scan.nextLine();
        //boolean owner = true;
        System.out.println("Do you own this Board Game?\n" +
                "(true) or (false)");
        boolean owner = scan.nextBoolean();
        scan.nextLine();
        BoardGame bG = new BoardGame(bGName,minPlayers, maxPlayers, owner);
        b.add(bG);
    }
    public void read(ArrayList<BoardGame> b){
        for (BoardGame bg: b) {
            System.out.println(bg.toString());
        }
    }

    public void update(ArrayList<BoardGame> b){
        System.out.println("Let's update a board game\n" +
                "Please enter in the (Name) of the Board Game you wish to update");
        String searchName = scan.nextLine();
        for (BoardGame bg: b) {
            if (searchName.equalsIgnoreCase(bg.boardGameName)){
                System.out.println("Please enter in the minimum number of players needed to play");
                int minPlayers = scan.nextInt();
                scan.nextLine();
                System.out.println("Please enter in the maximum number of players needed to play");
                int maxPlayers = scan.nextInt();
                scan.nextLine();
                System.out.println("Do you own this Board Game?\n" +
                        "(true) or (false)");
                boolean owner = scan.nextBoolean();
                scan.nextLine();
                bg.boardGameName = searchName;
                bg.minNumOfPlayers = minPlayers;
                bg.maxNumOfPlayers = maxPlayers;
                bg.setOriginalOwner(owner);
            }
        }
    }

    public void delete(ArrayList<BoardGame> b){
        System.out.println("Warning, once deleted we cannot retrieve the Board Game\n" +
                "Please enter in the (Name) of the Board Game you wish to Remove");
        String searchName = scan.nextLine();
        for (BoardGame bg: b) {
            if (searchName.equalsIgnoreCase(bg.boardGameName)){
                b.remove(bg);
            }
        }
    }


}
