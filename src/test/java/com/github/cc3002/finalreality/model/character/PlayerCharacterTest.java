package com.github.cc3002.finalreality.model.character;

import com.github.doragonUni.finalreality.model.character.ICharacter;
import com.github.doragonUni.finalreality.model.character.player.*;
import com.github.doragonUni.finalreality.model.weapon.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class PlayerCharacterTest {

    protected BlockingQueue<ICharacter> turns;
    protected List<ICharacter> CharactersList;

    private Engineer engineerTest;
    private Knight knightTest;
    private Thief thiefTest;
    private BlackMage blackMageTest;
    private WhiteMage whiteMageTest;

    private Axe axe;
    private Bow bow;
    private Knife knife;
    private Staff staff;
    private Sword sword;

    @BeforeEach
    void setUp(){

        turns = new LinkedBlockingQueue<>();
        CharactersList = new ArrayList<>();

        axe = new Axe("axe", 10, 5);
        bow = new Bow("bow", 15, 10);
        knife = new Knife("knife",20,5);
        staff = new Staff("staff", 10, 10, 10);
        sword = new Sword("sword", 15, 5);

        engineerTest = new Engineer("engineer", turns);
        knightTest = new Knight("knight", turns);
        thiefTest = new Thief("thief", turns);
        blackMageTest = new BlackMage("blackMage", turns, 10);
        whiteMageTest = new WhiteMage("whiteMage", turns, 10);

        engineerTest.equipBow(bow);
        knightTest.equipSword(sword);
        thiefTest.equipKnife(knife);
        blackMageTest.equipStaff(staff);
        whiteMageTest.equipStaff(staff);

        CharactersList.add(engineerTest);
        CharactersList.add(knightTest);
        CharactersList.add(thiefTest);
        CharactersList.add(blackMageTest);
        CharactersList.add(whiteMageTest);

    }


    @Test
    void waitTurnTest() {
        Assertions.assertTrue(turns.isEmpty());
        CharactersList.get(0).waitTurn();
        try {
            // Thread.sleep is not accurate so this values may be changed to adjust the
            // acceptable error margin.
            // We're testing that the character waits approximately 1 second.
            Thread.sleep(900);
            Assertions.assertEquals(0, turns.size());
            Thread.sleep(200);
            Assertions.assertEquals(1, turns.size());
            Assertions.assertEquals(CharactersList.get(0), turns.peek());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}

