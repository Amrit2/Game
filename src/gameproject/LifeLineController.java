package gameproject;

import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

/**
 *This class acts as the median between the View and Model for the logic related to the lifelines
 * @author Amritpal Kaur
 * 14865526
 */
public class LifeLineController {
    public LifeLine lifeLine;
    private boolean usedFifty;
    private boolean usedCall;
    private boolean usedAudience;
    
    public LifeLineController(){
        usedFifty = false;
        lifeLine = new LifeLine();
    }

    public void processChosenOption(String chosenLifeLine, JRadioButton optionA, JRadioButton optionB, JRadioButton optionC, JRadioButton optionD, String answer) {
        String[] optiona = optionA.getText().split(":");
        String[] optionb = optionB.getText().split(":");
        String[] optionc = optionC.getText().split(":");
        String[] optiond = optionD.getText().split(":");
        if (chosenLifeLine.equalsIgnoreCase("50:50")){
            if (!this.usedFifty()) { 
                this.setUsedFifty(true);
                lifeLine.setFiftyFiftyOptions(optiona[0],optionb[0], optionc[0], optiond[0], answer);
                
                System.out.println("Options: " + optiona[0] + " " + optionb[0] + " " + optionc[0] + " " + optiond[0]);
                System.out.println("Answer : " + answer);
                System.out.println("LifeLine status" +lifeLine.getStateA() + " " +  lifeLine.getStateB() + " " + lifeLine.getStateC() + " " +lifeLine.getStateD());
                
                optionA.setVisible(lifeLine.getStateA());
                optionB.setVisible(lifeLine.getStateB());
                optionC.setVisible(lifeLine.getStateC());
                optionD.setVisible(lifeLine.getStateD());
            }
            else
             JOptionPane.showMessageDialog(null,"\nYou've already used this option\n");
        }
        else if (chosenLifeLine.equalsIgnoreCase("Phone A Friend")){
            if (!this.usedFriendCall()) {                                              // ensure the options hasn't been used already
                this.setUsedCall(true);
                JOptionPane.showMessageDialog(null,lifeLine.getMessageFromFriend(optiona[0],optionb[0], optionc[0], optiond[0], answer));
            } 
            else 
                JOptionPane.showMessageDialog(null,"\nYou've already used this option\n");
        }
        else if (chosenLifeLine.equalsIgnoreCase("Audience Vote")){
            if (!this.usedAudienceVote()) {                                  // ensure the options hasn't been used already
                this.setUsedAudience(true);
                
                JOptionPane.showMessageDialog(null,lifeLine.getAudienceVote(optionA.getText(),optionB.getText(), optionC.getText(), optionD.getText(), answer));
            }
            else
                JOptionPane.showMessageDialog(null,"\nYou've already used this option\n");
            }
    }
    
    public void setUsedFifty(boolean used) {
        this.usedFifty = used;
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
    public void setUsedCall(boolean used) {
        this.usedCall = used;
    }

    public void setUsedAudience(boolean used) {
        this.usedAudience = used;
    }
    
}
