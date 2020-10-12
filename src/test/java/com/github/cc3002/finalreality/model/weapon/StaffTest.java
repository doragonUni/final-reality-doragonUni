package com.github.cc3002.finalreality.model.weapon;

import com.github.doragonUni.finalreality.model.weapon.Knife;
import com.github.doragonUni.finalreality.model.weapon.Staff;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StaffTest {

    private static final String STAFF_TEST = "Test staff";

    private static final int DAMAGE = 15;
    private static final int SPEED = 10; //weight
    private static final int MAGIC_DAMAGE = 20;


    private Staff testStaff;

    @BeforeEach
    void setUp(){
        testStaff = new Staff(STAFF_TEST, DAMAGE, SPEED, MAGIC_DAMAGE);
    }

    @Test
    void constructorTest(){
        var expectedStaff = new Staff(STAFF_TEST, DAMAGE, SPEED, MAGIC_DAMAGE);
        assertEquals(expectedStaff, testStaff);
        assertEquals(expectedStaff.hashCode(), testStaff.hashCode());
        assertEquals(STAFF_TEST, testStaff.getName());
        assertEquals(DAMAGE, testStaff.getDamage());
        assertEquals(SPEED, testStaff.getWeight());

    }


}
