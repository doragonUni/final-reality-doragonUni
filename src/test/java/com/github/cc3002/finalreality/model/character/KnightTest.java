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
import com.github.doragonUni.finalreality.model.character.player.Engineer;
import com.github.doragonUni.finalreality.model.character.player.Knight;
import com.github.doragonUni.finalreality.model.weapon.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class KnightTest {

    protected BlockingQueue<ICharacter> turns;
    private static final String name = "knight";
    private int hp = 300;
    private int def = 600;
    protected Sword sword = new Sword("sword", 10, 5 );
    protected Axe axe = new Axe("axe", 10 , 5 );
    protected Knife knife = new Knife( "knife",10, 5);
    protected Staff staff = new Staff("Staff", 10, 10, 10);

    private Knight testKnight;
    private Knight testKnight1;
    private Knight testKnight2;
    private Knight testKnight3;
    private BlackMage fakeKnight;
    private Enemy testEnemy;
    /**
     * SETUP FOR TESTING
     */
    @BeforeEach
    void setUp(){
        testEnemy = new Enemy("Bigboss", turns, 10, 100, 50, 10000000);
        testKnight = new Knight(name, turns, hp, def);
        testKnight1 = new Knight("Saber", turns, hp, def);
        testKnight2 = new Knight(name, turns, 400, def);
        testKnight3 = new Knight(name, turns, hp, 1000);

        fakeKnight = new BlackMage("what v2", turns, hp, def, 600);
    }
    /**
     * TEST FOR THE CONSTRUCTOR
     */
    @Test
    void constructorTest(){
        var expectedKnight = new Knight(name, turns, hp, def);
        assertEquals(expectedKnight, testKnight);
        assertEquals(expectedKnight.hashCode(), testKnight.hashCode());
        assertNotEquals(testKnight.hashCode(), fakeKnight.hashCode());
        assertEquals(testKnight, testKnight);
        assertNotEquals(testKnight, fakeKnight);

        assertNotEquals(expectedKnight, testKnight1);
        assertNotEquals(expectedKnight, testKnight2);
        assertNotEquals(expectedKnight, testKnight3);

    }
    /**
     * TEST FOR THE GETTERS
     */
    @Test
    void getTest(){
        assertEquals(name, testKnight.getName());
        assertEquals(hp, testKnight.getHp());
        assertEquals(def, testKnight.getDef());
    }
    /**
     * TEST FOR EQUIPPING SOME WEAPONS
     */
    @Test
    void equipTest(){
        assertNull(testKnight.getEquippedWeapon());
        testKnight.equipWeapon(staff);
        assertNull(testKnight.getEquippedWeapon());
        testKnight.equipWeapon(axe);
        assertEquals(axe, testKnight.getEquippedWeapon());
        testKnight.equipWeapon(sword);
        assertEquals(sword, testKnight.getEquippedWeapon());
        testKnight.equipWeapon(knife);
        assertEquals(knife, testKnight.getEquippedWeapon());


        testEnemy.attack(testKnight);
        assertEquals(false, testKnight.isAlive());
        testKnight.equipWeapon(sword);
        assertEquals(knife, testKnight.getEquippedWeapon());
    }


}
