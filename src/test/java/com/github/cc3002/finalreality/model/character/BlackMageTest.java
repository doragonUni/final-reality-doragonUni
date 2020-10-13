package com.github.cc3002.finalreality.model.character;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;




import java.util.concurrent.BlockingQueue;

import com.github.doragonUni.finalreality.model.character.ICharacter;
import com.github.doragonUni.finalreality.model.character.player.BlackMage;


import com.github.doragonUni.finalreality.model.character.player.Engineer;
import com.github.doragonUni.finalreality.model.weapon.Knife;
import com.github.doragonUni.finalreality.model.weapon.Staff;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BlackMageTest {

    protected BlockingQueue<ICharacter> turns;
    private static final String name = "blackMage";
    private int mana = 10;
    private int hp = 300;
    private int def = 70;

    protected Staff staff = new Staff("staff", 10,5,10);
    protected Knife knife = new Knife( "knife",10, 5);

    private BlackMage testBlackMage;
    private BlackMage testBlackMage5;
    private BlackMage testBlackMage2;
    private BlackMage testBlackMage3;
    private BlackMage testBlackMage4;
    private Engineer testEngineer;
    private static String fakeBM;

    /**
     * SETUP FOR TESTING
     */
    @BeforeEach
    void setUp(){
        testBlackMage = new BlackMage(name, turns, hp, def, mana);
        testBlackMage2 = new BlackMage("blacc", turns, hp, def, mana);
        testBlackMage3 = new BlackMage(name, turns, 30, def, mana);
        testBlackMage4 = new BlackMage(name, turns, hp, 3, mana);
        testBlackMage5 = new BlackMage(name, turns, hp, def, 5040);

        testEngineer = new Engineer("Engineer", turns, hp, def);
        fakeBM = "boosted";
    }


    /**
     * TEST FOR THE CONSTRUCTOR
     */
    @Test
    void constructorTest(){
        var expectedBlackMage = new BlackMage(name, turns, hp, def, mana);
        assertEquals(expectedBlackMage, testBlackMage);
        assertEquals(expectedBlackMage.hashCode(), testBlackMage.hashCode());
        assertNotEquals(testBlackMage.hashCode(), testEngineer.hashCode());
        assertNotEquals(expectedBlackMage.hashCode(), testEngineer.hashCode());


        assertEquals(testBlackMage, testBlackMage);
        assertNotEquals(testBlackMage, fakeBM);


        //covering more branches
        assertNotEquals(expectedBlackMage, testBlackMage2);
        assertNotEquals(expectedBlackMage, testBlackMage3);
        assertNotEquals(expectedBlackMage, testBlackMage4);
        assertNotEquals(expectedBlackMage, testBlackMage5);

    }

    /**
     * TEST FOR THE GETTERS
     */
    @Test
    void getTests(){
        assertEquals(name, testBlackMage.getName());
        assertEquals(mana, testBlackMage.getMana());
        assertEquals(hp, testBlackMage.getHp());
        assertEquals(def, testBlackMage.getDef());

    }


    /**
     * TEST FOR EQUIPPING WEAPONS
     */
    @Test
    void equipTests(){
        assertNull(testBlackMage.getEquippedWeapon());
        testBlackMage.equipKnife(knife);
        assertEquals(knife, testBlackMage.getEquippedWeapon());
        testBlackMage.equipStaff(staff);
        assertEquals(staff, testBlackMage.getEquippedWeapon());
    }


}
