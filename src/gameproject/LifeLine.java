package gameproject;

import java.util.Random;

/**
 *This class handles the life lines to alter the options accordingly
 * @author Amritpal Kaur
 * 14865526
 */
public class LifeLine {

    // variable declarations
    private String[] fiftyFiftyOptions;
    public boolean stateA = true;
    public boolean stateB = true;
    public boolean stateC = true;
    public boolean stateD = true;

    
    /**
     * Method for setting the fifty fifty options
     * @param optionA
     * @param optionB
     * @param optionC
     * @param optionD
     * @param answer
     * **/
    public void setFiftyFiftyOptions(String optionA, String optionB, String optionC, String optionD, String answer) {
        Random rand = new Random();
        
        // used to set one incorrect option to true along with the right option
        boolean setIncorrectOption = false;
        
        //sets the state of the boolean depending on if the option is the 'answer'
            if (!optionA.equalsIgnoreCase(answer)){             //check if the option is the answer
                if (!setIncorrectOption){                       // if it's not the answer and no incorrect option has been set to true
                    setIncorrectOption = true;                  // take this option as one of the options to display
                }
                else
                    this.setStateA(false);                      // else if an incorrect option has already been set along with the correct option 
                                                                // then make set it to false.
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
     * @param optionA - the options being displayed in GUI
     * @param optionB
     * @param optionC
     * @param optionD
     * @param answer - the actual answer of the question
     * @return an String 
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
                    // loops to find the answer 
                    if (option.equalsIgnoreCase(answer)){
                        return "\nYour friend has suggested to go for " + option + "\n";
                    }
                }
                //give an incorrect answer 
                else if (!option.equalsIgnoreCase(answer)){ 
                    return "\nYour friend has suggested to go for " + option + "\n";
                }
            }  
        return "I'm not sure";
    }
        

    /**
     * Method sets the % for the audience vote based on random number
     * @param optionA
     * @param optionB
     * @param optionC
     * @param optionD
     * @param answer
     * @return a string that has the audience vote concatenated to it
     */
    public String getAudienceVote(String optionA, String optionB, String optionC, String optionD, String answer) {
        Random r = new Random();
        int high = 100;
        
            //randomly choose probablity for each option
            int probabilityOne = r.nextInt(high);
            int probabilityTwo = r.nextInt(high - probabilityOne);
            int probabilityThree = r.nextInt(high - (probabilityTwo + probabilityOne));
            int probabilityFour = high - (probabilityTwo + probabilityOne + probabilityThree);
            
            //attach the probability at the end of the options
            return optionA + ", Audience Voted:" + probabilityOne + "% \n"+
                   optionB + ", Audience Voted:" + probabilityTwo + "% \n"+
                   optionC + ", Audience Voted:" + probabilityThree + "% \n"+
                   optionD + ", Audience Voted:" + probabilityFour + "%";
        
    }

    // get/set methods of the boolean for the lifelines
   
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
