package com.github.cc3002.finalreality.model.controller;

import com.github.doragonUni.finalreality.controller.*;
import com.github.doragonUni.finalreality.controller.phases.*;
import com.github.doragonUni.finalreality.model.character.player.*;
import com.github.doragonUni.finalreality.model.weapon.IWeapon;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

public class ControllerTest {



    private GameController controller;

    @BeforeEach
    void setUp(){
        controller = new GameController();
        controller.bowCreator("bow",47, 17);
        controller.axeCreator("axe",10, 6);
        controller.knifeCreator("knife",102,4 );
        controller.swordCreator("sword", 10000000,28);
        controller.staffCreator("staff",102, 14, 100);
        controller.bowCreator("bow1",47, 17);
        controller.axeCreator("axe1",10, 6);
        controller.knifeCreator("knife1",102,4 );
        controller.swordCreator("sword1", 10000000,28);
        controller.staffCreator("staff1",102, 14, 100);
        controller.bowCreator("bow2",47, 17);
        controller.axeCreator("axe2",10, 6);
        controller.knifeCreator("knife2",102,4 );
        controller.swordCreator("sword2", 10000000,28);
        controller.staffCreator("staff2",102, 14, 100);

        controller.enemyCreator("enemy", 102, 20, 10, 1000000);
        controller.enemyCreator("enemy1", 15, 20, 0, 1);
        controller.enemyCreator("enemy2", 13, 2, 0, 13);
        controller.enemyCreator("enemy3", 10,2,4,56);
        controller.enemyCreator("enemy4", 1,200,40,6);
        controller.enemyCreator("XD", 100000,200000,40000,56000);
        controller.knightCreator("knight", 10, 10);
        controller.whiteMageCreator("white", 16, 0, 10);
        controller.blackMageCreator("nig", 1,2,30);
        controller.thiefCreator("thief", 178,2);
        controller.engineerCreator("engine", 13,45);


    }
    @Test
    void partyTest() {
        var expectedParty = controller.getParty();
        var expectedEnemyParty = controller.getEnemyParty();
        assertEquals(expectedParty, controller.getParty());
        assertEquals(expectedEnemyParty, controller.getEnemyParty());

        assertEquals(4, controller.getParty().size());
        assertEquals(5, controller.getEnemyParty().size());

        assertEquals("knight", controller.getCharacterName(controller.getFromParty(0)));
        assertEquals(0, controller.getCharacterAttack(controller.getFromParty(1)));
        assertEquals(2, controller.getCharacterDef(controller.getFromParty(2)));
        assertEquals(178, controller.getCharacterHp(controller.getFromParty(3)));
        assertEquals("knight", controller.getCharacterName(controller.getFromParty(0)));
        assertEquals(102, controller.getEnemyWeight(controller.getFromEnemy(0)));
        assertEquals(30, controller.getMageMana((IMage) controller.getFromParty(2)));
    }

    @Test
    void constructorTest(){
        assertEquals(4, controller.getPartyNum());
        assertEquals(4, controller.getPartySize());
        assertEquals(10, controller.getInventorySpace());
        assertEquals(5, controller.getEnemySize());
        assertEquals("no name", controller.getActualName());
        assertEquals(controller.getInventorySpace(), controller.getInventory().size());
        assertNull(controller.getActualCharacter());
        assertEquals("", controller.getLog());
        assertFalse(controller.winner());
        assertFalse(controller.looser());


    }


    @Test
    void inventoryTest()   {

        assertFalse(controller.isInventoryEmpty());
        controller.tryToEquip(controller.selectInventoryItem("sword"), controller.getFromParty(0));
        assertEquals("sword", controller.getCharacterWeaponName(controller.getFromParty(0)));
        controller.setPhase(new SelectPhase());
        controller.tryToEquip(controller.selectInventoryItem("staff"), controller.getFromParty(1));
        assertFalse(controller.isItemInventory("sword"));
        controller.setPhase(new LoadingPhase());
        assertNull(controller.getCharacterEquipWeapon(controller.getFromParty(3)));
        controller.tryToEquip(controller.selectInventoryItem("axe"), controller.getFromParty(3));
        assertTrue(controller.isItemInventory("axe"));
        assertNull(controller.getCharacterEquipWeapon(controller.getFromParty(3)));
        controller.tryToEquip(controller.selectInventoryItem("bow"), controller.getFromParty(3));
        assertEquals(47, controller.getCharacterAttack(controller.getFromParty(3)));
        assertFalse(controller.isItemInventory("bow"));
        controller.tryToEquip(controller.selectInventoryItem("axe"), controller.getFromParty(3));
        assertEquals("bow", controller.getFromParty(3).getEquippedWeapon().getName());
        assertTrue(controller.isItemInventory("axe"));
        controller.tryToEquip(controller.selectInventoryItem("knife"), controller.getFromParty(3));
        assertEquals("knife", controller.getFromParty(3).getEquippedWeapon().getName());
        assertTrue(controller.isItemInventory("bow"));
        assertFalse(controller.isItemInventory("knife"));
        assertFalse(controller.isItemInventory("knife2"));

    }

    @Test
    void phaseWinTest(){
        assertTrue(controller.getPhase().isSetUpPhase());
        controller.setPhase(new WaitingPhase());
        assertTrue(controller.getPhase().isWaitingPhase());
        controller.setPhase(new TurnPhase());
        assertTrue(controller.getPhase().isTurnPhase());
        controller.setPhase(new SelectPhase());
        assertFalse(controller.getPhase().isTurnPhase());
        controller.setPhase(new WinPhase());
        assertFalse(controller.getPhase().isTurnPhase());
    }

    @Test
    void phaseLoseTest(){
        assertTrue(controller.getPhase().isSetUpPhase());
        assertFalse(controller.getPhase().isTurnPhase());
        controller.setPhase(new WaitingPhase());
        assertTrue(controller.getPhase().isWaitingPhase());
        controller.setPhase(new TurnPhase());
        assertTrue(controller.getPhase().isTurnPhase());
        controller.setPhase(new SelectPhase());
        controller.setPhase(new LosePhase());
    }












}
