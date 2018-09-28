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
public class DatabaseQuestions {
    public static Connection conn;
    public static String url = "jdbc:derby:Questions1; create=true";
    
    public static String username = "game1";
    public static String pass = "game1";
    
 
    public void establishConnection(){
        try{
            conn = DriverManager.getConnection(url, username, pass);
            System.out.println(url + " ..connected");
            
        }catch (SQLException ex){
            System.err.println("SQL Exception: " + ex.getMessage());
        }
    }
    
    public void createTable(){
//        DatabaseMetaData dbmd = conn.getMetaData();
//        ResultSet rs = dbmd.getTables(null, "MYSCHEMA", "MYTABLE", null);
//        if(!rs.next())
//        {
            String newTable = "QuizQuestion";
            try {
               Statement statement = conn.createStatement();
                
                String sqlCreateTable = "CREATE TABLE " + newTable + " ( ID INT," 
                                    + "QUESTION VARCHAR (100), OPTION1 VARCHAR (100), OPTION2 VARCHAR (100)," +
                                    "OPTION3 VARCHAR (100), OPTION4 VARCHAR (100), ANSWER VARCHAR(100))";
                statement.executeUpdate(sqlCreateTable); 
                
                String insertInto = "INSERT INTO " + newTable + " VALUES ('Baleen whales have two and toothed whales have one of what?', "
                    + "'A:Stomachs', 'B:Noses', 'C:Fins', 'D:Blowholes', 'D')";
                statement.executeUpdate(insertInto); 
                
            }catch(SQLException ex){
                System.out.println("SQL Exception " + ex.getMessage());
            }
            
            
            
        }
        
//    }
}
