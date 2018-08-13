/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameproject;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
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
public class MoneyLadder {

    List<String> ladder = new ArrayList<String>();

    public MoneyLadder(int money) throws IOException {
        setMoney(money);
    }

    private void setMoney(int money) throws FileNotFoundException {
        File file = new File("UserInfo.txt");
        if (file.exists()) {
            try {
                ladder = Files.readAllLines(file.toPath(), Charset.defaultCharset());
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            if (ladder.isEmpty()) {
                return;
            }
        }
        
        for (String s: ladder){
            if (s.equalsIgnoreCase(Integer.toString(money))){
                PrintWriter info = new PrintWriter( new FileOutputStream(("UserInfo.txt"), true));
                info.write("     <------");
            }
        }
        
        for (String s: ladder){
            System.out.println(s);
        }
    }

}
