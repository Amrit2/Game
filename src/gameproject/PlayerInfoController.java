package gameproject;

/**
 *This class is the connection between the PlayerInfo logic and the view
 * @author Amritpal Kaur
 */
public class PlayerInfoController {
    public  PlayerInfo player;
    
    public PlayerInfoController(){
        player = new PlayerInfo("", 0);
    }
    
    /**
     * Method for add the name
     * @param name 
     */
    public void addName(String name){
        player.setName(name);
    }
    
    /**
     * Method to return player's name
     * @return 
     */
    public String playerName(){
        return player.getName();
    }
    
    /**
     * Method to set the money won 
     * @return 
     */
    public int playerMoney(){
        return player.getMoney();
    }
    
    /**
     * Method to get the money won
     * @return 
     */
    public int moneyWon(){
        return player.getMoney();
    }
}
