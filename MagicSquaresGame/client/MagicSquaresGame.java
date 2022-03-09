package client;
import java.util.*;
import ms.MagicSquare;

public class MagicSquaresGame {

    public static void main(String[] args) {
        int[] winCon = {98, 273, 140, 266, 84, 161, 146, 56};

        // Scanner to track the user inputs
        Scanner s = new Scanner(System.in);

        // Used to store the values of the first player
        MagicSquare squareOne = new MagicSquare();

        // Used to store the values of the second player
        MagicSquare squareTwo = new MagicSquare();

        // MagicSquare object used to keep track of both player values
        MagicSquare squareTracker = new MagicSquare();

        System.out.println("Welcome to the game of Magic Squares \n" +
                "************************************");
        System.out.println("""
                Rules:\s
                2 players play the game.
                Each player takes turns picking a number from 1-9.\s
                No number can be chosen twice\s
                The first player to have 3 numbers that sum to 15 wins!\s
                2 7 6
                9 5 1
                4 3 8
                ************************************
                """);

        // Save first player name in a variable and don't allow for non-alphabetical characters
        String playerOneName;
        String promptOne = "Enter a name for player #1";
        do {
            System.out.println(promptOne);
            playerOneName = s.nextLine();
            promptOne = "Please enter a real name.";
        } while (!playerOneName.matches("[a-zA-Z]+"));

        // Save second player name in a variable and don't allow for non-alphabetical characters
        String playerTwoName;
        String promptTwo = "Enter a name for player #2";
        do {
            System.out.println(promptTwo);
            playerTwoName = s.nextLine();
            promptTwo = "Please enter a real name.";
        } while (!playerTwoName.matches("[a-zA-Z]+"));

        // **START OF PLAYER GAME** \\

        int turns = 8; // Initialize the amount of turns for do while loop
        int playerOneWin; // Initialize an int to store the playerOneWin condition
        int playerTwoWin; // Initialize an int to store the playerTwoWin condition


        do { // Start of do while loop to prompt user multiple times
            try {
                System.out.print(playerOneName + ", please enter a number: ");
                byte playerOneSelection = s.nextByte();
                while (squareTracker.hasAlreadyChosen(playerOneSelection)) {
                    System.out.println("A player has already chosen " + playerOneSelection);
                    System.out.print(playerOneName + ", please enter a number: ");
                    playerOneSelection = s.nextByte();
                }
                    squareOne.choose(playerOneSelection);
                    squareTracker.choose(playerOneSelection);
                    System.out.println(squareOne);
                    if(squareTracker.getChoices() == 511 ) {
                        System.out.println("The game is a draw!");
                        return;
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
            playerOneWin = squareOne.getChoices();
            for (int i = 0; i < winCon.length; i++) {
                if ((playerOneWin & winCon[i]) == winCon[i]) {
                    System.out.println(playerOneName + " wins!");
                    return;
                }
            }
            turns--;

            try {
                System.out.print(playerTwoName + ", please enter a number: ");
                byte playerTwoSelection = s.nextByte();
                while (squareTracker.hasAlreadyChosen(playerTwoSelection)) {
                    System.out.println("A player has already chosen " + playerTwoSelection);
                    System.out.print(playerTwoName + ", please enter a number: ");
                    playerTwoSelection = s.nextByte();
                }
                squareTwo.choose(playerTwoSelection);
                squareTracker.choose(playerTwoSelection);
                System.out.println(squareTwo);
                    if(squareTracker.getChoices() == 511 ) {
                        System.out.println("The game is a draw!");
                        return;
                    }
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }
            playerTwoWin = squareTwo.getChoices();
            for (int i = 0; i < winCon.length; i++) {
                if ((playerTwoWin & winCon[i]) == winCon[i]) {
                    System.out.println(playerTwoName + " wins!");
                    return;
                }
            }
            turns--;
        } while (turns >= 0);
    }
}


