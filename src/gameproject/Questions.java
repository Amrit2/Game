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

    public Questions(String question, String[] option, String answer) {
        setQuestion(question);
        setOptions(option);
        setAnswer(answer);
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
                        options[i] = inputOption[j];
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
                    alternatives[j] = options[i];
                }
            }
        }
        return alternatives;
    }

    public String getAnswer() {
        return this.answer;
    }

    public String toString() {
        String output = "Your question is: \n" + this.getQuestion() + "\n";
        for (String choice : this.getOptions()) {
            output += choice + "\n";
        }
        return output;
    }
}
