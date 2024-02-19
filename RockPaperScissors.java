/*
- Program allows a user to play a game of Rock, Paper, Scissors
*/
import java.util.Scanner;                           // necessary for getting user input
import java.util.Random;                            // necessary for generating random numbers
public class RockPaperScissors {
    private String playersChoice = ""; 
    private String computersChoice = ""; 

    /*
     * Method uses Random class to generate a random number simulating the computer randomly
     * choosing Rock, Paper, or Scissors. 
     */
    public void getComputersChoice() {
        Random rand = new Random(); 
        int val = rand.nextInt(3);

        if (val == 0) {
            computersChoice = "Rock";
        }
        else if (val == 1) {
            computersChoice = "Paper";
        }
        else if (val == 2) {
            computersChoice = "Scissors";
        }
    }

    /*
     * Method used to get the players choice of Rock, Paper, Scissors
     * - Validates input until user selects a correct input. 
     */
    public void getPlayersChoice() {
        Scanner getInput = new Scanner(System.in);
        String choice = ""; 
        do { 
            System.out.println("\nMake your choice! Rock, Paper, or Scissors?");
            System.out.println("1) Rock");
            System.out.println("2) Paper");
            System.out.println("3) Scissors");
            System.out.print("Enter number: "); 
            choice = getInput.nextLine();

            if (!choice.equals("1") && !choice.equals("2") && !choice.equals("3")) {
                System.out.println("Input must be a number! Enter 1, 2, or 3 to pick Rock, Paper, or Scissors..."); 
            }
            else {
                break; 
            }
        } while(true); 
       
        if (choice.equals("1")) {
            playersChoice = "Rock";
        }
        else if (choice.equals("2")) {
            playersChoice = "Paper";
        }
        else if (choice.equals("3")) {
            playersChoice = "Scissors";
        }
    }

    /*
     * Method displays the results of the game. Displaying a Draw, or with the Player one or not along with each choice. 
     */
    public void displayWinner() {
        System.out.println("Results!\n-------------------------------------------");

        if (playersChoice == computersChoice) {
            System.out.println("Player: " + playersChoice + "\tComputer: " + computersChoice); 
            System.out.println("Result: Draw!\n\n"); 
        }
        else if (playersChoice == "Rock" && computersChoice == "Paper") {
            System.out.println("Player: " + playersChoice + "\tComputer: " + computersChoice); 
            System.out.println("Result: You Lost! Paper covers Rock!\n\n");
        }
        else if (playersChoice == "Rock" && computersChoice == "Scissors") {
            System.out.println("Player: " + playersChoice + "\tComputer: " + computersChoice); 
            System.out.println("Result: You Win! Rock crushes Scissors!\n\n");
        }
        else if (playersChoice == "Paper" && computersChoice == "Rock") {
            System.out.println("Player: " + playersChoice + "\tComputer: " + computersChoice); 
            System.out.println("Result: You Win! Paper covers Rock!\n\n");
        }
        else if (playersChoice == "Paper" && computersChoice == "Scissors") {
            System.out.println("Player: " + playersChoice + "\tComputer: " + computersChoice); 
            System.out.println("Result: You Lost! Scissors cuts Paper!\n\n");
        }
        else if (playersChoice == "Scissors" && computersChoice == "Rock") {
            System.out.println("Player: " + playersChoice + "\tComputer: " + computersChoice); 
            System.out.println("Result: You Lost! Rock crushes Scissors!\n\n");
        }
        else if (playersChoice == "Scissors" && computersChoice == "Paper") {
            System.out.println("Player: " + playersChoice + "\tComputer: " + computersChoice); 
            System.out.println("Result: You Win! Scissors cuts Paper!\n\n");
        }
    }

    /*
     * Main method that is ran to play the game. 
     */
    public void playRound() {
        getComputersChoice();
        getPlayersChoice(); 
        displayWinner(); 
    }

    /*
     * Method used to ask the user if they want to continue playing the game or to end the program. 
     */
    public boolean closeGame() {
        Scanner getInput = new Scanner(System.in);
        String choice = "";

        System.out.print("Would you like to play again? Enter (Y or y) to play again.\n~ ");
        choice = getInput.nextLine();
        
        if (choice.equals("y") || choice.equals("Y")) {
            return true; 
        }
        else {
            return false; 
        }
    }

    /*
     * Only method needed to be called to run the game. Handles all logic. 
     */
    public void initGame() {
        do {
            System.out.println("Rock, Paper, Scissors!\n-----------------------------------------");
            System.out.println("Players will chose between Rock, Paper, or Scissors. Winner is chosen based on choices...");
            System.out.println("1) Players choosing the same choices results in a Draw");
            System.out.println("2) Rock crushes Scissors... Rock Wins");
            System.out.println("3) Paper covers Rock... Paper Wins");
            System.out.println("4) Scissors cuts Paper... Scissor Wins");

            playRound(); 

            } while (closeGame()); 
    }

    public static void main(String [] args) {
       RockPaperScissors game = new RockPaperScissors();
       game.initGame();
    }
}
