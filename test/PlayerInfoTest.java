/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

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
public class PlayerInfoTest {

    PlayerInfo player;

    public PlayerInfoTest() {
        player = new PlayerInfo("", 0);
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
    public void setNameTest() {
        player.setName("Test Name");
        String actual = player.getName();
        String expected = "Test Name";

        assertEquals(expected, actual);
    }
    
     @Test
    public void setMoneyTest() {
        player.setMoney(2000);
        int actual = player.getMoney();
        int expected = 2000;

        assertEquals(expected, actual);
    }
}
