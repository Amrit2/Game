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
            this.setFiftyFiftyOptions(options, answer, question);
        }
        if (chosenLifeLine.equalsIgnoreCase("2")) {
            this.setPhoneAFriendOptions(options, answer, question);
        }
        if (chosenLifeLine.equalsIgnoreCase("3")) {
            this.setAudienceVoteOptions(options, question, answer);
        }

    }

    public void setFiftyFiftyOptions(String[] options, String answer, String question) {
        System.out.println("I'm in fifty fifty");
        int number = 1;
        this.fiftyFiftyOptions = new String[1];
        if (this.usedFifty != true) {
            System.out.println("I'm being used fifty fifty");
            for (String s : options){
                for (int i = 0; i < this.fiftyFiftyOptions.length; i++){
                   do {
                       this.fiftyFiftyOptions[i] = s;
                   } while (s == answer);
                   
                }
                
            }
            
            Questions ques = new Questions(question, this.fiftyFiftyOptions, answer);
            ques.toString();
            this.usedFifty = true;
        } else {
            System.out.println("You've already used this lifeline.");
        }

    }

    public void setPhoneAFriendOptions(String[] options, String answer, String question) {
        Random r = new Random();
        int low = 1;
        int high = 100;
        int probability = r.nextInt(high - low) + low;

        if (this.usedCall != true) {
            if (probability >= 10) {
                this.phoneAFriendOptions[0] = answer;
                this.usedCall = true;
            } 
            Questions ques = new Questions(question, this.phoneAFriendOptions, answer);
            ques.toString();
        }
        else {
            System.out.println("You've already used this lifeline.");
        }
            
    }

    public void setAudienceVoteOptions(String[] options, String question, String answer) {
        this.audienceVoteOptions = new String[options.length];
        Random r = new Random();
        int low = 1;
        int high = 100;
        int probabilityOne = r.nextInt(high - low) + low;
        int probabilityTwo = r.nextInt(high - probabilityOne) + low;
        int probabilityThree = r.nextInt(high - probabilityTwo) + low;
        int probabilityFour = r.nextInt(high - probabilityThree) + low;

        if (this.usedAudience != true) {
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
            this.usedAudience = true;
        } else {
            System.out.println("You've already used this lifeline.");
        }
    }

    public String[] getFiftyFiftyOptions() {
        return this.fiftyFiftyOptions;
//        String[] alteredOptions = new String[1];
//        if (used != true) {
//            for (int i = 0; i < alteredOptions.length; i++) {
//                for (String s : this.fiftyFiftyOptions) {
//                    if (s != null) {
//                        alteredOptions[i] = s;
//                    }
//                }
//            }
//        } else {
//            System.out.println("You've already used this lifeline.");
//        }
//        used = true;
//        return alteredOptions;
    }

    public String[] getPhoneAFriendOptions() {
        return this.phoneAFriendOptions;
//        String[] alteredOptions = new String[1];
//        if (used != true) {
//            for (int i = 0; i < alteredOptions.length; i++) {
//                for (String s : this.phoneAFriendOptions) {
//                    if (s != null) {
//                        alteredOptions[i] = s;
//                    }
//                }
//            }
//        } else {
//            System.out.println("You've already used this lifeline.");
//        }
//        used = true;
//        return alteredOptions;
    }

    public String[] getAudienceVoteOptions() {
        return this.audienceVoteOptions;
//        String[] alteredOptions = new String[1];
//        if (used != true) {
//            for (int i = 0; i < alteredOptions.length; i++) {
//                for (String s : this.audienceVoteOptions) {
//                    if (s != null) {
//                        alteredOptions[i] = s;
//                    }
//                }
//            }
//        } else {
//            System.out.println("You've already used this lifeline.");
//        }
//        used = true;
//        return alteredOptions;
    }
}
