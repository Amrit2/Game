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
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author Amrit
 */
public class LeaderBoard {

    private List<String> board;
    File file;
    PrintWriter info;

    public LeaderBoard() throws FileNotFoundException {
        board = new ArrayList<String>();
        file = new File("UserInfo.txt");
    }

    public void addToTheFile(String name, int money) throws FileNotFoundException, IOException {
        info = new PrintWriter(new FileOutputStream(("UserInfo.txt"), true));
        info.println(name + ":" + money);
        info.close();
    }

    public void sortedBoard() throws IOException {
        FileReader r = new FileReader("UserInfo.txt");
        List<PlayerInfo> person = new ArrayList<PlayerInfo>();

        BufferedReader reader = new BufferedReader(r);
        String line = "";

        while ((line = reader.readLine()) != null) {
            String[] result = line.split(":");
            person.add(new PlayerInfo(result[0], Integer.parseInt(result[1])));
        }
        person.sort(Comparator.comparingInt(PlayerInfo::getMoney).reversed());
        
        System.out.println("\nThe leaderboard looks like:");
        for (PlayerInfo player: person){
            System.out.println(player);
        }
        r.close();
    }

}

