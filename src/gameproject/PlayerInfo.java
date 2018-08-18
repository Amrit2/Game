/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameproject;

import java.util.Collections;
import java.util.Comparator;

/**
 *
 * @author Amrit
 */
public class PlayerInfo{
    private String name;
    private int money;
   
    public PlayerInfo(String name, int money) {
        this.name = name;
        this.money = money;///// DO THIS FOR OTHER CLASSES
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
    
    public String toString(){
        return this.name + ":" + this.money;
    }

    
}
