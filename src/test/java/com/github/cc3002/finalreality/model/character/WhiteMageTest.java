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
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class WhiteMageTest {

    protected BlockingQueue<ICharacter> turns;
    private static final String name = "whiteMage";
    private int mana = 10;
    protected Staff staff = new Staff("staff", 10,5,10);


    private WhiteMage testWhiteMage;

    @BeforeEach
    void setUp(){
        testWhiteMage = new WhiteMage(name, turns, mana);
    }

    @Test
    void constructorTest(){
        var expectedWhiteMage = new WhiteMage(name, turns, mana);
        assertEquals(expectedWhiteMage, testWhiteMage);

        assertEquals(expectedWhiteMage.hashCode(), testWhiteMage.hashCode());
        assertNull(testWhiteMage.getEquippedWeapon());
        testWhiteMage.equipStaff(staff);
        assertEquals(staff, testWhiteMage.getEquippedWeapon());

        assertEquals(name, testWhiteMage.getName());
        assertEquals(mana, testWhiteMage.getMana());

    }
}
