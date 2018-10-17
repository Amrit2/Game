/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import gameproject.GamePlayController;
import gameproject.Questions;
import gameproject.ReadQuestionsFile;
import java.util.HashMap;
import java.util.Map;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Amrit
 */
public class ReadQuestionsFileControllerTest {
    private Map<Integer, Questions> hMap;
    private final ReadQuestionsFile file;
    
    public ReadQuestionsFileControllerTest() {
        file = new ReadQuestionsFile();
        hMap = new HashMap<Integer, Questions>();
    }
//    
//    @BeforeClass
//    public static void setUpClass() {
//    }
//    
//    @AfterClass
//    public static void tearDownClass() {
//    }
//    
    @Before
    public void setUp() {
//        file.setQuizQuestions(hMap); NOT WORKING
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
     @Test
    public void getAnswerTest() {
        GamePlayController gameplay = new GamePlayController();
        file.setQuizQuestions(hMap);
        gameplay.setHashMap(hMap);
        gameplay.setCurrentQuestionNumber(2);
        String actualAnswer = gameplay.getAnswer();
        String expectedAnswer = "B";
        
        Assert.assertEquals(expectedAnswer, actualAnswer);
    }
     
    public static void main (String[] args){
         ReadQuestionsFileControllerTest test = new ReadQuestionsFileControllerTest();
         test.getAnswerTest();
    }
}
