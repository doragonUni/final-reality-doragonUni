package com.github.cc3002.finalreality.model.character;

import com.github.doragonUni.finalreality.model.character.ICharacter;
import com.github.doragonUni.finalreality.model.character.player.Knight;
import com.github.doragonUni.finalreality.model.character.player.Thief;
import com.github.doragonUni.finalreality.model.weapon.Axe;
import com.github.doragonUni.finalreality.model.weapon.Bow;
import com.github.doragonUni.finalreality.model.weapon.Knife;
import com.github.doragonUni.finalreality.model.weapon.Sword;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.concurrent.BlockingQueue;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class ThiefTest {


    protected BlockingQueue<ICharacter> turns;
    private static final String name = "Thief";
    private int hp = 670;
    private int def = 100;

    protected Sword sword = new Sword("sword", 5, 50 );
    protected Bow bow = new Bow("bow", 10 , 5 );
    protected Knife knife = new Knife( "knife",15, 15);
    protected Axe axe = new Axe("axe", 10, 10);

    private Thief testThief;
    private Thief testThief1;
    private Thief testThief2;
    private Thief testThief3;
    private Knight fakeThief;
    /**
     * SETUP FOR TESTING
     */
    @BeforeEach
    void setUp(){
        testThief = new Thief(name, turns, hp, def);
        testThief1 = new Thief("T1", turns, hp, def);
        testThief2 = new Thief(name, turns, 1003, def);
        testThief3 = new Thief(name, turns, hp, 10000000);
        fakeThief = new Knight("dishonor", turns, hp, def);
    }
    /**
     * Constructor TEST
     */
    @Test
    void constructorTest(){
        var expectedThief = new Thief(name, turns, hp, def);
        assertEquals(expectedThief, testThief);
        assertEquals(expectedThief.hashCode(), testThief.hashCode());
        assertNotEquals(testThief.hashCode(), fakeThief.hashCode());
        assertEquals(testThief, testThief);
        assertNotEquals(testThief, fakeThief);

        //branches

        assertNotEquals(expectedThief, testThief1);
        assertNotEquals(expectedThief, testThief2);
        assertNotEquals(expectedThief, testThief3);


    }
    /**
     * TEST FOR THE GETTERS
     */
    @Test
    void getTest(){
        assertEquals(name, testThief.getName());
        assertEquals(hp, testThief.getHp());
        assertEquals(def, testThief.getDef());
    }

    /**
     * TEST FOR EQUIPPING WEAPONS
     */
    @Test
    void equipTest(){
        assertNull(testThief.getEquippedWeapon());
        testThief.equipWeapon(axe);
        assertNull(testThief.getEquippedWeapon());
        testThief.equipWeapon(bow);
        assertEquals(bow, testThief.getEquippedWeapon());
        testThief.equipWeapon(knife);
        assertEquals(knife, testThief.getEquippedWeapon());
        testThief.equipWeapon(sword);
        assertEquals(sword, testThief.getEquippedWeapon());
        testThief.equipWeapon(axe);
        assertNotNull(testThief.getEquippedWeapon());

    }


}
