package gameproject;

import java.awt.Color;
import java.awt.Toolkit;
import java.util.Scanner;
import javax.swing.JFrame;

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
        Scanner keyboard = new Scanner(System.in);
        String name;
        do{
          System.out.println("Please enter your name");
           
            name = keyboard.nextLine();  
        }while(name.equalsIgnoreCase(""));
                                                             // allows the user to choose any name, no restrictions

        System.out.println("\nInstructions:\n"
                + "- To answer a question please type the letter corresponding to the answer and hit enter.\n"
                + "- To use a lifeline, type \"YES\" when prompted and pick a lifeline from the lifelines shown.\n"
                + "- To walk away with the money, enter \"Q\" at any time and press enter.\n"
                + "- If you get an answer wrong, your money won will decrease to the corresponding thresholds (100, 1000, 32000).\n"
                + "- If you get a question wrong at the threshold, the game will end.\n"
                + "- If you're ready to become a millionaire, type \"START\" and hit enter.\n");

        String ready = "";
        do {
            ready = keyboard.nextLine();
            if (!ready.equalsIgnoreCase("start") && !ready.equalsIgnoreCase("Q")) {
                System.out.println("Please type \"START\" to start the game or \"Q\" to quit the game.");
            }

        } while (!ready.equalsIgnoreCase("Start") && !ready.equalsIgnoreCase("Q"));                  // loops to ensures the user inputs in a valid input

        // process only when the user doesn't want to quit
        if (!ready.equalsIgnoreCase("Q")) {
            GamePlay file = new GamePlay(name);                                // instantiates the GamePlay class
            file.playGame();                                                   // play the game
        }
        
    }
}
