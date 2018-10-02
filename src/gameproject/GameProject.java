package gameproject;

import java.awt.Color;
import java.awt.Toolkit;
import java.sql.SQLException;
import java.util.Scanner;
import javax.swing.JFrame;

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
