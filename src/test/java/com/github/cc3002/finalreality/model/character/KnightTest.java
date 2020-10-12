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
import com.github.doragonUni.finalreality.model.character.player.Knight;
import com.github.doragonUni.finalreality.model.weapon.Axe;
import com.github.doragonUni.finalreality.model.weapon.Bow;
import com.github.doragonUni.finalreality.model.weapon.Knife;
import com.github.doragonUni.finalreality.model.weapon.Sword;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class KnightTest {

    protected BlockingQueue<ICharacter> turns;
    private static final String name = "knight";
    protected Sword sword = new Sword("sword", 10, 5 );
    protected Axe axe = new Axe("axe", 10 , 5 );
    protected Knife knife = new Knife( "knife",10, 5);

    private Knight testKnight;

    @BeforeEach
    void setUp(){
        testKnight = new Knight(name, turns);
    }

    @Test
    void constructorTest(){
        var expectedKnight = new Knight(name, turns);
        assertEquals(expectedKnight, testKnight);
        assertEquals(expectedKnight.hashCode(), testKnight.hashCode());
        assertNull(testKnight.getEquippedWeapon());
        testKnight.equipAxe(axe);
        assertEquals(axe, testKnight.getEquippedWeapon());
        testKnight.equipSword(sword);
        assertEquals(sword, testKnight.getEquippedWeapon());
        testKnight.equipKnife(knife);
        assertEquals(knife, testKnight.getEquippedWeapon());

        assertEquals(name, testKnight.getName());



    }
}
