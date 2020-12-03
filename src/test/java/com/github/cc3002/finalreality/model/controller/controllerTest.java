package com.github.cc3002.finalreality.model.controller;

import com.github.doragonUni.finalreality.controller.*;
import com.github.doragonUni.finalreality.model.character.Enemy;
import com.github.doragonUni.finalreality.model.character.ICharacter;
import com.github.doragonUni.finalreality.model.character.player.*;
import com.github.doragonUni.finalreality.model.weapon.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import static org.junit.jupiter.api.Assertions.*;

public class controllerTest {
    protected BlockingQueue<ICharacter> turns = new LinkedBlockingQueue<>();


    private GameController controller;

    @BeforeEach
    void setUp(){
        controller = new GameController(4,3);
        controller.bowCreator("bow",47, 20);
        controller.axeCreator("axe",10, 30);
        controller.knifeCreator("knife",102, 330);
        controller.swordCreator("sword", 10000000,2);
        controller.staffCreator("staff",102, 330, 100);

        controller.enemyCreator("enemy", 102, 20, 10, 1000000);
        controller.enemyCreator("enemy1", 10, 20, 0, 1);
        controller.enemyCreator("enemy2", 11, 2, 0, 13);
        controller.enemyCreator("no tiene q agregarse", 1,2,4,56);
        controller.knightCreator("knight", 10, 10);
        controller.whiteMageCreator("white", 16, 0, 10);
        controller.blackMageCreator("nibba", 1,2,30);
        controller.thiefCreator("thief", 178,2);
        controller.engineerCreator("engine", 13,45);


    }
    @Test
    void partyTest() {
        assertEquals(4, controller.getParty().size());
        assertEquals(3, controller.getEnemyParty().size());
        assertEquals("knight", controller.getCharacterName(controller.getFromParty(0)));
        assertEquals(0, controller.getCharacterAttack(controller.getFromParty(1)));
        assertEquals(2, controller.getCharacterDef(controller.getFromParty(2)));
        assertEquals(178, controller.getCharacterHp(controller.getFromParty(3)));
        assertEquals("knight", controller.getCharacterName(controller.getFromParty(0)));
        assertEquals(102, controller.getEnemyWeight(controller.getFromEnemy(0)));
        assertEquals(30, controller.getMageMana((IMage) controller.getFromParty(2)));
    }


    @Test
    void inventoryTest() {

        assertEquals(false, controller.isInventoryEmpty());
        controller.equipWeaponInventory(controller.selectInventoryItem("sword"), controller.getFromParty(0));
        controller.equipWeaponInventory(controller.selectInventoryItem("staff"), controller.getFromParty(1));
        assertEquals(false, controller.isItemInventory("sword"));
        controller.controllerAttack(controller.getFromParty(0), controller.getFromEnemy(2));
        controller.controllerAttack(controller.getFromEnemy(0), controller.getFromParty(1));
        assertEquals(0, controller.getFromEnemy(2).getHp());
        assertEquals(0, controller.getFromParty(1).getHp());

        assertEquals(null, controller.getCharacterEquipWeapon(controller.getFromParty(3)));
        controller.equipWeaponInventory(controller.selectInventoryItem("axe"), controller.getFromParty(3));
        assertEquals(true, controller.isItemInventory("axe"));
        assertEquals(null, controller.getCharacterEquipWeapon(controller.getFromParty(3)));
        controller.equipWeaponInventory(controller.selectInventoryItem("bow"), controller.getFromParty(3));
        assertEquals(47, controller.getCharacterAttack(controller.getFromParty(3)));
        assertEquals(false, controller.isItemInventory("bow"));
        controller.equipWeaponInventory(controller.selectInventoryItem("axe"), controller.getFromParty(3));
        assertEquals("bow", controller.getFromParty(3).getEquippedWeapon().getName());
        assertEquals(true, controller.isItemInventory("axe"));
        controller.equipWeaponInventory(controller.selectInventoryItem("knife"), controller.getFromParty(3));
        assertEquals("knife", controller.getFromParty(3).getEquippedWeapon().getName());
        assertEquals(true, controller.isItemInventory("bow"));
        assertEquals(false, controller.isItemInventory("knife"));

    }











}
