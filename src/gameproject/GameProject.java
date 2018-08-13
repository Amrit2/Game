/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameproject;

import java.util.Scanner;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.io.IOException;

/**
 *
 * @author Amrit check
 */
public class GameProject {

    public static void main(String[] args) throws IOException {
        Scanner keyboard = new Scanner(System.in);

        System.out.println("Please enter your name");

        String name = keyboard.nextLine();
       
        
        System.out.println("Welcome, " + name + " to Who Wants To Be A Millionaire! \n"
                           + "Instructions:\n"
                           + "- To answer a question please type the letter corresponding to the answer and hit enter.\n"
                           + "- To use a lifeline, type YES when prompted and pick a lifeline from the lifelines shown.\n"
                           + "- You can quit at anytime by typing E for exit NNEEEDDD TOOO IMPLEEEMENT\n"
                           + "If you're ready to become a millionaire, type START and hit enter\n");
        String ready = keyboard.nextLine();
        if (ready.equalsIgnoreCase("Start")){
            ReadQuestionsFile file = new ReadQuestionsFile (name);
        }
    }
}
