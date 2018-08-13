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
public class MoneyLadder {

    List<String> ladder = new ArrayList<String>();

    public MoneyLadder(int money) throws IOException {
        setMoney(money);
    }

    private void setMoney(int money) throws FileNotFoundException, IOException {
        String currentValue = Integer.toString(money);
        File file = new File("UserInfo.txt");
        if (file.exists()) {
            try {
                ladder = Files.readAllLines(file.toPath(), Charset.defaultCharset());
                int i = 0;
                for (String s : ladder) {
                    while (!s.equalsIgnoreCase(currentValue)){
                        i++;
                    }
                }
                ladder.set(i, "<----");
                Files.write(file.toPath(), ladder, Charset.defaultCharset());

            } catch (IOException ex) {
                ex.printStackTrace();
            }
            if (ladder.isEmpty()) {
                return;
            }
        }
    }

}
