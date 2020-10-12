package com.github.cc3002.finalreality.model.weapon;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import com.github.doragonUni.finalreality.model.weapon.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;



public class KnifeTest {

    private static final String KNIFE_TEST = "Test Knife";

    private static final int DAMAGE = 15;
    private static final int WEIGHT = 10; //weight

    private Knife testKnife;
    private Axe testAxe;

    @BeforeEach
    void setUp(){
        testKnife = new Knife(KNIFE_TEST, DAMAGE, WEIGHT);
        testAxe = new Axe(KNIFE_TEST, DAMAGE, WEIGHT);
    }

    @Test
    void constructorTest(){
        var expectedKnife = new Knife(KNIFE_TEST, DAMAGE, WEIGHT);

        assertEquals(expectedKnife, testKnife);
        assertEquals(expectedKnife.hashCode(), testKnife.hashCode());
        assertNotEquals(testKnife.hashCode(), testAxe.hashCode());

        assertEquals(KNIFE_TEST, testKnife.getName());
        assertEquals(DAMAGE, testKnife.getDamage());
        assertEquals(WEIGHT, testKnife.getWeight());

    }
}
