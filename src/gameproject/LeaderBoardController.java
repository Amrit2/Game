package gameproject;

import javax.swing.JTextPane;

/**
 *This class is the mediator between the View and the Model of the database feature.
 * @author Amritpal Kaur 14865526
 */
public class LeaderBoardController {
    LeaderBoardDatabase db;
    
    /*
    * Constructor instantiates the database object
    */
    public LeaderBoardController(){
        db = new LeaderBoardDatabase();
    }
    
    /*
    * The method takes in a name and money as parameter and calls the 
    * add function to add to the database.
    */
    public void add(String name, int money){
        db.addToDatabase(name, money);
    }
    
    /*
    * Returns the contents of the database and sets the leaderboard view in the game form.
    */
    public void getContent(JTextPane leaderboardTextPane){
        leaderboardTextPane.setText(db.getDatabase());
    }
}
