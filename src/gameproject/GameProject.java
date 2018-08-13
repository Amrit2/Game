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
       
        
        System.out.println("Welcome, " + name + " to Who Wants To Be A Millionaire! \nInstruction!!!! Start Button!!\n");
        
        if (name != null){
           ReadQuestionsFile file = new ReadQuestionsFile (name);
        }
    }
}
