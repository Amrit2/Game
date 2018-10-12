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
import javax.swing.JTextPane;

/**
 *
 * @author Amrit
 */
public class LeaderBoardDatabase {
    private static Connection conn;
    private static String url = "jdbc:derby:LeaderBoard; create=true";
    private static String username = "game";
    private static String pass = "game";
    private int id = 1;
    private Statement statement;
    private String table = "LeaderBoard";
    private String leaderBoard = "";
    
    public LeaderBoardDatabase(){
        establishConnection();
    }
    
    public void establishConnection(){
        try{
            conn = DriverManager.getConnection(url, username, pass);
            JOptionPane.showMessageDialog(null, "Database Connected(" + url + ").");
            statement = conn.createStatement();
            DatabaseMetaData data = conn.getMetaData();
            ResultSet rs = data.getTables(null, "GAME", "LEADERBOARD", null);
            if (!rs.next()){
                createTable();
            }
            
        }catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "Unable to check if the table, "+ table + ", exists.");
        }
    }
    
    public void createTable(){
            try {
                    
                String sqlCreateTable = "CREATE TABLE " + table + " (ID INT," 
                                    + "Name VARCHAR (100), Points INT)";
                statement.executeUpdate(sqlCreateTable); 
            }catch(SQLException ex){
                JOptionPane.showMessageDialog(null, "Unable to create the table " + table);
            }
    }
    
    public void addToDatabase(String name, int money){
        try{
            
            String insertData = "INSERT INTO " + table + " VALUES (" + id  + ", '"+ name + "', " + money + ")";
            statement.executeUpdate(insertData);
            id++;
        }catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "Unable to update the table");
        }
        
    }
    
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
            leaderBoard  = "Unable to access data in the database.";
        }
       return leaderBoard;
    }
}
