package com.github.cc3002.finalreality.model.character;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import com.github.doragonUni.finalreality.model.character.Enemy;

import java.util.EnumMap;
import java.util.Map;
import java.util.concurrent.BlockingQueue;

import com.github.doragonUni.finalreality.model.character.ICharacter;
import com.github.doragonUni.finalreality.model.character.player.BlackMage;
import com.github.doragonUni.finalreality.model.character.player.WhiteMage;
import com.github.doragonUni.finalreality.model.weapon.Knife;
import com.github.doragonUni.finalreality.model.weapon.Staff;
import com.github.doragonUni.finalreality.model.weapon.Sword;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class WhiteMageTest {

    protected BlockingQueue<ICharacter> turns;
    private static final String name = "whiteMage";
    private static int fakeName = 0;
    private int hp = 760;
    private int def = 100;
    private int mana = 1000;
    private static String fakeMana = "10";
    protected Staff staff = new Staff("staff", 10,5,10);
    protected Staff staff1 = new Staff("staff", 10,5,10);
    protected Sword sword = new Sword("sword", 10, 5);

    private WhiteMage testWhiteMage;
    private WhiteMage testWhiteMage1;
    private WhiteMage testWhiteMage2;
    private WhiteMage testWhiteMage3;
    private WhiteMage testWhiteMage4;
    private BlackMage fakeWhiteMage;
    private Enemy testEnemy;

    /**
     * SETUP FOR TESTING
     */
    @BeforeEach
    void setUp(){
        testEnemy = new Enemy("Bigboss", turns, 10, 100, 50, 10000000);
        testWhiteMage = new WhiteMage(name, turns,hp, def, mana);
        testWhiteMage1 = new WhiteMage("kadabra", turns,hp, def, mana);
        testWhiteMage2 = new WhiteMage(name, turns, 500000, def, mana);
        testWhiteMage3 = new WhiteMage(name, turns, hp, 20, mana);
        testWhiteMage4 = new WhiteMage(name, turns,hp, def, 50);
        fakeWhiteMage = new BlackMage("traitor",turns,hp, def , mana);
    }
    /**
     * CONSTRUCTOR TEST
     */
    @Test
    void constructorTest(){
        var expectedWhiteMage = new WhiteMage(name, turns,hp, def, mana);
        assertEquals(expectedWhiteMage, testWhiteMage);
        assertEquals(expectedWhiteMage.hashCode(), testWhiteMage.hashCode());
        assertNotEquals(testWhiteMage.hashCode(), fakeWhiteMage.hashCode());
        assertEquals(testWhiteMage, testWhiteMage);
        assertNotEquals(testWhiteMage, fakeWhiteMage);

        //BRANCHES
        assertNotEquals(expectedWhiteMage, testWhiteMage1);
        assertNotEquals(expectedWhiteMage, testWhiteMage2);
        assertNotEquals(expectedWhiteMage, testWhiteMage3);
        assertNotEquals(expectedWhiteMage, testWhiteMage4);

    }
    /**
     * TEST FOR THE GETTERS
     */
    @Test
    void getTest(){
        assertEquals(name, testWhiteMage.getName());
        assertEquals(mana, testWhiteMage.getMana());
        assertEquals(hp, testWhiteMage.getHp());
        assertEquals(def, testWhiteMage.getDef());
    }
    /**
     * TEST FOR EQUIP WEAPONS
     */
    @Test
    void equipTest(){
        assertNull(testWhiteMage.getEquippedWeapon());
        testWhiteMage.equipWeapon(sword);
        assertNull(testWhiteMage.getEquippedWeapon());
        testWhiteMage.equipWeapon(staff);
        assertEquals(staff, testWhiteMage.getEquippedWeapon());

        testEnemy.attack(testWhiteMage);
        assertEquals(false, testWhiteMage.isAlive());
        testWhiteMage.equipWeapon(staff1);
        assertEquals(staff1, testWhiteMage.getEquippedWeapon());
    }

}
