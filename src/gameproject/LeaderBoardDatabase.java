package gameproject;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *This class creates the database connection and handles the logic needed for reading and writing 
 * to the database
 * @author Amritpal Kaur
 * 14865526
 */
public class LeaderBoardDatabase {
    private static Connection conn;
    private final String url = "jdbc:derby:LeaderBoard; create=true";
    private final String username = "game";
    private final String pass = "game";
    private int id = 1;
    private Statement statement;
    private final String table = "LeaderBoard";
    private String leaderBoard = "";
    
    /**
     * constructor calls the establish connection method to create a connection to the database
     */
    public LeaderBoardDatabase(){
        establishConnection();
    }
    
    /*
    * This method establishes the connection to the database
    */
    public void establishConnection(){
        try{
            conn = DriverManager.getConnection(url, username, pass);                  //gets the connection
            JOptionPane.showMessageDialog(null, "Database Connected(" + url + ").");    
            statement = conn.createStatement();
            
            // only creates the table if it doesn't exist
            DatabaseMetaData data = conn.getMetaData();
            ResultSet rs = data.getTables(null, "GAME", "LEADERBOARD", null);
            if (!rs.next()){
                createTable();
            }
            
        }catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "Unable to check if the table, "+ table + ", exists.");
        }
    }
    
    /*
    * Method that creates the leaderboard table in the database using SQL
    */
    public void createTable(){
            try {
                String sqlCreateTable = "CREATE TABLE " + table + " (ID INT," 
                                    + "Name VARCHAR (100), Points INT)";
                statement.executeUpdate(sqlCreateTable); 
            }catch(SQLException ex){
                JOptionPane.showMessageDialog(null, "Unable to create the table " + table);
            }
    }
    
    /**
     * adds content to the database
     * @param name of the player
     * @param money the player has won
     */
    public void addToDatabase(String name, int money){
        try{
            String insertData = "INSERT INTO " + table + " VALUES (" + id  + ", '"+ name + "', " + money + ")";
            statement.executeUpdate(insertData);
            id++;
        }catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "Unable to update the table");
        }
        
    }
    
    /**
     * Method used to read the content of the database
     * @return a String of the content that was stored in the database
     */
    public String getDatabase(){
        leaderBoard = "";
        try{    
           ResultSet rs = statement.executeQuery("SELECT *FROM " + table + " ORDER BY Points DESC"); 
           while (rs.next()){
               String playerName = rs.getString("Name");
               int playerPoints = rs.getInt("Points");
               leaderBoard +=  playerName + ": " + playerPoints + "\n";
           }
        }catch(SQLException ex){
            leaderBoard  = "No data avaliable";
        }
       return leaderBoard;
    }
}
