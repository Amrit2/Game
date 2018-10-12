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
public class LifeLine {

    // variable declarations
    private String[] fiftyFiftyOptions;
    private boolean showWrongAnswer = false;
    public boolean stateA = true;
    public boolean stateB = true;
    public boolean stateC = true;
    public boolean stateD = true;

    
    /**
     * Method for setting the fifty fifty options
     * @param answer
     * **/
    public void setFiftyFiftyOptions(String optionA, String optionB, String optionC, String optionD, String answer) {
        Random rand = new Random();
        boolean setIncorrectOption = false;
            if (!optionA.equalsIgnoreCase(answer)){
                if (!setIncorrectOption){
                    setIncorrectOption = true;
                }
                else
                    this.setStateA(false);
            }
            if (!optionB.equalsIgnoreCase(answer)){
                if (!setIncorrectOption){
                    setIncorrectOption = true;
                }
                else 
                    this.setStateB(false);
            }
            if (!optionC.equalsIgnoreCase(answer)){
                if (!setIncorrectOption){
                    setIncorrectOption = true;
                }
                else
                    this.setStateC(false);
            }
            if (!optionD.equalsIgnoreCase(answer)){
                if (!setIncorrectOption){
                    setIncorrectOption = true;
                }
                else
                    this.setStateD(false);
            }
    }

    /**
     * Method for recommending an option, that gives the correct option 90% of the time
     * @param answer
     * @param question 
     */
    public String getMessageFromFriend(String optionA, String optionB, String optionC, String optionD, String answer) {
      Random r = new Random();
        int low = 1;
        int high = 100;
        String[] options = new String [4];
        options[0] = optionA;
        options[1] = optionB;
        options[2] = optionC;
        options[3] = optionD;
        
        // randoly choose a number which decides if the right answer is given or not
        int probability = r.nextInt(high - low) + low;
            for (String option: options){
                if (probability >= 10){
                    if (option.equalsIgnoreCase(answer)){
                        return "\nYour friend has suggested to go for " + option + "\n";
                    }
                }
                else if (!option.equalsIgnoreCase(answer)){  // --------&& !giveAnswer
                    return "\nYour friend has suggested to go for " + option + "\n";
//                    giveAnswer = true;
                }
            }  
        return "I'm not sure";
    }
        

    /**
     * Method sets the % for the audience vote based on random number
     * @param options
     * @param question
     * @param answer
     * @return an array of options that has a percentage attached to each option
     */
    public String getAudienceVote(JRadioButton optionA, JRadioButton optionB, JRadioButton optionC, JRadioButton optionD, String answer) {
        Random r = new Random();
        int high = 100;
        
            //randomly choose probablity for each option
            int probabilityOne = r.nextInt(high);
            int probabilityTwo = r.nextInt(high - probabilityOne);
            int probabilityThree = r.nextInt(high - (probabilityTwo + probabilityOne));
            int probabilityFour = high - (probabilityTwo + probabilityOne + probabilityThree);
            return optionA.getText() + ", Audience Voted:" + probabilityOne + "% \n"+
                                                optionB.getText() + ", Audience Voted:" + probabilityTwo + "% \n"+
                                                optionC.getText() + ", Audience Voted:" + probabilityThree + "% \n"+
                                                optionD.getText() + ", Audience Voted:" + probabilityFour + "%";
        
    }

    // get/set methods of the boolean for the lifelines
   
    public void setShowWrongAnswer(boolean state){
        this.showWrongAnswer = state;
    }
    
    public boolean getShowWrongAnswer(){
        return this.showWrongAnswer;
    }

    public void setStateA (boolean state){
        this.stateA = state;
    }
    
    public void setStateB (boolean state){
        this.stateB = state;
    }
    public void setStateC (boolean state){
        this.stateC = state;
    }
    
    public void setStateD (boolean state){
        this.stateD = state;
    }
    
    public boolean getStateA (){
        return this.stateA;
    }
    
    public boolean getStateB (){
        return this.stateB;
    }
    
    public boolean getStateC (){
        return this.stateC;
    }
    
    public boolean getStateD (){
        return this.stateD;
    }
}
