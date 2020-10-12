package com.github.cc3002.finalreality.model.character;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import com.github.doragonUni.finalreality.model.character.Enemy;

import java.util.EnumMap;
import java.util.Map;
import java.util.concurrent.BlockingQueue;

import com.github.doragonUni.finalreality.model.character.ICharacter;
import com.github.doragonUni.finalreality.model.character.player.Engineer;
import com.github.doragonUni.finalreality.model.weapon.Axe;
import com.github.doragonUni.finalreality.model.weapon.Bow;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class EngineerTest {

    protected BlockingQueue<ICharacter> turns;
    private static final String name = "Engineer";
    protected Bow bow = new Bow("bow", 10, 5 );
    protected Axe axe = new Axe("axe", 10 , 5 );

    private Engineer testEngineer;



    @BeforeEach
    void setUp(){
        testEngineer = new Engineer(name, turns);
    }

    @Test
    void constructorTest(){
        var expectedEngineer = new Engineer(name, turns);
        assertEquals(expectedEngineer, testEngineer);
        assertEquals(expectedEngineer.hashCode(), testEngineer.hashCode());
        assertNull(testEngineer.getEquippedWeapon());
        testEngineer.equipAxe(axe);
        assertEquals(axe, testEngineer.getEquippedWeapon());
        testEngineer.equipBow(bow);
        assertEquals(bow, testEngineer.getEquippedWeapon());

        assertEquals(name, testEngineer.getName());

    }
}
