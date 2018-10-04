package gameproject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JTextPane;

/**
 * This class handles the game play
 *
 * @author Amritpal Kaur 14865526
 */
public class GamePlay {

    //declarations
    Scanner keyboard;
    Lifelines lifeline;
    ReadQuestionsFile file;
    CheckAnswer checkAnswer;
    Map<Integer, Questions> hMap;
    int currentQuestionNumber;
    int chosenQuestionNumber = 0;
    List questionsAsked;
    /**
     * The constructor instantiates the PlayerInfo, Lifelines,
     * ReadQuestionsFile, Check Answer, LeaderBoard and Questions class
     *
     * @param name of the player
     */
    public GamePlay() {
        this.lifeline = new Lifelines();                               // instantiate the lifeline class

        file = new ReadQuestionsFile();
        this.checkAnswer = new CheckAnswer();
        questionsAsked = new ArrayList<Integer>();
        hMap = new HashMap<Integer, Questions>();
    }

    /**
     * This class shows the questions and handles player input for processing
     */
    public void playGame(JTextField currentQuestionTextField, JTextPane currentPointsTextPane, JRadioButton optionA, JRadioButton optionB, JRadioButton optionC, JRadioButton optionD) {
        file.setQuizQuestions(hMap);
        try{
           setQuestionAtRandom(hMap,currentQuestionTextField, optionA, optionB, optionC, optionD);
        }catch (NullPointerException ex){
            JOptionPane.showMessageDialog(null, "Unable to get a questions");
        }
      
                    // displays the lifeline options and process the use of the lifeline used
//         lifeline.useLifeLine(player, database, hMap, currentQuestionNumber);

    }

    public int setQuestionAtRandom(Map<Integer, Questions> hMap, JTextField currentQuestionTextField, JRadioButton optionA, JRadioButton optionB, JRadioButton optionC, JRadioButton optionD) {
        
        do {
            try {
                Random generator = new Random();
                chosenQuestionNumber = generator.nextInt(hMap.size());
            }catch (IllegalArgumentException ex){
                 JOptionPane.showMessageDialog(null, "Unable to generate a valid number");
            }
            
        } while (questionsAsked.contains(chosenQuestionNumber) && chosenQuestionNumber > 0);

        currentQuestionTextField.setText(hMap.get(chosenQuestionNumber).getQuestion());
        String[] op = hMap.get(chosenQuestionNumber).getOptions();
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
        questionsAsked.add(chosenQuestionNumber);
        return chosenQuestionNumber;
    }
    
    public String getAnswer(){
        return hMap.get(chosenQuestionNumber).getAnswer();
    }
   
    public int getCurrentQuestionNumber(){
        return this.currentQuestionNumber;
    }
    
    public Map<Integer, Questions> getHashMap(){
        return this.hMap;
    }
}
