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
 * This class handles the game play
 *
 * @author Amritpal Kaur 14865526
 */
public class ReadQuestionsFileController {

    //declarations
    private final ReadQuestionsFile file;
    private Map<Integer, Questions> hMap;
    private int currentQuestionNumber = 0;
    private List questionsAsked;
    /**
     * The constructor instantiates the PlayerInfo, Lifelines,
     * ReadQuestionsFile, Check Answer, LeaderBoard and Questions class
     * @param name of the player
     */
    public ReadQuestionsFileController() {
        file = new ReadQuestionsFile();
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

    public void setQuestionAtRandom(Map<Integer, Questions> hMap, JTextField currentQuestionTextField, JRadioButton optionA, JRadioButton optionB, JRadioButton optionC, JRadioButton optionD) {
        do {
            try {
                Random generator = new Random();
                this.setCurrentQuestionNumber(generator.nextInt(hMap.size()));
            }catch (IllegalArgumentException ex){
                 JOptionPane.showMessageDialog(null, "Unable to generate a valid number");
            }
            
        } while (questionsAsked.contains(this.getCurrentQuestionNumber()) && this.getCurrentQuestionNumber() > 0);

        currentQuestionTextField.setText(hMap.get(this.getCurrentQuestionNumber()).getQuestion());
        String[] op = hMap.get(this.getCurrentQuestionNumber()).getOptions();
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
        questionsAsked.add(this.getCurrentQuestionNumber());
    }
    
    public String getAnswer(){
        return hMap.get(this.getCurrentQuestionNumber()).getAnswer();
    }
   
    public Map<Integer, Questions> getHashMap(){
        return this.hMap;
    }
    
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
