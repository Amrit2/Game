/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameproject;

import java.io.BufferedWriter;
import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
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

        try {
            FileWriter userFile = new FileWriter("UserInfo.txt");
            BufferedWriter info = new BufferedWriter(userFile);
            String name = keyboard.nextLine();
            info.write(name);
            System.out.println("Welcome, " + name + " to Who Wants To Be A Millionaire! \nInstruction!!!! Start Button!!\n");
            ReadFile file = new ReadFile();

            info.close();
        } catch (IOException e) {
            e.printStackTrace();

        } finally {
//            if (pw != null) {
//                pw.close();
//            }
        }
    }
}
