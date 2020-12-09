package com.github.cc3002.finalreality.model.character;


import java.util.concurrent.BlockingQueue;

import com.github.doragonUni.finalreality.model.character.Enemy;
import com.github.doragonUni.finalreality.model.character.ICharacter;
import com.github.doragonUni.finalreality.model.character.player.BlackMage;


import com.github.doragonUni.finalreality.model.character.player.Engineer;
import com.github.doragonUni.finalreality.model.weapon.Knife;
import com.github.doragonUni.finalreality.model.weapon.Staff;

import com.github.doragonUni.finalreality.model.weapon.Sword;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BlackMageTest {

    protected BlockingQueue<ICharacter> turns;
    private static final String name = "blackMage";
    private int mana = 10;
    private int hp = 300;
    private int def = 70;

    protected Staff staff = new Staff("staff", 90,5,10);
    protected Knife knife = new Knife( "knife",90, 5);
    protected Sword sword = new Sword("katana", 100000, 1000000);

    private BlackMage testBlackMage;
    private BlackMage testBlackMage5;
    private BlackMage testBlackMage2;
    private BlackMage testBlackMage3;
    private BlackMage testBlackMage4;
    private Engineer testEngineer;
    private static String fakeBM;
    private Enemy testEnemy;
    private Enemy testEnemy2;

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

        testEnemy = new Enemy("Bigboss", turns, 10, 100, 50, 10000000);
        testEnemy2 = new Enemy("Bigboss", turns, 10, 100, 50, 50);

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

        testBlackMage.equipWeapon(sword);
        assertNull(testBlackMage.getEquippedWeapon());

        testBlackMage.equipWeapon(knife);
        assertEquals(knife, testBlackMage.getEquippedWeapon());

        testBlackMage.equipWeapon(staff);
        assertEquals(staff, testBlackMage.getEquippedWeapon());

        testBlackMage.equipWeapon(sword);
        assertNotNull(testBlackMage.getEquippedWeapon());
        assertEquals(staff, testBlackMage.getEquippedWeapon());

    }

    @Test
    void attackTest(){
        assertEquals(true, testBlackMage.isAlive());
        assertEquals(0, testBlackMage.getAttack());
        testBlackMage.attack(testEnemy);
        assertEquals(100, testEnemy.getHp());
        testBlackMage.equipWeapon(knife);
        assertNotEquals(0, testBlackMage.getAttack());
        assertEquals(90, testBlackMage.getAttack());
        testBlackMage.attack(testEnemy);
        assertEquals(true, testEnemy.isAlive());
        assertEquals(100-(90-testEnemy.getDef()), testEnemy.getHp());
        testEnemy.attack(testBlackMage);
        assertFalse(testBlackMage.isAlive());
        assertTrue(testEnemy.isAlive());
        testBlackMage.equipWeapon(staff);
        assertEquals(knife, testBlackMage.getEquippedWeapon());


        testEnemy2.attack(testBlackMage2);
        assertEquals(hp, testBlackMage2.getHp());

    }






}
