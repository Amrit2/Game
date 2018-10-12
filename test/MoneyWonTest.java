/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import gameproject.MoneyWon;
import gameproject.PlayerInfo;
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
public class MoneyWonTest {
    PlayerInfo player;
    MoneyWon money;
    
    public MoneyWonTest() {
        player = new PlayerInfo("Me", 100);
        money = new MoneyWon();
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
    public void setMoneyWonTestCorrect() {
        money.setMoneyWon(true, player);
        int actual = player.getMoney();
        int expected = 200;
        
        assertEquals(expected,actual);
    }
    
    @Test
    public void setMoneyWonTestWrong() {
        money.setMoneyWon(false, player);
        int actual = player.getMoney();
        int expected = 0;
        
        assertEquals(expected,actual);
    }
    
    @Test
    public void answerNotWrongAtThreshholdtest() {
        player.setMoney(500);
        boolean actual = money.answerWrongAtThreshhold(player);
        boolean expected = false;
        
        assertEquals(expected,actual);
    }
    
     @Test
    public void answerWrongAtThreshholdtest() {
        player.setMoney(1000);
        boolean actual = money.answerWrongAtThreshhold(player);
        boolean expected = false;
        
        assertEquals(expected,actual);
    }
}
