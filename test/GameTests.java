/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import gameproject.GamePlayController;
import gameproject.LifeLine;
import gameproject.MoneyWon;
import gameproject.PlayerInfo;
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
public class GameTests {
    private Map<Integer, Questions> hMap;
    private final ReadQuestionsFile file;
    GamePlayController gameplay;
    LifeLine lifeline ;
    PlayerInfo player;
    MoneyWon money;
    Questions ques ;
    
    public GameTests() {
        file = new ReadQuestionsFile();
        hMap = new HashMap<Integer, Questions>();
        gameplay = new GamePlayController();
        
        lifeline = new LifeLine();
        player = new PlayerInfo("Me", 100);
        money = new MoneyWon();
        ques = new Questions("", null,"");
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
    
    /**
     * Test for checking if correct answer is returned
     */
    @Test
    public void getAnswerTest() {
        file.setQuizQuestions(hMap);
        gameplay.setHashMap(hMap);
        gameplay.setCurrentQuestionNumber(2);
        String actualAnswer = gameplay.getAnswer();
        String expectedAnswer = "B";
        
        Assert.assertEquals(expectedAnswer, actualAnswer);
    }
     
    /**
     * Test for checking correct question number is returned
     */
    @Test
    public void currentQuestionNumberTest(){
        gameplay.setCurrentQuestionNumber(1);
        int expectedNumber = 1;
        int actualNumber = gameplay.getCurrentQuestionNumber();
        
        Assert.assertEquals(expectedNumber, actualNumber);
    }
    
    /**
     * Test for checking if options' state is set correctly
     */
    @Test
    public void setFiftyFiftyOptionTestForA() {
       lifeline.setFiftyFiftyOptions("A", "B", "C", "D", "A");
       boolean expected = true;
       boolean actual = lifeline.getStateA();
       
       assertEquals(expected, actual);
       
    }
    
    @Test
    public void setFiftyFiftyOptionTestForB() {
       lifeline.setFiftyFiftyOptions("A", "B", "C", "D", "A");
       boolean expected = true;
       boolean actual = lifeline.getStateB();
       
       assertEquals(expected, actual);
       
    }
    
    
    @Test
    public void setFiftyFiftyOptionTestForC() {
       lifeline.setFiftyFiftyOptions("A", "B", "C", "D", "A");
       boolean expected = false;
       boolean actual = lifeline.getStateC();
       
       assertEquals(expected, actual);
       
    }
     
    /**
     * Test for checking correct money is set
     */
    @Test
    public void setMoneyWonTestCorrect() {
        money.setMoneyWon(true, player);
        int actual = player.getMoney();
        int expected = 200;
        
        assertEquals(expected,actual);
    }
    
    /**
     * Test for checking if wrong answer at threshold is detected
     */
    
    @Test
    public void answerWrongAtThreshholdtest() {
        player.setMoney(1000);
        boolean actual = money.answerWrongAtThreshhold(player);
        boolean expected = false;
        
        assertEquals(expected,actual);
    }
    
    /**
     * Test for checking if name is set properly
     */
    @Test
    public void setNameTest() {
        player.setName("Test Name");
        String actual = player.getName();
        String expected = "Test Name";

        assertEquals(expected, actual);
    }
    
    /**
     * Test for checking if money is set properly
     */
    @Test
    public void setMoneyTest() {
        player.setMoney(2000);
        int actual = player.getMoney();
        int expected = 2000;

        assertEquals(expected, actual);
    }
    
    /**
     * Test for checking if question is set properly
     */
    @Test
    public void setQuestionTest() {
        ques.setQuestion("Test Question");
        String expected = ques.getQuestion();
        String actual = "Test Question";
        
        assertEquals(expected, actual);
        
    }
    
    /**
     * Test for checking if answer is set properly
     */
    @Test
    public void setAnswerTest() {
        ques.setAnswer("A");
        String expected = ques.getAnswer();
        String actual = "A";
        
        assertEquals(expected, actual);
        
    }
    
    /**
     * Test for checking if options are set properly
     */
    @Test
    public void setOptionsTest() {
        String[] o = new String[4];
        o[0] = "1";
        o[1] = "2";
        o[2] = "3";
        o[3] = "4";
        ques.setOptions(o);
        String[] expected = ques.getOptions();
        String[] actual = o;
        
        assertArrayEquals(expected, actual);
        
    }
   
     public static void main (String[] args){
        GameTests test = new GameTests();
        test.getAnswerTest();
        test.setFiftyFiftyOptionTestForA();
        test.setFiftyFiftyOptionTestForB();
        test.setFiftyFiftyOptionTestForC();
        test.setMoneyWonTestCorrect();
        test.answerWrongAtThreshholdtest();
        test.setNameTest();
        test.setMoneyTest();
        test.setQuestionTest();
        test.setAnswerTest();
    }
    
}
