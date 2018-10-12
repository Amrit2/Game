/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameproject;

import javax.swing.JTextPane;

/**
 *
 * @author Amrit
 */
public class LeaderBoardController {
    LeaderBoardDatabase db;
    
    public LeaderBoardController(){
        db = new LeaderBoardDatabase();
    }
    
    public void add(String name, int money){
        db.addToDatabase(name, money);
    }
    
    public void getContent(JTextPane leaderboardTextPane){
        leaderboardTextPane.setText(db.getDatabase());
    }
}
