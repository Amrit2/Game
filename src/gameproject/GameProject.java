/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameproject;

import java.io.IOException;
import java.util.Scanner;
/**
 *
 * @author Amrit check
 */
public class GameProject {
    
    public static void main(String[] args) throws IOException{
       
        System.out.println("Please enter your name");
        Scanner keyboard = new Scanner(System.in);
        String name;
        name = keyboard.nextLine();

        System.out.println("\nInstructions:\n"
                           + "- To answer a question please type the letter corresponding to the answer and hit enter.\n"
                           + "- To use a lifeline, type YES when prompted and pick a lifeline from the lifelines shown.\n"
                           + "- To walk away with the money, type q and press enter\n"
                           + "If you're ready to become a millionaire, type START and hit enter\n");
       
        String ready = keyboard.nextLine();
        if (ready.equalsIgnoreCase("Start")){
            try{
              ReadQuestionsFile file = new ReadQuestionsFile (name);  
            }catch (IOException e){
                System.out.println("Error: " + e);
            }finally{
                System.out.println("Thank you for playing Who Wants To Be a Millionaire.");
            }
            
        }
        LeaderBoard board = new LeaderBoard();
        board.sortedBoard();
    }
}
