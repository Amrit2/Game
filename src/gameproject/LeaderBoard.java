package gameproject;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * This class handles the leader board
 *
 * @author Amritpal Kaur 14865526
 */
public class LeaderBoard {

    private List<String> board;
    File file;
    PrintWriter info;

    /**
     * The constructor instantiates the board and board
     */
    public LeaderBoard() {
        board = new ArrayList<String>();
        file = new File("UserInfo.txt");
    }

    /**
     * This method adds a new player to the user info file
     *
     * @param name
     * @param money
     */
    public void addToTheFile(String name, int money) {
        try {
            info = new PrintWriter(new FileOutputStream(("UserInfo.txt"), true));               // instantiates a print writer object
            info.println(name + ":" + money);                                                   // write the name and money to file
        } catch (FileNotFoundException e) {
            System.out.println("Error: File UserInfo.txt not found.");
        }

        info.close();
    }

    /**
     * This method reads the userInfo file and create a leader board
     * @throws IOException
     */
    public void displayLeaderBoard(){

        try {
            FileReader r = new FileReader("UserInfo.txt");                                  // instantiates a file reader
            List<PlayerInfo> person = new ArrayList<PlayerInfo>();                          // instantiate an array list of type PlayerInfo

            BufferedReader reader = new BufferedReader(r);                                  // instantiate a buffered reader
            String line = "";

            while ((line = reader.readLine()) != null) {                                // read the file until null
                String[] result = line.split(":");                                      // split the text based on a semi-colon
                person.add(new PlayerInfo(result[0], Integer.parseInt(result[1])));         //instantiate a player info class and pass the name and money to it
            }
            person.sort(Comparator.comparingInt(PlayerInfo::getMoney).reversed());      // sort the array list based on the money value in descending order
            System.out.println("\nThe leaderboard looks like:");
            for (PlayerInfo player : person) {
                System.out.println(player);                                             // display eaach player's name and money won
            }

            r.close();

        } catch (FileNotFoundException e) {
            System.out.println("Error: File not found.");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Error: You are trying to access an illegal integer in the array");
        } catch (IOException e){
            System.out.println("Input output operation failed");
        }

    }

}
