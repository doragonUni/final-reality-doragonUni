package com.github.cc3002.finalreality.model.weapon;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import com.github.doragonUni.finalreality.model.weapon.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SwordTest {

    private static final String SWORD_NAME = "Test Sword";

    private static final int DAMAGE = 15;
    private static final int SPEED = 10;

    private Sword testSword;
    private Sword testSword2;
    private Sword testSword3;
    private Sword testSword4;

    private Bow testBow;
    private static String fakeSword;

    /**
     * TESTING SETUP
     */

    @BeforeEach
    void setUp(){
        testSword = new Sword(SWORD_NAME, DAMAGE, SPEED);
        testSword2 = new Sword("excalibur", DAMAGE, SPEED);
        testSword3 = new Sword(SWORD_NAME, 2, SPEED);
        testSword4 = new Sword(SWORD_NAME, DAMAGE, 9);
        testBow = new Bow("archer'sBow", 10, 20);
        fakeSword = "get scammed nerd";
    }

    /**
     * CONSTRUCTOR TESTS
     */
    @Test
    void constructorTest(){
        var expectedSword = new Sword(SWORD_NAME, DAMAGE, SPEED);

        assertEquals(expectedSword, testSword);
        assertEquals(expectedSword.hashCode(), testSword.hashCode());
        assertNotEquals(testSword.hashCode(), testBow.hashCode());
        assertEquals(testSword, testSword);
        assertNotEquals(testSword, fakeSword);


        //For branches
        assertNotEquals(expectedSword, testSword2);
        assertNotEquals(expectedSword, testSword3);
        assertNotEquals(expectedSword, testSword4);

    }

    /**
     * TEST FOR GETTERS
     */
    @Test
    void getTest(){

        assertNotEquals(testSword, testSword.getName());
        assertNotEquals(testSword.getDamage(), testBow.getName());
        assertNotEquals(testSword.getWeight(), testBow.getName());
        assertEquals(SWORD_NAME, testSword.getName());
        assertEquals(DAMAGE, testSword.getDamage());
        assertEquals(SPEED, testSword.getWeight());
    }

}
