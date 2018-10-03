package gameproject;

import java.util.Map;
import java.util.Random;
import java.util.Scanner;

/**
 *This class handles the life lines to alter the options accordingly
 * @author Amritpal Kaur
 * 14865526
 */
public class Lifelines {

    // variable declarations
    private boolean usedFifty;
    private boolean usedCall;
    private boolean usedAudience;
    private String[] fiftyFiftyOptions;
    private boolean showWrongAnswer = false;
    Scanner keyboard;

    /**
     * Constructor initializes the variables to false
     */
    public Lifelines() {
        usedFifty = false;
        usedCall = false;
        usedAudience = false;
        keyboard = new Scanner(System.in);
    }

    /**
     * This method processes the user input by calling the corresponding methods
     * @param player
     * @param database
     * @param hMap
     * @param currentQuestionNumber
     * @param leaderboard
     * @param quizQues 
     */
    public void useLifeLine(Map<Integer, Questions> hMap, int currentQuestionNumber) {
        String chosenLifeLine = "";

        // process the life line chosen if the user didn't choose q
        if (!chosenLifeLine.equalsIgnoreCase("Q")) {
            if (chosenLifeLine.equalsIgnoreCase("1")) {                                               // process the 50:50 option
                this.setFiftyFiftyOptions(hMap, currentQuestionNumber);
            }
            if (chosenLifeLine.equalsIgnoreCase("2")) {                                               // process the phone a friend option
                this.setPhoneAFriendOptions(hMap, currentQuestionNumber);
            }
            if (chosenLifeLine.equalsIgnoreCase("3")) {                                               // process the set audience option
                this.setAudienceVoteOptions(hMap, currentQuestionNumber);
                
            }
        }
    }
    
    /**
     * Method for setting the fifty fifty options
     * @param hMap
     * @param currentQuestion
     * @param options
     * @param answer
     * @param question
     * @return an array that contains two options, one correct, one incorrect
     */
    public void setFiftyFiftyOptions(Map<Integer, Questions> hMap, int currentQuestion) {
        Random rand = new Random();
        this.fiftyFiftyOptions = new String[2];
        if (this.usedFifty() == false) {                                     // ensure the options hasn't been used already
            this.setUsedFifty(true);
            String[] options = hMap.get(currentQuestion).getOptions();
            this.fiftyFiftyOptions[0] = options[0];
            try {
                if (!options[0].contains(hMap.get(currentQuestion).getAnswer())) {                             // if place 0 doesn't have the answer then loop through to find and save the answer 
                    for (int i = 1; i < options.length; i++) {                  
                        if (options[i].contains(hMap.get(currentQuestion).getAnswer())) {
                            this.fiftyFiftyOptions[1] = options[i];             // if answer is found save it at place 1                
                        }   
                    }
                } else {
                    this.fiftyFiftyOptions[1] = options[1];                     // if place 0 has the answer, then save another option at 1
                }
                hMap.put(currentQuestion, new Questions(hMap.get(currentQuestion).getQuestion(), this.fiftyFiftyOptions, hMap.get(currentQuestion).getAnswer()));
                System.out.println(hMap.get(currentQuestion));
                
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("The array that stores the options is of the incorrect length.");
            }
        }
        else
            System.out.println("\nYou've already used this option\n");
    }

    /**
     * Method for recommending an option, that gives the correct option 90% of the time
     * @param options
     * @param answer
     * @param question 
     */
    public void setPhoneAFriendOptions(Map<Integer, Questions> hMap, int currentQuestion) {
        Random r = new Random();
        int low = 1;
        int high = 100;
        String[] options = hMap.get(currentQuestion).getOptions();
        // randoly choose a number which decides if the right answer is given or not
        int probability = r.nextInt(high - low) + low;
        if (this.usedFriendCall() == false) {                                              // ensure the options hasn't been used already
            this.setUsedCall(true);
            try {
                if (probability >= 10) {                                                //if the number picked is greater or equal to 10 give the correct answer
                    for (int i = 0; i < options.length; i++) {
                        if (options[i].contains(hMap.get(currentQuestion).getAnswer())) {
                           System.out.println("\nYour friend has suggested to go for " + options[i] + "\n");
                        }
                    }
                } else {
                    for (int i = 0; i < options.length; i++) {                          // else give a wrong answer
                        if (!options[i].contains(hMap.get(currentQuestion).getAnswer()) && this.getShowWrongAnswer() == false) {
                            this.setShowWrongAnswer(true);
                           System.out.println("\nYour friend has suggested to go for " + options[i] + "\n");
                        }
                    }
                }
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("The array that stores the options is of the incorrect length.");
            }
        } else {
            System.out.println("\nYou've already used this option\n");
        }

    }

    /**
     * Method sets the % for the audience vote based on random number
     * @param options
     * @param question
     * @param answer
     * @return an array of options that has a percentage attached to each option
     */
    public void setAudienceVoteOptions(Map<Integer, Questions> hMap, int currentQuestion) {
        Random r = new Random();
        int high = 100;
        String[] options = hMap.get(currentQuestion).getOptions();
        String question = hMap.get(currentQuestion).getQuestion();
        String answer = hMap.get(currentQuestion).getAnswer();
        if (this.usedAudienceVote() == false) {                                  // ensure the options hasn't been used already
            this.setUsedAudience(true);
            
            //randomly choose probablity for each option
            int probabilityOne = r.nextInt(high);
            int probabilityTwo = r.nextInt(high - probabilityOne);
            int probabilityThree = r.nextInt(high - (probabilityTwo + probabilityOne));
            int probabilityFour = high - (probabilityTwo + probabilityOne + probabilityThree);

            // rewrite the options to include probability
            try {
                options[0] = options[0] + ", Audience Voted:" + probabilityOne + "%";
                options[1] = options[1] + ", Audience Voted:" + probabilityTwo + "%";
                options[2] = options[2] + ", Audience Voted:" + probabilityThree + "%";
                options[3] = options[3] + ", Audience Voted:" + probabilityFour + "%";
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("The array that stores the options is of the incorrect length.");
            }

            hMap.put(currentQuestion, new Questions(question, options, answer));
            System.out.println(hMap.get(currentQuestion));    
        }
        else
            System.out.println("\nYou've already used this option\n");
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
    
    // get/set methods of the boolean for the lifelines
    public void setUsedFifty(boolean used) {
        this.usedFifty = used;
    }

    public void setUsedCall(boolean used) {
        this.usedCall = used;
    }

    public void setUsedAudience(boolean used) {
        this.usedAudience = used;
    }

    public void setShowWrongAnswer(boolean state){
        this.showWrongAnswer = state;
    }
    
    public boolean usedFifty() {
        return this.usedFifty;
    }

    public boolean usedFriendCall() {
        return this.usedCall;
    }

    public boolean usedAudienceVote() {
        return this.usedAudience;
    }
    
    public boolean getShowWrongAnswer(){
        return this.showWrongAnswer;
    }
}
