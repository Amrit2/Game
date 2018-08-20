package gameproject;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 * This class reads the Questions file and handles users input to allow the user
 * to play the game.
 * @author Amritpal Kaur 14865526
 */
public class GamePlay {
    Scanner keyboard;
    Lifelines lifeline;
    Questions quizQues;
    LeaderBoard leaderboard;
    ReadQuestionsFile file;
    PlayerInfo player;

    /**
     * The constructor initializes the variables and accesses the file to be read 
     * @param name of the player
     */
    public GamePlay(String name) {
        player = new PlayerInfo(name, 0);
        this.lifeline = new Lifelines();                                                         // instantiate the lifeline class
        this.leaderboard = new LeaderBoard();                                                    // instantiated the leader board class
        keyboard = new Scanner(System.in);
        file = new ReadQuestionsFile();
        this.quizQues = new Questions("", null, "");                 // instantiating the question class
    }

    /**
     * This class shows the questions and handles player input for processing
     */
    public void playGame() {
        String userAnswer = "";
        leaderboard.displayLeaderBoard();                                                   // displaying the sorted leaderboard

        // ensure the game keeps running until the player wins or quits the game
        while ( !userAnswer.equalsIgnoreCase("Q") && (player.getMoney() != 1000000)) {
            
            file.setQuestionsAndOptions(quizQues);
            System.out.println("Would you like to use one of the life lines? If so, type \"YES\" else please type a LETTER to submit your answer or \"Q\" to quit the game.");
            userAnswer = keyboard.nextLine();
            
            // loops to ensure the user enters a valid input 
            if (!validUserInput(userAnswer)) {
                do {
                    System.out.println("Please enter a A,B,C,D or \"yes\" to access lifelines.");
                    userAnswer = keyboard.nextLine();
                } while (!validUserInput(userAnswer));
            }

            //runs if the user says yes to use lifelines and loops to ensure the user picks between one of the three options
            if (userAnswer.equalsIgnoreCase("Yes") || userAnswer.equalsIgnoreCase("Y")) {
                do {
                    useLifeLine();
                    System.out.println("Would you like to use one of the life lines? If so, type yes else please type a LETTER to submit your answer or Q to quit the game.");
                    userAnswer = keyboard.nextLine();

                    //loops to ensure a valid input
                    if (!validUserInput(userAnswer)) {
                        do {
                            System.out.println("Please enter a A,B,C,D or \"yes\" to access lifelines.\n");
                            userAnswer = keyboard.nextLine();
                        } while (!validUserInput(userAnswer));
                    }
                } while (userAnswer.equalsIgnoreCase("yes"));

            }

            // if the player wants to quit the game, adds the player to the leaderboard and prints out the leaderboard
            if (userAnswer.equalsIgnoreCase("Q")) {
                leaderboard.addToTheFile(player.getName(), player.getMoney());
                leaderboard.displayLeaderBoard();
                System.exit(0);

            }
            
            player.setMoney(checkAnswer(userAnswer));                //checks the player's answer and set the moneyWon
            
        }

        //close the file reader and buffered reader
        
        
    }

    /**
     * This method checks the user's answer
     * @param userAnswer: the user's answer
     * @return the amount of money won by the player after processing the answer
     */
    public int checkAnswer(String userAnswer){
        int currentMoney = player.getMoney();
        
        // checks if the user answered correctly and sets the money won accordingly
        if (userAnswer.equalsIgnoreCase(quizQues.getAnswer())) {
            if (player.getMoney() == 0) {
                player.setMoney(100);
            } else {
                player.setMoney(player.getMoney()*2);
                if (player.getMoney() == 400 || player.getMoney()== 600) {
                    player.setMoney(player.getMoney() - 100);
                } else if (player.getMoney() == 128000) {
                    player.setMoney(player.getMoney() - 3000);
                }
            }
            System.out.println("Correct Answer! \nYou've reached " + player.getMoney() + " dollars.\n"); //money
        } else {
            
            // if the user gets a question wrong their money is decreased to the corresponding thresh hold. 
            // If they were above $1000 and get a ques wrong, they come down to $1000, if they were above $32000 it comes down to 
            // $32000.
            if (player.getMoney() >= 1000 && player.getMoney() < 32000) {
                player.setMoney(1000);
            } else if (player.getMoney() >= 32000) {
                player.setMoney(32000);
            } else {
                player.setMoney(0);
            }
            System.out.println("Wrong Answer :(. \n"
                    + "The correct answer is " + quizQues.getAnswer() + ". \nYou are on " + player.getMoney() + " dollars.");
        }
        
        //if the user was on $0 and gets a questions wrong, the game quits
        if ((currentMoney== 0 && player.getMoney() == 0) || (currentMoney== 1000 && player.getMoney() == 1000) || (currentMoney== 32000 && player.getMoney() == 32000)){
            leaderboard.addToTheFile(player.getName(), player.getMoney());
            leaderboard.displayLeaderBoard();
            System.out.println("You've lost the game.");
            System.exit(0);
        }
        return player.getMoney();
    }

    /**
     * This method processes the life line based on user's choice
     * @param lifeline
     * @param quizQues
     * @param options
     * @param answer
     * @param question
     */
    private void useLifeLine() {
        String chosenLifeLine = "";

        System.out.println("Type the related NUMBER to pick an option "
                + "\n1. 50:50"
                + "\n2. Phone a friend"
                + "\n3. Audience Vote");
        chosenLifeLine = keyboard.nextLine();
        
        //loops to ensure the user picks an option from 1,2,3
        if (!validLifeLineUserInput(chosenLifeLine)) {
            do {
                System.out.println("\nPlease choose 1, 2 or 3.");
                chosenLifeLine = keyboard.nextLine();
            } while (!validLifeLineUserInput(chosenLifeLine));
        }

        // process the life line chosen if the user didn't choose q
        if (!chosenLifeLine.equalsIgnoreCase("Q")) {
            if (chosenLifeLine.equalsIgnoreCase("1")) {                                               // process the 50:50 option
                String[] resultedOption = lifeline.setFiftyFiftyOptions(quizQues.getOptions(), quizQues.getAnswer(), quizQues.getQuestion());
                quizQues.setOptions(resultedOption);
                this.quizQues.setOptions(resultedOption);
                System.out.println(quizQues.toString());
            }
            if (chosenLifeLine.equalsIgnoreCase("2")) {                                               // process the phone a friend option
                this.lifeline.setPhoneAFriendOptions(quizQues.getOptions(), quizQues.getAnswer(), quizQues.getQuestion());
                System.out.println(quizQues.toString());
            }
            if (chosenLifeLine.equalsIgnoreCase("3")) {                                               // process the set audience option
                String[] resultedOption = lifeline.setAudienceVoteOptions(quizQues.getOptions(), quizQues.getAnswer(), quizQues.getQuestion());
                quizQues.setOptions(resultedOption);
                this.quizQues.setOptions(resultedOption);
                System.out.println(quizQues.toString());
            }
        } else {

            //set the leaderboard before quitting if user enters Q for quit
            this.leaderboard.addToTheFile(player.getName(), player.getMoney());
            this.leaderboard.displayLeaderBoard();
            System.exit(0);
        }

    }

    /**
     * This method checks for a valid input which includes ensuring that the user chooses one of the options or q
     * @param userAnswer
     * @return a boolean
     */
    private boolean validUserInput(String userAnswer) {
        return userAnswer.equalsIgnoreCase("Q") || userAnswer.equalsIgnoreCase("Yes")
                || userAnswer.equalsIgnoreCase("A") || userAnswer.equalsIgnoreCase("B")
                || userAnswer.equalsIgnoreCase("C") || userAnswer.equalsIgnoreCase("D");
    }

    /**
     * This method checks for valid life line input to ensure users picks at least one of the options or q
     * @param userChoice
     * @return a boolean
     */
    private boolean validLifeLineUserInput(String userChoice) {
        return userChoice.equalsIgnoreCase("Q") || userChoice.equalsIgnoreCase("1")
                || userChoice.equalsIgnoreCase("2") || userChoice.equalsIgnoreCase("3");
    }
}
