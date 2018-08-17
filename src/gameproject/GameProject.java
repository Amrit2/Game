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
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Amrit check
 */
public class GameProject {
    
    public static void main(String[] args) throws IOException {
       
        System.out.println("Please enter your name");
        Scanner keyboard = new Scanner(System.in);
        String name;
        name = keyboard.nextLine();

        System.out.println("\nInstructions:\n"
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
