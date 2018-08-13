/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameproject;

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

        if (probability >= 10) {
            this.phoneAFriendOptions[0] = answer;

        }
        Questions ques = new Questions(question, this.phoneAFriendOptions, answer);
        ques.toString();
    }

    public void setAudienceVoteOptions(String[] options, String question, String answer) {
        this.audienceVoteOptions = new String[options.length];
        Random r = new Random();
        this.setUsedAudience();
        int low = 1;
        int high = 100;
        int probabilityOne = r.nextInt(high - low) + low;
        int probabilityTwo = r.nextInt(high - probabilityOne) + low;
        int probabilityThree = r.nextInt(high - probabilityTwo) + low;
        int probabilityFour = r.nextInt(high - probabilityThree) + low;

        options[0] = options[0] + " Audience Vote:" + probabilityOne;
        options[1] = options[0] + " Audience Vote:" + probabilityTwo;
        options[2] = options[0] + " Audience Vote:" + probabilityThree;
        options[3] = options[0] + " Audience Vote:" + probabilityFour;
        for (int i = 0; i < audienceVoteOptions.length; i++) {
            for (String s : options) {
                audienceVoteOptions[i] = s;
            }
        }
        Questions ques = new Questions(question, this.audienceVoteOptions, answer);
        ques.toString();
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
