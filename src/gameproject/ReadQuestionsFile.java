package gameproject;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 * This class reads the Questions file and handles users input to allow the user to play the game
 * @author Amritpal Kaur
 * 14865526
 */
public class ReadQuestionsFile {

    //declaration of variables
    private String[] options;
    private String answer;
    private String question;
    private String name;
    File f;
    FileReader fr;
    BufferedReader br;
    Scanner keyboard;
    Lifelines lifeline;
    private int moneyWon = 0;
    Questions quizQues;
    LeaderBoard leaderboard;

    /**
     * The constructor initializes the variables
     * @param name of the player
     * @throws IOException 
     */
    public ReadQuestionsFile(String name) throws IOException {
        setName(name);
        this.answer = "";
        this.question = "";
        this.options = new String[4];

        f = new File("questions.txt");                                  //instantiated a text file called questions
        fr = new FileReader(f);                                         // passing that file to the file reader
        br = new BufferedReader(fr);                                    // passing it to the buffered reader for reading
        leaderboard = new LeaderBoard();                                // instantiated the leader board class
        keyboard = new Scanner(System.in);

    }

    // get/set methods for the money won by the player
    public void setMoneyWon(int money) {
        this.moneyWon = money;
    }

    public int getMoneyWon() {
        return this.moneyWon;
    }

    /**
     * This class shows the questions and handles player input for processing
     * @throws IOException 
     */
    public void playGame() throws IOException {
        quizQues = new Questions(this.question, this.options, this.answer);                 // instantiating the question class
        String userAnswer = "";
        String line;
        int questionNumber = 1;
        int limit = 5;                                                                     // the number of lines in the text file
                                                                                           // after the question that need to be processed
        int currentLine = 0;
        int count = 0;
        
        leaderboard.displayLeaderBoard();                                                   // displaying the sorted leaderboard

        // ensure the game keeps running until the questions finish
        while (questionNumber <= 22 && !userAnswer.equalsIgnoreCase("Q") && (this.getMoneyWon()!= 1000000)) {   
            while ((line = br.readLine()) != null && currentLine <= limit) {                // keep the loop running until no text in the file
                if (line.contains("?")) {
                    this.question = line;                                                   //store the question
                }
                if (line.contains(":")) {
                    this.options[count++] = line;                                           // store all the options
                }
                if ((line.contains("A") || line.contains("B") || line.contains("C") || line.contains("D")) && !line.contains(":")) {
                    this.answer = line;                                                     // store the answer
                }
                currentLine++;
            }

            limit += 6;
            count = 0;
            
            // set the question, options and answer in the Question object
            quizQues.setQuestion(this.question);                                        
            quizQues.setAnswer(this.answer);
            quizQues.setOptions(this.options);
            System.out.println(quizQues.toString());                                        // print the ques and options

            System.out.println("Would you like to use one of the life lines? If so, type \"YES\" else please type a LETTER to submit your answer or \"Q\" to quit the game.");
            userAnswer = keyboard.nextLine();
            
            // ensure the user enters a valid input 
            if (!validUserInput(userAnswer)) {
                do {
                    System.out.println("Please enter a A,B,C,D or \"yes\" to access lifelines.");
                    userAnswer = keyboard.nextLine();
                } while (!validUserInput(userAnswer));
            }

            //runs if the user says yes to use lifelines
            if (userAnswer.equalsIgnoreCase("Yes") || userAnswer.equalsIgnoreCase("Y")) {
                do {
                    useLifeLine(quizQues, options, answer, question);
                    System.out.println("Would you like to use one of the life lines? If so, type yes else please type a LETTER to submit your answer or Q to quit the game.");
                    userAnswer = keyboard.nextLine();
                    
                    //ensure a valid input
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
                try {
                    leaderboard.addToTheFile(this.name, this.getMoneyWon());
                    leaderboard.displayLeaderBoard();
                    System.exit(0);
                } catch (IOException ex) {
                    System.out.println("Error: The leader board could not be displayed.");
                }
                
            }

            this.setMoneyWon(checkAnswer(userAnswer, answer, moneyWon));                //checks the player's answer and sets the moneyWon
            questionNumber++;

        }

        br.close();
        fr.close();
    }

    /**
     * This method checks the user's answer
     * @param userAnswer: the user's answer
     * @param answer : actual answer
     * @param moneyWon: the current amount the user has
     * @return
     * @throws FileNotFoundException
     * @throws IOException 
     */
    public int checkAnswer(String userAnswer, String answer, int moneyWon) throws FileNotFoundException, IOException {
        
        // checks if the user answered correctly and sets the money won accordingly
        if (userAnswer.equalsIgnoreCase(answer)) {
            if (moneyWon == 0) {
                moneyWon = 100;
            } else {
                moneyWon *= 2;
                if (moneyWon == 400 || this.moneyWon == 600) {
                    moneyWon -= 100;
                } else if (moneyWon == 128000) {
                    moneyWon -= 3000;
                }
            }
            System.out.println("Correct Answer! You've reached " + moneyWon + " dollars.\n"); //money
        } else {
            if (moneyWon >= 1000) {
                moneyWon = 1000;
            } else if (this.moneyWon >= 32000) {
                moneyWon = 32000;
            } else {
                moneyWon = 0;
            }
            System.out.println("Wrong Answer :(. The correct answer is " + answer + ". You are on " + moneyWon);
        }

        return moneyWon;
    }

    /**
     * This method processes the life line 
     * @param lifeline 
     * @param quizQues
     * @param options
     * @param answer
     * @param question 
     */
    private void useLifeLine(Questions quizQues, String[] options, String answer, String question) {
        lifeline = new Lifelines();                                                                         // instantiating the question class
        String chosenLifeLine = "";

        System.out.println("Type the related NUMBER to pick an option "
                + "\n1. 50:50"
                + "\n2. Phone a friend"
                + "\n3. Audience Vote");
        chosenLifeLine = keyboard.nextLine();
        if (!validLifeLineUserInput(chosenLifeLine)) {
            do {
                System.out.println("\nPlease choose 1, 2 or 3.");
                chosenLifeLine = keyboard.nextLine();
            } while (!validLifeLineUserInput(chosenLifeLine));
        }

        if (!chosenLifeLine.equalsIgnoreCase("Q")) {
            if (chosenLifeLine.equalsIgnoreCase("1")) {                                               // process the 50:50 option
                String[] resultedOption = lifeline.setFiftyFiftyOptions(options, answer, question);
                quizQues.setOptions(resultedOption);
                System.out.println(quizQues.toString());
            }
            if (chosenLifeLine.equalsIgnoreCase("2")) {                                               // process the phone a friend option
                lifeline.setPhoneAFriendOptions(options, answer, question);
                System.out.println(quizQues.toString());
            }
            if (chosenLifeLine.equalsIgnoreCase("3")) {                                               // process the set audience option
                quizQues.setOptions(lifeline.setAudienceVoteOptions(options, answer, question));        
                System.out.println(quizQues.toString());
            }
        } else {            
            //set the leaderboard before quitting if user enters Q for quit
            try {
                leaderboard.addToTheFile(this.name, this.getMoneyWon());
                leaderboard.displayLeaderBoard();
                System.exit(0);
            } catch (IOException ex) {
                System.out.println("Error: The leader board could not be displayed.");
            }
        }

    }

    private boolean validUserInput(String userAnswer) {
        if (userAnswer.equalsIgnoreCase("Q") || userAnswer.equalsIgnoreCase("Yes")
                || userAnswer.equalsIgnoreCase("A") || userAnswer.equalsIgnoreCase("B")
                || userAnswer.equalsIgnoreCase("C") || userAnswer.equalsIgnoreCase("D")) {
            return true;
        }
        return false;
    }

    private boolean validLifeLineUserInput(String userChoice) {
        if (userChoice.equalsIgnoreCase("Q") || userChoice.equalsIgnoreCase("1")
                || userChoice.equalsIgnoreCase("2") || userChoice.equalsIgnoreCase("3")) {
            return true;
        }
        return false;
    }

    public void setName(String n) {
        this.name = n;
    }

    public String getName() {
        return this.name;
    }
}
