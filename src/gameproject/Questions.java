/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameproject;

import java.util.Arrays;

/**
 *
 * @author Amrit
 */
public class Questions {

    private String question;
    private String[] options;
    private String answer;

    public Questions(String q, String[] o, String a) {
        this.question = q;
        this.options = o;
        this.answer = a;
    }

    public void setQuestion(String inputQuestion) {
        this.question = inputQuestion;
    }

    public void setOptions(String[] inputOption) {
        this.options = new String[inputOption.length];
        if (inputOption != null) {
            for (int i = 0; i < inputOption.length; i++) {

                for (int j = 0; j < options.length; j++) {
                    if (i == j) {
                        try {
                            options[i] = inputOption[j];
                        } catch (ArrayIndexOutOfBoundsException e) {
                            System.out.println("Error: You are trying to access an illegal integer in the array");
                        }
                    }
                }

            }
        }
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getQuestion() {
        return this.question;
    }

    public String[] getOptions() {
        String[] alternatives = new String[this.options.length];
        for (int i = 0; i < options.length; i++) {
            for (int j = 0; j < alternatives.length; j++) {
                if (i == j && options[i] != null) {
                    try{
                    alternatives[j] = options[i];
                    } catch (ArrayIndexOutOfBoundsException e) {
                            System.out.println("Error: You are trying to access an illegal integer in the array");
                        }
                }
            }
        }
        return alternatives;
    }

    public String getAnswer() {
        return this.answer;
    }

    public String toString() {
        String output = "\nYour question is: \n" + this.getQuestion() + "\n";
        for (String choice : this.getOptions()) {
            output += choice + "\n";
        }
        return output;
    }
}
