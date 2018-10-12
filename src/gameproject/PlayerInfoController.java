/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameproject;

/**
 *
 * @author Amrit
 */
public class PlayerInfoController {
    public  PlayerInfo player;
    
    public PlayerInfoController(){
        player = new PlayerInfo("", 0);
    }
    
    public void addName(String name){
        player.setName(name);
    }
    
    public String playerName(){
        return player.getName();
    }
    
    public int playerMoney(){
        return player.getMoney();
    }
    
    public int moneyWon(){
        return player.getMoney();
    }
}
