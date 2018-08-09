/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameproject;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Amrit
 */
public class ReadFile {
    
    
    public ReadFile() throws IOException {
        File f = new File("questions.txt");
        FileReader fr = new FileReader(f);
        BufferedReader br = new BufferedReader(fr);
        Scanner keyboard = new Scanner (System.in);
        
        String line;
        int limit = 5;
        int currentLine = 0;
        int questionNumber = 1;
        int moneyWon = 0;
        String userAnswer = "";
        String answer = "";
        
        while (questionNumber <= 22){
           while ((line = br.readLine())!= null && currentLine <= limit) 
            {
                if (line.contains("?")){
                    System.out.println(line );
                }
                if (line.contains(":")){
                    System.out.println(line);
                }
               if ((line.contains("A") || line.contains("B") || line.contains("C") || line.contains("D")) && !line.contains(":")){
                   answer = line;
               }
               currentLine++;
            }   
           questionNumber++;
           limit += 6;
           System.out.println("\nWould you like to use one of the life lines? If so, type yes else please type a letter to submit your answer");
           userAnswer = keyboard.nextLine();
           
           //EXTRACT THE MONEY COUNTING
           if (userAnswer.equalsIgnoreCase(answer)){
                if (moneyWon == 0){
                    moneyWon = 100;
                }
                 
                else {
                    moneyWon *= 2;
                    if (moneyWon == 400 || moneyWon == 600){
                        moneyWon -= 100;
                    }
                    else if (moneyWon == 128000){
                        moneyWon -= 3000;
                    }
                }
                System.out.println("Correct Answer! You've reached " + moneyWon + " dollars."); //money
            }
            else{
                System.out.println("Wrong Answer :(. The correct answer is " + answer +". Your points are BLAH");
            }
        }
        br.close();
        fr.close();
    }
    
}


//               if (line.contains("?")){ 
//                   question = line;
//               }
//               if (line.contains(":")){
//                   System.out.println("here");
//                    options[count++] = line;
//               }
//               if (line.contains("A") || line.contains("B") || line.contains("C") || line.contains("D")){
//                   answer = line;
//               }
//               currentLine++;






//            Questions quizQuestion = new Questions(question, options, answer);
//            System.out.println("output from Questions " + quizQuestion.toString());
//            count = 0;
            
//            System.out.println("\nWould you like to use one of the life lines? If so, type yes else please type a letter to submit your answer");
//            userAnswer = keyboard.nextLine();
//
//            if (userAnswer.equalsIgnoreCase(answer)){
//                if (money == 0){
//                    money = 100;
//                }
//                 
//                else {
//                    money *= 2;
//                    if (money == 400 || money == 600){
//                        money -= 100;
//                    }
//                    else if (money == 128000){
//                        money -= 3000;
//                    }
//                }
//                System.out.println("Correct Answer! You've reached  dollars."); //money
//            }
//            else{
//                System.out.println("Wrong Answer :(. The correct answer is " + answer +". Your points are BLAH");
//            }
//            limit = limit + 6; 
//            currentQuestion++;
//        }
       
//        System.out.println("End of the Game! You won ___ dollars");