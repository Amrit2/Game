/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameproject;

import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author Amrit
 */
public class Lifelines {

    private boolean usedFifty;
    private boolean usedCall;
    private boolean usedAudience;
    private String[] fiftyFiftyOptions;
    private String[] phoneAFriendOptions;
    private String[] audienceVoteOptions;

    public Lifelines(String chosenLifeLine, String[] options, String answer, String question) {
        if (chosenLifeLine.equalsIgnoreCase("1")) {
            if (this.getUsedFifty() != true) {
                this.setFiftyFiftyOptions(options, answer, question);
            } else {
                System.out.println("You've already used this option.");
            }
        }
        if (chosenLifeLine.equalsIgnoreCase("2")) {
            if (this.getUsedCall() != true) {
                this.setPhoneAFriendOptions(options, answer, question);
            } else {
                System.out.println("You've already used this option.");
            }
        }
        if (chosenLifeLine.equalsIgnoreCase("3")) {
            if (this.getUsedAudience() != true) {
                this.setAudienceVoteOptions(options, question, answer);
            } else {
                System.out.println("You've already used this option.");
            }
        }

    }

    public void setFiftyFiftyOptions(String[] options, String answer, String question) {
        Random rand = new Random();
        this.setUsedFifty();
        this.fiftyFiftyOptions = new String[2];

        this.fiftyFiftyOptions[0] = options[0];
        if (!options[0].contains(answer)) {
            for (int i = 1; i < options.length; i++) {
                if (options[i].contains(answer)){
                    this.fiftyFiftyOptions[1] = options[i];
                } 
            }
        } else {
            this.fiftyFiftyOptions[1] = options[1];
        }

        Questions ques = new Questions(question, this.fiftyFiftyOptions, answer);
        System.out.println("\n" + ques.toString());

    }

    public void setPhoneAFriendOptions(String[] options, String answer, String question) {
        Random r = new Random();
        this.setUsedCall();
        int low = 1;
        int high = 100;
        int probability = r.nextInt(high - low) + low;
        this.phoneAFriendOptions = new String[1];
        if (probability >= 10) {
            for (int i = 0; i < options.length; i++){
                if (options[i].contains(answer)){
                     this.phoneAFriendOptions[0] = options[i];
                }
            }
        }
        for (String s : this.phoneAFriendOptions){
            System.out.println("\nYour friend has suggested to go for " + s);
        }
       
    }

    public void setAudienceVoteOptions(String[] options, String question, String answer) {
        Random r = new Random();
        this.setUsedAudience();
        int high = 100;
        
        int probabilityOne = r.nextInt(high);
        int probabilityTwo = r.nextInt(high - probabilityOne);
        int probabilityThree = r.nextInt(high - (probabilityTwo + probabilityOne));
        int probabilityFour = high - (probabilityTwo + probabilityOne+ probabilityThree);

        options[0] = options[0] + ", Audience Voted:" + probabilityOne;
        options[1] = options[1] + ", Audience Voted:" + probabilityTwo;
        options[2] = options[2] + ", Audience Voted:" + probabilityThree;
        options[3] = options[3] + ", Audience Voted:" + probabilityFour;

        Questions ques = new Questions(question, options, answer);
        System.out.println(ques.toString());
    }

    public void setUsedFifty() {
        this.usedFifty = true;
    }

    public void setUsedCall() {
        this.usedCall = true;
    }

    public void setUsedAudience() {
        this.usedAudience = true;
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
