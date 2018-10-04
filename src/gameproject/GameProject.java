package gameproject;

import java.sql.SQLException;

/**
 * This class is the entry point of the program
 * @author Amritpal Kaur
 * 14865526
 */
public class GameProject {

    /**
     * the main function
     * @param args 
     */
    public static void main(String[] args) throws SQLException {
       new MenuForm().setVisible(true);
    }
}
