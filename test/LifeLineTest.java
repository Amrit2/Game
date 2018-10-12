/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import gameproject.LifeLine;
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
public class LifeLineTest {
    LifeLine lifeline ;
    
    public LifeLineTest() {
        lifeline = new LifeLine();
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

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
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
    
    
    public static void main (String[] args){
        LifeLineTest test = new LifeLineTest();
        test.setFiftyFiftyOptionTestForA();
        test.setFiftyFiftyOptionTestForB();
        test.setFiftyFiftyOptionTestForC();
    }
}
