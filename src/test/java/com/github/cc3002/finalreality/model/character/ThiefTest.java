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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class ThiefTest {


    protected BlockingQueue<ICharacter> turns;
    private static final String name = "Thief";
    protected Sword sword = new Sword("sword", 10, 5 );
    protected Bow bow = new Bow("bow", 10 , 5 );
    protected Knife knife = new Knife( "knife",10, 5);

    private Thief testThief;

    @BeforeEach
    void setUp(){
        testThief = new Thief(name, turns);
    }

    @Test
    void constructorTest(){
        var expectedEngineer = new Thief(name, turns);
        assertEquals(expectedEngineer, testThief);
        assertEquals(expectedEngineer.hashCode(), testThief.hashCode());
        assertNull(testThief.getEquippedWeapon());

        testThief.equipBow(bow);
        assertEquals(bow, testThief.getEquippedWeapon());
        testThief.equipKnife(knife);
        assertEquals(knife, testThief.getEquippedWeapon());
        testThief.equipSword(sword);
        assertEquals(sword, testThief.getEquippedWeapon());

        assertEquals(name, testThief.getName());

    }


}
