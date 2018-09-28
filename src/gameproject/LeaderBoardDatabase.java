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

/**
 *
 * @author Amrit
 */
public class LeaderBoardDatabase {
    public static Connection conn;
    public static String url = "jdbc:derby:LeaderBoard; create=true";
    
    public static String username = "game";
    public static String pass = "game";
    
 
    public void establishConnection(){
        try{
            conn = DriverManager.getConnection(url, username, pass);
            System.out.println(url + " ..connected");
            
        }catch (SQLException ex){
            System.err.println("SQL Exception: " + ex.getMessage());
        }
    }
    
    public void createTable(){
            String newTable = "LeaderBoard";
            try {
               Statement statement = conn.createStatement();
                
                String sqlCreateTable = "CREATE TABLE " + newTable + " ( ID INT," 
                                    + "Name VARCHAR (100), Points INT)";
                statement.executeUpdate(sqlCreateTable); 
                
                
            }catch(SQLException ex){
                System.out.println("SQL Exception " + ex.getMessage());
            }
            
        }
        
//    }
}
