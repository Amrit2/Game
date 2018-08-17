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

    public Lifelines() {
        usedFifty = false;
        usedCall = false;
        usedAudience = false;
    }

    public String[] setFiftyFiftyOptions(String[] options, String answer, String question) {
        Random rand = new Random();

        this.fiftyFiftyOptions = new String[2];
        if (this.getUsedFifty() == false) {
            this.setUsedFifty(true);
            this.fiftyFiftyOptions[0] = options[0];
            if (!options[0].contains(answer)) {
                for (int i = 1; i < options.length; i++) {
                    if (options[i].contains(answer)) {
                        this.fiftyFiftyOptions[1] = options[i];
                    }
                }
            } else {
                this.fiftyFiftyOptions[1] = options[1];
            }
            return this.fiftyFiftyOptions;
        }

        System.out.println("\nYou've already used this option\n");
        return options;

    }

    public void setPhoneAFriendOptions(String[] options, String answer, String question) {
        Random r = new Random();
        int low = 1;
        int high = 100;
        int probability = r.nextInt(high - low) + low;
        if (this.getUsedCall() == false) {
            this.setUsedCall(true);
            this.phoneAFriendOptions = new String[1];
            if (probability >= 10) {
                for (int i = 0; i < options.length; i++) {
                    if (options[i].contains(answer)) {
                        this.phoneAFriendOptions[0] = options[i];
                    }
                }
            }
            for (String s : this.phoneAFriendOptions) {
                System.out.println("\nYour friend has suggested to go for " + s + "\n");
            }

        } else {
            System.out.println("\nYou've already used this option\n");
        }

    }

    public String[] setAudienceVoteOptions(String[] options, String question, String answer) {
        Random r = new Random();
        int high = 100;
        if (this.getUsedAudience() == false) {
            this.setUsedAudience(true);
            int probabilityOne = r.nextInt(high);
            int probabilityTwo = r.nextInt(high - probabilityOne);
            int probabilityThree = r.nextInt(high - (probabilityTwo + probabilityOne));
            int probabilityFour = high - (probabilityTwo + probabilityOne + probabilityThree);

            options[0] = options[0] + ", Audience Voted:" + probabilityOne + "%";
            options[1] = options[1] + ", Audience Voted:" + probabilityTwo + "%";
            options[2] = options[2] + ", Audience Voted:" + probabilityThree + "%";
            options[3] = options[3] + ", Audience Voted:" + probabilityFour + "%";

            return options;
        }
        System.out.println("\nYou've already used this option\n");
        return options;
    }

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
