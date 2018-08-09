/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameproject;

import java.util.Scanner;
import java.io.File;
import java.io.PrintWriter;
import java.io.IOException;


/**
 *
 * @author Amrit
 */
public class GameProject {
 
    public static void main(String[] args) throws IOException {
        PrintWriter pw = null;
        Scanner keyboard = new Scanner(System.in);
       
        System.out.println("Please enter your name");

        try {
            pw = new PrintWriter("output.txt");
            String name = keyboard.nextLine();
            pw.print(name);
            pw.println();
            System.out.println("Welcome to Who Wants To Be A Millionaire! \nInstruction!!!! Start Button!!\n");
            ReadFile file = new ReadFile();
            
          
        } catch (IOException e) {
            e.printStackTrace();

        } finally {
            if (pw != null) {
                pw.close();
            }
        }
    }
}

//            if (userAnswer.equalsIgnoreCase("Yes")){
//                System.out.println("Type the related number to pick an option "
//                                 + "\n1. 50:50"
//                                 + "\n2. Phone a friend"
//                                 + "\n3. Audience Vote");
//                String chosenLifeLine = keyboard.nextLine();
//                if(chosenLifeLine.equalsIgnoreCase("1")){
//                    
//                }
//            }