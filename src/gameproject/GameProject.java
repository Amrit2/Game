package gameproject;

import java.io.IOException;
import java.util.Scanner;

/**
 * This class is the entry point of the program
 * @author Amritpal Kaur
 * 14865526
 */
public class GameProject {

    /**
     * the main function
     * @param args 
     */
    public static void main(String[] args) {

        System.out.println("Please enter your name");
        Scanner keyboard = new Scanner(System.in);
        String name;
        name = keyboard.nextLine();

        System.out.println("\nInstructions:\n"
                + "- To answer a question please type the letter corresponding to the answer and hit enter.\n"
                + "- To use a lifeline, type \"YES\" when prompted and pick a lifeline from the lifelines shown.\n"
                + "- To walk away with the money, type \"Q\" and press enter\n"
                + "- If you're ready to become a millionaire, type \"START\" and hit enter\n");

        String ready = "";
        do {
            ready = keyboard.nextLine();
            if (!ready.equalsIgnoreCase("start") && !ready.equalsIgnoreCase("Q")) {
                System.out.println("Please type \"START\" to start the game or \"Q\" to quit the game.");
            }

        } while (!ready.equalsIgnoreCase("Start") && !ready.equalsIgnoreCase("Q"));                  // ensures the user inputs in a valid input

        if (!ready.equalsIgnoreCase("Q")) {
            ReadQuestionsFile file = new ReadQuestionsFile(name);                                // instantiates the ReadQuestions file
            file.playGame();                                                                     // play the game
            System.out.println("Congratulations! You've won 1 MILLION DOLLARS.");
           
        }

    }
}
