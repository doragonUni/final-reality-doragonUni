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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class controllerTest {
    protected BlockingQueue<ICharacter> turns = new LinkedBlockingQueue<>();
    private Axe testAxe;
    private Bow testBow;
    private Knife testKnife;
    private Sword testSword;
    private Staff testStaff;
    //private Inventory inventory;
    private Enemy boss;
    private Enemy canonMinion;
    private Enemy canonMinion2;
    private Knight saber;
    private WhiteMage soraka;
    private BlackMage sorakant;
    private Thief thief;
    private Engineer bobby;

    private GameController controller;
    private IDeathHandler playerDeathNoti;
    private IDeathHandler enemyNoti;

    @BeforeEach
    void setUp(){
        controller = new GameController();
        playerDeathNoti = new PlayerDeathHandler(controller);
        enemyNoti = new EnemyDeathHandler(controller);
        testBow = controller.bowCreator("lego",10, 20);
        testAxe=  controller.axeCreator("olaf",10, 30);
        testKnife = controller.knifeCreator("legoLas",102, 330);
        testSword = controller.swordCreator("excaliber", 10000000,2);
        testStaff = controller.staffCreator("varita magica",102, 330, 100);

        boss = controller.enemyCreator("globlin", 10, 20, 10, 1000000);
        canonMinion = controller.enemyCreator("canon", 10, 20, 0, 1);
        canonMinion2 = controller.enemyCreator("canon2", 11, 2, 0, 1);
        saber = controller.knightCreator("saber", 10, 10);
        soraka = controller.whiteMageCreator("soraka", 1, 0, 10);
        sorakant = controller.blackMageCreator("sorakant", 1,2,30);
        thief = controller.thiefCreator("bob", 1,2);
        bobby = controller.engineerCreator("bobb", 13,45);


    }
    @Test
    void inventoryTest(){
        assertEquals(true, controller.isInventoryEmpty());
        controller.putInventoryItem(testSword.getName(),testSword);
        assertNotEquals(true,controller.isInventoryEmpty());
        controller.equipWeaponInventory(testSword, saber);
        assertEquals(true, controller.isInventoryEmpty());
        controller.putInventoryItem(testKnife.getName(), testKnife);
        controller.equipWeaponInventory(testKnife, saber);
        assertEquals(testKnife, saber.getEquippedWeapon());
        assertEquals(false, controller.isItemInventory(testKnife));
        assertEquals(true, controller.isItemInventory(testSword));
        IWeapon get0 = controller.selectInventoryItem(testSword.getName());
        assertEquals(testSword, get0);
        assertEquals(true,controller.isInventoryEmpty());

    }

    @Test
    void handlerTest(){
        saber.equipWeapon(testSword);
        soraka.equipWeapon(testStaff);
        controller.controllerAttack(boss, soraka);
        controller.controllerAttack(saber, canonMinion);
        controller.controllerAttack(saber, canonMinion2);
    }

    @Test
    void getterTest(){
        assertEquals("globlin", controller.getCharacterName(boss));
        assertEquals(10, controller.getEnemyWeight(boss));
        assertEquals(1000000, controller.getCharacterAttack(boss));
        assertEquals(0, controller.getCharacterAttack(saber));
        saber.equipWeapon(testSword);
        assertNotEquals(0, controller.getCharacterAttack(saber));
        assertEquals(testSword.getDamage(), controller.getCharacterAttack(saber));
        assertEquals(1, controller.getCharacterHp(soraka));
        assertEquals(45, controller.getCharacterDef(bobby));
        //falta testear mana
    }
}
