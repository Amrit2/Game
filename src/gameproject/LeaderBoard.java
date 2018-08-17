/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameproject;

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
 * @author Amrit
 */
public class LeaderBoard {
    List<String> board = new ArrayList<String>();
    File file = new File("UserInfo.txt");
    PrintWriter info;

    public LeaderBoard(String name, int money) throws IOException{
        addToTheFile(name, money);
    }
    
     public void addToTheFile (String name, int money)throws FileNotFoundException, IOException{
         try {
              board = Files.readAllLines(file.toPath(), Charset.defaultCharset());
              info = new PrintWriter( new FileOutputStream(("UserInfo.txt"), true));
              for (String s: board){
                  if (s.contains(name)){
                    info.println(name + ":" + money);  
                  }
              }
              info.println(name + ":" + money); 
            
        } catch (FileNotFoundException e) {
            System.out.print("Could not write to the file, error " + e);
        } finally {
             info.close();
        }
    }

//    public void showLeaderBoard() {
//        File file = new File("UserInfo.txt");
//        if (file.exists()) {
//            try {
//                board = Files.readAllLines(file.toPath(), Charset.defaultCharset());
//            } catch (IOException ex) {
//                ex.printStackTrace();
//            }
//            if (board.isEmpty()) {
//                return;
//            }
//        }
//        for (String s: board){
//            System.out.println(s);
//        }
//    }
}
