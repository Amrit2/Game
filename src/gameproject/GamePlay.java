package gameproject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import javax.swing.JLabel;
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
    Lifelines lifeline;
    ReadQuestionsFile file;
    MoneyWon checkAnswer;
    Map<Integer, Questions> hMap;
    int currentQuestionNumber = 0;
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
        this.checkAnswer = new MoneyWon();
        questionsAsked = new ArrayList<Integer>();
        hMap = new HashMap<Integer, Questions>();
    }

    /**
     * This class shows the questions and handles player input for processing
     */
    public void playGame(JTextField currentQuestionTextField, JLabel currentPoints, JRadioButton optionA, JRadioButton optionB, JRadioButton optionC, JRadioButton optionD) {
        file.setQuizQuestions(hMap);
        try{
           setQuestionAtRandom(hMap,currentQuestionTextField, optionA, optionB, optionC, optionD);
        }catch (NullPointerException ex){
            JOptionPane.showMessageDialog(null, "Unable to get a questions");
        }

    }

    public int setQuestionAtRandom(Map<Integer, Questions> hMap, JTextField currentQuestionTextField, JRadioButton optionA, JRadioButton optionB, JRadioButton optionC, JRadioButton optionD) {
        
        do {
            try {
                Random generator = new Random();
                currentQuestionNumber = generator.nextInt(hMap.size());
            }catch (IllegalArgumentException ex){
                 JOptionPane.showMessageDialog(null, "Unable to generate a valid number");
            }
            
        } while (questionsAsked.contains(currentQuestionNumber) && currentQuestionNumber > 0);

        currentQuestionTextField.setText(hMap.get(currentQuestionNumber).getQuestion());
        String[] op = hMap.get(currentQuestionNumber).getOptions();
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
        questionsAsked.add(currentQuestionNumber);
        return currentQuestionNumber;
    }
    
    public String getAnswer(){
        return hMap.get(currentQuestionNumber).getAnswer();
    }
   
    public Map<Integer, Questions> getHashMap(){
        return this.hMap;
    }
}
