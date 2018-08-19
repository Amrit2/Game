package gameproject;

import java.util.Random;

/**
 *This class handles life lines
 * @author Amritpal Kaur
 * 14865526
 */
public class Lifelines {

    private boolean usedFifty;
    private boolean usedCall;
    private boolean usedAudience;
    private String[] fiftyFiftyOptions;
    private String[] phoneAFriendOptions;

    /**
     * Constructor initializes the variables to false
     */
    public Lifelines() {
        usedFifty = false;
        usedCall = false;
        usedAudience = false;
    }

    /**
     * Method for setting the fifty fifty options
     * @param options
     * @param answer
     * @param question
     * @return an array that contains two options, one correct, one incorrect
     */
    public String[] setFiftyFiftyOptions(String[] options, String answer, String question) {
        Random rand = new Random();

        this.fiftyFiftyOptions = new String[2];
        if (this.getUsedFifty() == false) {                                     // ensure the options hasn't been used already
            this.setUsedFifty(true);
            this.fiftyFiftyOptions[0] = options[0];
            try {
                if (!options[0].contains(answer)) {                             // if place 0 doesn't have the answer then loop through to find and save the answer 
                    for (int i = 1; i < options.length; i++) {                  
                        if (options[i].contains(answer)) {
                            this.fiftyFiftyOptions[1] = options[i];             // if answer is found save it at place 1                
                        }   
                    }
                } else {
                    this.fiftyFiftyOptions[1] = options[1];                     // if place 0 has the answer, then save another option at 1
                }
                return this.fiftyFiftyOptions;
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Error: You are trying to access an illegal integer in the array");
            }
        }
        System.out.println("\nYou've already used this option\n");
        return options;
    }

    /**
     * Method for recommending an option, that gives the correct option 90% of the time
     * @param options
     * @param answer
     * @param question 
     */
    public void setPhoneAFriendOptions(String[] options, String answer, String question) {
        Random r = new Random();
        int low = 1;
        int high = 100;
        boolean showWrongAnswer = false;
        int probability = r.nextInt(high - low) + low;
        if (this.getUsedCall() == false) {                                              // ensure the options hasn't been used already
            this.setUsedCall(true);
            this.phoneAFriendOptions = new String[1];
            try {
                if (probability >= 10) {                                                //if the number picked is greater or equal to 10 give the correct answer
                    for (int i = 0; i < options.length; i++) {
                        if (options[i].contains(answer)) {
                           System.out.println("\nYour friend has suggested to go for " + options[i] + "\n");
                        }
                    }
                } else {
                    for (int i = 0; i < options.length; i++) {                          // else give a wrong answer
                        if (!options[i].contains(answer) && showWrongAnswer == false) {
                            showWrongAnswer = true;
                           System.out.println("\nYour friend has suggested to go for " + options[i] + "\n");
                        }
                    }
                }
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Error: You are trying to access an illegal integer in the array");
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
    public String[] setAudienceVoteOptions(String[] options, String question, String answer) {
        Random r = new Random();
        int high = 100;
        if (this.getUsedAudience() == false) {                                  // ensure the options hasn't been used already
            this.setUsedAudience(true);
            int probabilityOne = r.nextInt(high);
            int probabilityTwo = r.nextInt(high - probabilityOne);
            int probabilityThree = r.nextInt(high - (probabilityTwo + probabilityOne));
            int probabilityFour = high - (probabilityTwo + probabilityOne + probabilityThree);

            try {
                options[0] = options[0] + ", Audience Voted:" + probabilityOne + "%";
                options[1] = options[1] + ", Audience Voted:" + probabilityTwo + "%";
                options[2] = options[2] + ", Audience Voted:" + probabilityThree + "%";
                options[3] = options[3] + ", Audience Voted:" + probabilityFour + "%";
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Error: You are trying to access an illegal integer in the array");
            }

            return options;
        }
        System.out.println("\nYou've already used this option\n");
        return options;
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

    public boolean getUsedFifty() {
        return this.usedFifty;
    }

    public boolean getUsedCall() {
        return this.usedCall;
    }

    public boolean getUsedAudience() {
        return this.usedAudience;
    }
}
