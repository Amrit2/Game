/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameproject;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author Amrit
 */
public class PlayerInfo {
    private String name;
    private int money;
   
    public PlayerInfo(String name, int money) throws IOException  {
       setName(name);
       setMoney(money);
       LeaderBoard info = new LeaderBoard(this.getName(), this.getMoney());
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public void setMoney(int money) {
        this.money = money;
    }
    
    public String getName(){
        return this.name;
    }
    
    public int getMoney(){
        return this.money;
    }
}
