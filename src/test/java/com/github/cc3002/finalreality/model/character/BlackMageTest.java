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
    protected Staff staff = new Staff("staff", 10,5,10);
    protected Knife knife = new Knife( "knife",10, 5);

    private BlackMage testBlackMage;
    private BlackMage testBlackMage1;
    private Engineer testEngineer;


    @BeforeEach
    void setUp(){
        testBlackMage = new BlackMage(name, turns, mana);
        testBlackMage1 = new BlackMage("blackmage1", turns, 20);
        testEngineer = new Engineer("Engineer", turns);
    }

    @Test
    void constructorTest(){
        var expectedBlackMage = new BlackMage(name, turns, mana);
        assertEquals(expectedBlackMage, testBlackMage);
        assertEquals(expectedBlackMage.hashCode(), testBlackMage.hashCode());
        assertNull(testBlackMage.getEquippedWeapon());

        testBlackMage.equipKnife(knife);
        assertEquals(knife, testBlackMage.getEquippedWeapon());
        testBlackMage.equipStaff(staff);
        assertEquals(staff, testBlackMage.getEquippedWeapon());

        assertEquals(name, testBlackMage.getName());
        assertEquals(mana, testBlackMage.getMana());

        assertNotEquals(expectedBlackMage, testBlackMage1);
        assertNotEquals(expectedBlackMage.hashCode(), testEngineer.hashCode());


    }


}
