import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class MyMethods {
    public static Scanner scan = new Scanner(System.in);

    public static void CRUD(ArrayList<BoardGame> bg) {
        boolean keepRunning = true;
        Scanner scan = new Scanner(System.in);
        while (keepRunning) {
            System.out.println("Type (C) to save a new Board Games \n" +
                    "Type (R) to read all Board Games \n" +
                    "Type (U) to update a Board Game\n" +
                    "Type (D) to remove a Board Game\n \n" +
                    "Type (Q) to end CRUD and (save)...maybe\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "borrow or steal");
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
            } else if (answer.equalsIgnoreCase("borrow")) {
                borrowingBoardGame(bg);
            } else if (answer.equalsIgnoreCase("steal")) {
                stealBoardGames(bg);
            }
        }
    }
    public static void create(ArrayList<BoardGame> b){
        System.out.println("Let's add a new board game\n" +
                "Please enter in the (Name) of the Board Game");String bGName = scan.nextLine();
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
    public static void read(ArrayList<BoardGame> b){
        for (BoardGame bg: b) {
            System.out.println(bg.toString());
        }
    }

    public static void update(ArrayList<BoardGame> b){
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

    public static void delete(ArrayList<BoardGame> b){
        System.out.println("Warning, once deleted we cannot retrieve the Board Game\n" +
                "Please enter in the (Name) of the Board Game you wish to Remove");
        String searchName = scan.nextLine();
        for (BoardGame bg: b) {
            if (searchName.equalsIgnoreCase(bg.boardGameName)){
                b.remove(bg);
            }
        }
    }


    public static void stealBoardGames(ArrayList<BoardGame> boardGame){
        for (BoardGame bg: boardGame) {
            if (bg.isOriginalOwner() == false){
                bg.setOriginalOwner(true);
            }
        }
        System.out.println("heh, you are currently borrowing 0 Board Games");
    }

    public static void borrowingBoardGame(ArrayList<BoardGame> board){ //getBorrowing()
        int numOfBorrowing = 0;
        for (BoardGame bg: board) {
            if (bg.isOriginalOwner() == false){
                System.out.println(bg.toString());
                numOfBorrowing++;
            }
        }
        System.out.println("You are currently borrowing " + numOfBorrowing + " Board Games");
    }

}
