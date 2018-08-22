package gameproject;

import java.util.Scanner;

/**
 * This class handles the game play
 * @author Amritpal Kaur 14865526
 */
public class GamePlay {
    
    //declarations
    Scanner keyboard;
    Lifelines lifeline;
    Questions quiz;
    LeaderBoard leaderboard;
    ReadQuestionsFile file;
    PlayerInfo player;
    CheckAnswer checkAnswer;

    /**
     * The constructor instantiates the PlayerInfo, Lifelines, ReadQuestionsFile, Check Answer, LeaderBoard and Questions class
     * @param name of the player
     */
    public GamePlay(String name) {
        this.player = new PlayerInfo(name, 0);
        this.lifeline = new Lifelines();                               // instantiate the lifeline class
        this.leaderboard = new LeaderBoard();                         // instantiated the leader board class
        keyboard = new Scanner(System.in);
        file = new ReadQuestionsFile();
        this.quiz = new Questions("", null, "");                 // instantiating the question class
        this.checkAnswer = new CheckAnswer();
    }

    /**
     * This class shows the questions and handles player input for processing
     */
    public void playGame() {
        String userAnswer = "";
        leaderboard.displayLeaderBoard();                                                   // displaying the sorted leaderboard

        // ensure the game keeps running until the player wins or quits the game
        while ( !userAnswer.equalsIgnoreCase("Q") && (player.getMoney() != 1000000)) {
            
            file.showQuizQues(quiz);
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
                
                // keep repeting the loop to allow the user to use lifelines until the user answers the questions
                do {
                    // displays the lifeline options and process the use of the lifeline used
                    lifeline.useLifeLine(player, leaderboard, quiz);
                    
                    //asks the player if they want to use another lifelline 
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
            
             //checks the player's answer and set the moneyWon accordingly
            player.setMoney(checkAnswer.setMoneyWon(userAnswer, player, quiz, leaderboard));               
            
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

}
