package gameproject;

import java.util.Collections;
import java.util.Comparator;

/**
 *The class stores the name and money won by each player
 * @author Amritpal Kaur
 * 14865526
 */
public class PlayerInfo{
    private String name;
    private int money;
   
    /**
     * Initializes the name and money won
     * @param name
     * @param money 
     */
    public PlayerInfo(String name, int money) {
        this.name = name;
        this.money = money;
    }
    
   
   // get/set methods for name and money
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
