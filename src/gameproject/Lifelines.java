package gameproject;

import java.util.Random;
import java.util.Scanner;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

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
    
    public void processChosenLifeLine(String chosenLifeLine, JRadioButton optionA, JRadioButton optionB, JRadioButton optionC, JRadioButton optionD, String answer) {
        if (chosenLifeLine.equalsIgnoreCase("50:50")){
           this.setFiftyFiftyOptions(optionA,optionB, optionC, optionD, answer);
        }
        else if (chosenLifeLine.equalsIgnoreCase("Phone A Friend")){
            this.setPhoneAFriendOptions(optionA,optionB, optionC, optionD, answer);
        }
        else if (chosenLifeLine.equalsIgnoreCase("Audience Vote")){
            this.setAudienceVoteOptions(optionA,optionB, optionC, optionD, answer);
        }
        
    }

    
    
    /**
     * Method for setting the fifty fifty options
     * @param answer
     * **/
    private void setFiftyFiftyOptions(JRadioButton optionA, JRadioButton optionB, JRadioButton optionC, JRadioButton optionD, String answer) {
        Random rand = new Random();
        String[] optiona = optionA.getText().split(":");
        String[] optionb = optionB.getText().split(":");
        String[] optionc = optionC.getText().split(":");
        String[] optiond = optionD.getText().split(":");
        boolean setIncorrectOption = false;
        if (this.usedFifty() == false) {                                     // ensure the options hasn't been used already
            this.setUsedFifty(true);
            
            if (!optiona[0].equalsIgnoreCase(answer)){
                if (!setIncorrectOption){
                    setIncorrectOption = true;
                }
                else
                    optionA.setVisible(false);
            }
            if (!optionb[0].equalsIgnoreCase(answer)){
                if (!setIncorrectOption){
                    setIncorrectOption = true;
                }
                else 
                    optionB.setVisible(false);
            }
            if (!optionc[0].equalsIgnoreCase(answer)){
                if (!setIncorrectOption){
                    setIncorrectOption = true;
                }
                else
                    optionC.setVisible(false);
            }
            if (!optiond[0].equalsIgnoreCase(answer)){
                if (!setIncorrectOption){
                    setIncorrectOption = true;
                }
                else
                    optionD.setVisible(false);
            }
        }
        else
             JOptionPane.showMessageDialog(null,"\nYou've already used this option\n");
    }

    /**
     * Method for recommending an option, that gives the correct option 90% of the time
     * @param answer
     * @param question 
     */
    private void setPhoneAFriendOptions(JRadioButton optionA, JRadioButton optionB, JRadioButton optionC, JRadioButton optionD, String answer) {
        Random r = new Random();
        int low = 1;
        int high = 100;
        boolean giveAnswer = false;
        String[] optiona = optionA.getText().split(":");
        String[] optionb = optionB.getText().split(":");
        String[] optionc = optionC.getText().split(":");
        String[] optiond = optionD.getText().split(":");
        String[] options = new String [4];
        options[0] = optiona[0];
        options[1] = optionb[0];
        options[2] = optionc[0];
        options[3] = optiond[0];
        
        // randoly choose a number which decides if the right answer is given or not
        int probability = r.nextInt(high - low) + low;
        if (this.usedFriendCall() == false) {                                              // ensure the options hasn't been used already
            this.setUsedCall(true);
            for (String option: options){
                 if (probability >= 10){
                    if (option.equalsIgnoreCase(answer)){
                        JOptionPane.showMessageDialog(null,"\nYour friend has suggested to go for " + option + "\n");
                    }
                }
                else if (!option.equalsIgnoreCase(answer) && !giveAnswer){
                    JOptionPane.showMessageDialog(null,"\nYour friend has suggested to go for " + option + "\n");
                    giveAnswer = true;
                }
            }
            
        } 
        else 
             JOptionPane.showMessageDialog(null,"\nYou've already used this option\n");
    }

    /**
     * Method sets the % for the audience vote based on random number
     * @param options
     * @param question
     * @param answer
     * @return an array of options that has a percentage attached to each option
     */
    private void setAudienceVoteOptions(JRadioButton optionA, JRadioButton optionB, JRadioButton optionC, JRadioButton optionD, String answer) {
        Random r = new Random();
        int high = 100;
        if (this.usedAudienceVote() == false) {                                  // ensure the options hasn't been used already
            this.setUsedAudience(true);
            
            //randomly choose probablity for each option
            int probabilityOne = r.nextInt(high);
            int probabilityTwo = r.nextInt(high - probabilityOne);
            int probabilityThree = r.nextInt(high - (probabilityTwo + probabilityOne));
            int probabilityFour = high - (probabilityTwo + probabilityOne + probabilityThree);
            JOptionPane.showMessageDialog(null, optionA.getText() + ", Audience Voted:" + probabilityOne + "% \n"+
                                                optionB.getText() + ", Audience Voted:" + probabilityTwo + "% \n"+
                                                optionC.getText() + ", Audience Voted:" + probabilityThree + "% \n"+
                                                optionD.getText() + ", Audience Voted:" + probabilityFour + "%");
        }
        else
            JOptionPane.showMessageDialog(null,"\nYou've already used this option\n");
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
