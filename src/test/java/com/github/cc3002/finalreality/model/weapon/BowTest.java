package com.github.cc3002.finalreality.model.weapon;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import com.github.doragonUni.finalreality.model.weapon.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BowTest {

    private static final String BOW_NAME = "TestBow";
    private static final String BOW_NAME2 = "TestBow2";

    private static final int DAMAGE = 15;
    private static final int SPEED = 10;

    private Bow testBow;
    private Bow testBow2;

    @BeforeEach
    void setUp(){
        testBow = new Bow(BOW_NAME, DAMAGE, SPEED);
        testBow2 = new Bow(BOW_NAME2, 10, 15);
    }

    @Test
    void constructorTest(){
        var expectedBow = new Bow(BOW_NAME, DAMAGE, SPEED);
        assertEquals(expectedBow, testBow);
        assertEquals(expectedBow.hashCode(), testBow.hashCode());

        assertEquals(BOW_NAME, testBow.getName());
        assertEquals(DAMAGE, testBow.getDamage());
        assertEquals(SPEED, testBow.getWeight());

        assertNotEquals(expectedBow, testBow2);

    }

}
