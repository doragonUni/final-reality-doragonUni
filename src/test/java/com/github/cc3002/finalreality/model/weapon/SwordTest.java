package com.github.cc3002.finalreality.model.weapon;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.github.doragonUni.finalreality.model.weapon.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SwordTest {

    private static final String SWORD_NAME = "Test Sword";

    private static final int DAMAGE = 15;
    private static final int SPEED = 10;

    private Sword testSword;

    @BeforeEach
    void setUp(){
        testSword = new Sword(SWORD_NAME, DAMAGE, SPEED);
    }

    @Test
    void constructorTest(){
        var expectedSword = new Sword(SWORD_NAME, DAMAGE, SPEED);

        assertEquals(expectedSword, testSword);
        assertEquals(expectedSword.hashCode(), testSword.hashCode());
        assertEquals(SWORD_NAME, testSword.getName());
        assertEquals(DAMAGE, testSword.getDamage());
        assertEquals(SPEED, testSword.getWeight());

    }
}
