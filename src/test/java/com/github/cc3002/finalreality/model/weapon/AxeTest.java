package com.github.cc3002.finalreality.model.weapon;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;


import com.github.doragonUni.finalreality.model.weapon.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AxeTest {

    private static final String AXE_NAME = "Test Axe";
    private static final String BOW_NAME = "Test Bow";

    private static final int DAMAGE = 15;
    private static final int SPEED = 10;
    private static final int DAMAGE1 = 20;
    private static final int SPEED1 = 15;

    private Axe testAxe;
    private Bow testBow;
    private static Bow FakeAxe;
    private Axe axeName;
    private Axe axeDmg;
    private Axe axeSpd;



    /**
     * SETUP FOR THE TEST
     */
    @BeforeEach
    void setUp(){
        testAxe = new Axe(AXE_NAME, DAMAGE, SPEED);

        axeName = new Axe("axe1", DAMAGE, SPEED);
        axeDmg = new Axe(AXE_NAME, 4, SPEED);
        axeSpd = new Axe(AXE_NAME, DAMAGE, 1);

        testBow = new Bow(BOW_NAME, DAMAGE1, SPEED1);
        FakeAxe = new Bow(BOW_NAME, DAMAGE, SPEED);

    }
    /**
     * Constructor test
     */
    @Test
    void constructorTest(){
        var expectedAxe = new Axe(AXE_NAME, DAMAGE, SPEED);
        assertEquals(expectedAxe, testAxe);
        assertEquals(expectedAxe.hashCode(), testAxe.hashCode());
        assertNotEquals(expectedAxe.hashCode(), testBow.hashCode());
        assertEquals(testAxe, testAxe);
        assertNotEquals(testAxe, FakeAxe);

        //testing for branches:
        assertNotEquals(expectedAxe, axeDmg);
        assertNotEquals(expectedAxe, axeName);
        assertNotEquals(expectedAxe, axeSpd);

    }
    /**
     * TEST FOR THE GETTERS
     */
    @Test
    void getTest(){
        assertEquals(AXE_NAME, testAxe.getName());
        assertEquals(DAMAGE, testAxe.getDamage());
        assertEquals(SPEED, testAxe.getWeight());
    }


}
