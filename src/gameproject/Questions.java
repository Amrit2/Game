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
    
    public Questions(String question, String[] option, String answer){
        setQuestion(question);
        this.options = new String[4];
        setOptions(option);
        setAnswer(answer);
    }
    
    public void setQuestion(String inputQuestion){
        this.question = inputQuestion;
    }
    
    public void setOptions(String[] inputOption){
        if (inputOption != null){
            for (String s: inputOption){
                for (int i = 0; i< this.options.length; i++){
                    this.options[i] = s; 
                }
            }
        }
    }
    
    public void setAnswer(String answer){
        this.answer = answer;
    }
    
    public String getQuestion(){
        return this.question;
    }
    
    public String[] getOptions(){
        String[] alternatives = new String[this.options.length];
        for (String s: this.options){
            if (s != null){
                for (int i = 0; i < alternatives.length; i++){
                    alternatives[i] = s;
                }
            }
        }
        return alternatives;
    }
    
    public String getAnswer(){
        return this.answer;
    }
    
    public String toString(){
//        String option = Arrays.toString(this.getOptions()).replace('[', ' ');
//	option = option.replace(']', ' ');
        String output = "Your question is: \n" + this.getQuestion() + "\n";
        for (String choice: this.getOptions()){
            output += choice + "\n";
        }
        return output;
    }
}
