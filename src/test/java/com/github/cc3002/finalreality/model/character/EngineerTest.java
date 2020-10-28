package com.github.cc3002.finalreality.model.character;

import com.github.doragonUni.finalreality.model.character.Enemy;

import java.util.EnumMap;
import java.util.Map;
import java.util.concurrent.BlockingQueue;

import com.github.doragonUni.finalreality.model.character.ICharacter;
import com.github.doragonUni.finalreality.model.character.player.Engineer;
import com.github.doragonUni.finalreality.model.character.player.WhiteMage;
import com.github.doragonUni.finalreality.model.weapon.Axe;
import com.github.doragonUni.finalreality.model.weapon.Bow;
import com.github.doragonUni.finalreality.model.weapon.Sword;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class EngineerTest {

    protected BlockingQueue<ICharacter> turns;
    private static final String name = "Engineer";
    private int hp = 700;
    private int def = 300;
    protected Bow bow = new Bow("bow", 10, 5 );
    protected Axe axe = new Axe("axe", 10 , 5 );
    protected Sword sword = new Sword("sword",10, 1000);

    private Engineer testEngineer;
    private Engineer testEngineer1;
    private Engineer testEngineer2;
    private Engineer testEngineer3;
    private WhiteMage fakeEngineer;

    /**
     * SETUP FOR TESTING
     */

    @BeforeEach
    void setUp(){
        testEngineer = new Engineer(name, turns, hp, def);
        testEngineer1 = new Engineer("engine", turns, hp, def);
        testEngineer2 = new Engineer(name, turns, 500, def);
        testEngineer3 = new Engineer(name, turns, hp, 150);
        fakeEngineer = new WhiteMage("what?", turns, 10, 400, 100);
    }
    /**
     * TEST FOR THE CONSTRUCTOR
     */
    @Test
    void constructorTest(){
        var expectedEngineer = new Engineer(name, turns, hp, def);
        assertEquals(expectedEngineer, testEngineer);
        assertEquals(expectedEngineer.hashCode(), testEngineer.hashCode());
        assertNotEquals(testEngineer.hashCode(), fakeEngineer.hashCode());
        assertEquals(testEngineer, testEngineer);
        assertNotEquals(testEngineer, fakeEngineer);


        //for Branches
        assertNotEquals(expectedEngineer, testEngineer1);
        assertNotEquals(expectedEngineer, testEngineer2);
        assertNotEquals(expectedEngineer, testEngineer3);

    }

    /**
     * TEST FOR THE GETTERS
     */
    @Test
    void getTests(){
        assertEquals(name, testEngineer.getName());
        assertEquals(hp, testEngineer.getHp());
        assertEquals(def, testEngineer.getDef());
    }
    /**
     * TEST FOR EQUIPPING WEAPONS
     */
    @Test
    void equipTest(){
        assertNull(testEngineer.getEquippedWeapon());
        testEngineer.equipWeapon(sword);
        assertNull(testEngineer.getEquippedWeapon());
        testEngineer.equipWeapon(axe);
        assertEquals(axe, testEngineer.getEquippedWeapon());
        testEngineer.equipWeapon(bow);
        assertEquals(bow, testEngineer.getEquippedWeapon());
    }


}
