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
        try {

            info = new PrintWriter(new FileOutputStream(("UserInfo.txt"), true));               // instantiates a print writer object
        } catch (FileNotFoundException e) {
            System.out.println("File UserInfo.txt not found.");
        }
    }

    /**
     * This method adds a new player to the user info file
     *
     * @param name
     * @param money
     */
    public void addToTheFile(String name, int money) {
        info.println(name + ":" + money);                                                   // write the name and money to file
        info.close();                                                                           // closes the print writer
    }

    /**
     * This method reads the userInfo file and displays a leader board in the
     * descending order
     */
    public void sortLeaderBoard() {

        try {
            FileReader r = new FileReader("UserInfo.txt");                                          // instantiates a file reader
            List<PlayerInfo> person = new ArrayList<PlayerInfo>();                                   // instantiate an array list of type PlayerInfo

            BufferedReader reader = new BufferedReader(r);                                          // instantiate a buffered reader
            String line = "";
            boolean skipEmptyLine = false;
            // ensure the whole file is read
            while ((line = reader.readLine()) != null) {                                            // read the file until null
                String[] result = line.split(":");                                                  // split the name and money won by looking at semi colon

                if (!line.isEmpty()) {
                    skipEmptyLine = true;
                }
                if (skipEmptyLine != false) {
                    try {
                        person.add(new PlayerInfo(result[0], Integer.parseInt(result[1])));         //instantiate a player info class and pass the name and money to it

                    } catch (NumberFormatException e) {
                        System.out.println("The string could not be converted to an integer.");
                    }
                }

            }
            person.sort(Comparator.comparingInt(PlayerInfo::getMoney).reversed());      // sort the array list based on the money value in descending order
            System.out.println("\nThe leaderboard looks like:");

            displayLeaderBoard(person);
            r.close();                                                                  // close the file reader 

        } catch (FileNotFoundException e) {
            System.out.println("Could not find the File Reader file.");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("There are no players on the leaderboard.");
        } catch (IOException e) {
            System.out.println("Could not close the file reader.");
        }

    }

    private void displayLeaderBoard(List<PlayerInfo> person) {
        for (PlayerInfo player : person) {
            System.out.println(player);                                             // display each player's name and money won
        }
    }

}
