package gameproject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

/**
 * This class is the link between the view and Read questions file. It gets the questions and sets the view 
 * @author Amritpal Kaur 14865526
 */
public class GamePlayController {

    //declarations
    private final ReadQuestionsFile quiz;
    private Map<Integer, Questions> hMap;
    private int currentQuestionNumber = 0;
    private List questionsAsked;
    
    /**
     * The constructor instantiates the ReadQuestionsFile, an array and a HashMap
     * @param name of the player
     */
    public GamePlayController() {
        quiz = new ReadQuestionsFile();
        questionsAsked = new ArrayList<Integer>();
        hMap = new HashMap<Integer, Questions>();
    }

    /**
     * This sets the quiz question and calls the method to set the view of the frame
     */
    public void playGame(JTextField currentQuestionTextField, JLabel currentPoints, JRadioButton optionA, JRadioButton optionB, JRadioButton optionC, JRadioButton optionD) {
        //store the quiz questions in the hash map
        quiz.setQuizQuestions(hMap);
        try{
            // shows questions at random as the user plays the game
           displayQuestionAtRandom(hMap,currentQuestionTextField, optionA, optionB, optionC, optionD);
        }catch (NullPointerException ex){
            JOptionPane.showMessageDialog(null, "Unable to get a questions");
        }
    }

    /*
    * This methods display a question at random for the player
    */
    public void displayQuestionAtRandom(Map<Integer, Questions> hMap, JTextField currentQuestionTextField, JRadioButton optionA, JRadioButton optionB, JRadioButton optionC, JRadioButton optionD) {
        do {
            try {
                Random generator = new Random();
                this.setCurrentQuestionNumber(generator.nextInt(hMap.size()));
            }catch (IllegalArgumentException ex){
                 JOptionPane.showMessageDialog(null, "Unable to generate a valid number");
            }
            //loops to ensure a questions is not repeated
        } while (questionsAsked.contains(this.getCurrentQuestionNumber()) && this.getCurrentQuestionNumber() > 0);

        //setting the question in the view
        currentQuestionTextField.setText(hMap.get(this.getCurrentQuestionNumber()).getQuestion());
        String[] op = hMap.get(this.getCurrentQuestionNumber()).getOptions();
        //setting the options in the view
        for (int i = 0; i <= 3 ; i++){
            if (i == 0){
               
                optionA.setText(op[0]);
            }
            if (i == 1){
               
                optionB.setText(op[1]);
            }
            if (i == 2){
                
                optionC.setText(op[2]);
            }
            if (i == 3){
                
                optionD.setText(op[3]);
            }
        }
        //adding the question to the already asked questions list to ensure it won't be repeated
        questionsAsked.add(this.getCurrentQuestionNumber());
    }
    
    //returns the answer of the current ques via using the current question number
    public String getAnswer(){
        return hMap.get(this.getCurrentQuestionNumber()).getAnswer();
    }
   
    //returns the hashmap of quiz questions
    public Map<Integer, Questions> getHashMap(){
        return this.hMap;
    }
    
    //get/sets for variables
    public void setCurrentQuestionNumber(int num){
        this.currentQuestionNumber = num;
    }
    
    public int getCurrentQuestionNumber(){
        return this.currentQuestionNumber;
    }
    
    public void setHashMap(Map<Integer, Questions> hashMap){
        this.hMap.putAll(hashMap);
    }
    
}
