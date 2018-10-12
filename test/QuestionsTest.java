/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import gameproject.Questions;
import junit.framework.Assert;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Amrit
 */
public class QuestionsTest {
    Questions ques ;
    
    public QuestionsTest() {
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

    
    @Test
    public void setQuestionTest() {
        ques.setQuestion("Test Question");
        String expected = ques.getQuestion();
        String actual = "Test Question";
        
        assertEquals(expected, actual);
        
    }
    
    @Test
    public void setAnswerTest() {
        ques.setAnswer("A");
        String expected = ques.getAnswer();
        String actual = "A";
        
        assertEquals(expected, actual);
        
    }
    
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
        QuestionsTest test = new QuestionsTest();
        test.setQuestionTest();
        test.setAnswerTest();
    }
}
