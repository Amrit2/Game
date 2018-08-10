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

    private boolean used = false;
    private String[] fiftyFiftyOptions;
    private String phoneAFriendOptions;
    private String[] audienceVoteOptions;

    public Lifelines(String chosenLifeLine, String[] options, String answer) {
        if (chosenLifeLine.equalsIgnoreCase("2")) {
            this.setFiftyFiftyOptions(options, answer);
        }
        if (chosenLifeLine.equalsIgnoreCase("2")) {
            this.setPhoneAFriendOptions(options, answer);
        }
        if (chosenLifeLine.equalsIgnoreCase("3")) {
            this.setAudienceVoteOptions(options, answer);
        }
    }

    public void setFiftyFiftyOptions(String[] options, String answer) {
        int number = 1;
        this.fiftyFiftyOptions = new String[options.length];
        for (int i = 0; i < fiftyFiftyOptions.length; i++) {
            for (int j = 0; j < options.length; j++) {
                if (options[j] == answer) {
                    fiftyFiftyOptions[i] = options[j];
                }
                while (number <= 1) {
                    fiftyFiftyOptions[i] = options[j];
                    number++;
                }
            }
        }
    }

    public void setPhoneAFriendOptions(String[] options, String answer) {
        Random r = new Random();
        int low = 1;
        int high = 100;
        int probability = r.nextInt(high - low) + low;
        if (probability >= 10){
            this.phoneAFriendOptions = answer;
        }
    }

    public void setAudienceVoteOptions(String[] options, String answer) {
        Random r = new Random();
        int low = 1;
        int high = 100;
        int probabilityOne = r.nextInt(high - low) + low;
        int probabilityTwo = r.nextInt(high - probabilityOne) + low;
        int probabilityThree = r.nextInt(high - probabilityTwo) + low;
        int probabilityFour = r.nextInt(high - probabilityThree) + low;
        for (String s : options){
           
        }
    }

    public String[] getFiftyFiftyOptions() {
        String[] alteredOptions = new String[1];
        if (used != true) {
            for (int i = 0; i < alteredOptions.length; i++) {
                for (String s : this.fiftyFiftyOptions) {
                    if (s != null) {
                        alteredOptions[i] = s;
                    }
                }
            }
        }
        used = true;
        return alteredOptions;
    }

    public String getPhoneAFriendOptions() {
       return this.phoneAFriendOptions;
    }

    public String[] getAudienceVoteOptions() {
        String[] alteredOptions = new String[1];
        if (used != true) {
            for (int i = 0; i < alteredOptions.length; i++) {
                for (String s : this.audienceVoteOptions) {
                     if (s!= null){
                         alteredOptions[i] =s;
                     }
                }
            }
        }

        used = true;
        return alteredOptions;
    }
}
