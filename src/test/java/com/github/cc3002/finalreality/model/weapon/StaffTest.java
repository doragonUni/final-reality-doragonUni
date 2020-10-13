package com.github.cc3002.finalreality.model.weapon;


import com.github.doragonUni.finalreality.model.weapon.Staff;
import com.github.doragonUni.finalreality.model.weapon.Sword;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class StaffTest {

    private static final String STAFF_TEST = "Test staff";

    private static final int DAMAGE = 15;
    private static final int SPEED = 10; //weight
    private static final int MAGIC_DAMAGE = 20;


    private Staff testStaff;
    private Staff testStaff2;
    private Staff testStaff3;
    private Staff testStaff4;
    private Staff testStaff5;
    private Sword testSword;

    private static int fakeStaff;

    @BeforeEach
    void setUp(){
        testStaff = new Staff(STAFF_TEST, DAMAGE, SPEED, MAGIC_DAMAGE);
        testStaff2 = new Staff("staffy", DAMAGE, SPEED, MAGIC_DAMAGE);
        testStaff3 = new Staff(STAFF_TEST, 3, SPEED, MAGIC_DAMAGE);
        testStaff4 = new Staff(STAFF_TEST, DAMAGE, 1, MAGIC_DAMAGE);
        testStaff5 = new Staff(STAFF_TEST, DAMAGE, SPEED, 4);
        testSword = new Sword("Excaliber", 10, 10);
        fakeStaff = 2020;

    }

    @Test
    void constructorTest(){
        var expectedStaff = new Staff(STAFF_TEST, DAMAGE, SPEED, MAGIC_DAMAGE);
        assertEquals(expectedStaff, testStaff);
        assertEquals(expectedStaff.hashCode(), testStaff.hashCode());
        assertNotEquals(testStaff.hashCode(), testSword.hashCode());
        assertEquals(testStaff, testStaff);
        assertFalse(testStaff.equals(fakeStaff));



        assertNotEquals(expectedStaff, testStaff2);
        assertNotEquals(expectedStaff, testStaff3);
        assertNotEquals(expectedStaff, testStaff4);
        assertNotEquals(expectedStaff, testStaff5);

    }
    /**
     * TEST FOR GETTERS
     */
    @Test
    void getTest(){
        assertEquals(STAFF_TEST, testStaff.getName());
        assertEquals(DAMAGE, testStaff.getDamage());
        assertEquals(SPEED, testStaff.getWeight());

    }


}
