/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameproject;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.INFORMATION_MESSAGE;
import javax.swing.JTextPane;

/**
 *
 * @author Amrit
 */
public class LeaderBoardDatabase {
    public static Connection conn;
    public static String url = "jdbc:derby:LeaderBoard; create=true";
    public static String username = "game";
    public static String pass = "game";
    public int id = 1;
    public Statement statement;
    public String table = "LeaderBoard";
    public String leaderBoard = "";
    
    public LeaderBoardDatabase(){
        establishConnection();
    }
    
    public void establishConnection(){
        try{
            conn = DriverManager.getConnection(url, username, pass);
             JOptionPane.showMessageDialog(null, "Database Connected(" + url + ").");
//            System.out.println("Database Connected(" + url + ").");
            statement = conn.createStatement();
            DatabaseMetaData data = conn.getMetaData();
            ResultSet rs = data.getTables(null, "GAME", "LEADERBOARD", null);
            if (!rs.next()){
                createTable();
            }
            
        }catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "Unable to check if the table, "+ table + ", exists.");
//            System.err.println("Unable to check if the table, "+ table + ", exists.");
        }
    }
    
    public void createTable(){
            try {
                    
                String sqlCreateTable = "CREATE TABLE " + table + " (ID INT," 
                                    + "Name VARCHAR (100), Points INT)";
                statement.executeUpdate(sqlCreateTable); 
            }catch(SQLException ex){
                System.out.println("Unable to create the table, " + table);
            }
    }
    
    public void addToDatabase(String name, int money){
        try{
            String insertData = "INSERT INTO " + table + " VALUES (" + id  + ", '"+ name + "', " + money + ")";
            statement.executeUpdate(insertData);
            id++;
        }catch (SQLException ex){
            System.out.println("Unable to update the table.");
        }
        
    }
    
    public void getDatabase(JTextPane leaderboardTextPane){
        try{
           ResultSet rs = statement.executeQuery("SELECT *FROM " + table + " ORDER BY Points DESC"); 
//           System.out.print("\nLeaderBoard: \n");
           while (rs.next()){
               String playerName = rs.getString("Name");
               int playerPoints = rs.getInt("Points");
               leaderBoard +=  playerName + ": " + playerPoints + "\n";
//               System.out.print(playerName + ": " + playerPoints + "\n");
           }
        }catch(SQLException ex){
            leaderBoard  = "Unable to access data in the database.";
//            System.out.println("Unable to access data in the database.");
        }
       leaderboardTextPane.setText(leaderBoard);
    }
}
