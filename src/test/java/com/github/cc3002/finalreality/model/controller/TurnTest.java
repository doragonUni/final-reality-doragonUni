package com.github.cc3002.finalreality.model.controller;

import com.github.doragonUni.finalreality.controller.GameController;
import com.github.doragonUni.finalreality.controller.phases.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class TurnTest {
    GameController controller;




    @BeforeEach
    protected void SetUp() {
        controller = new GameController();
        controller.engineerCreator("Elon Musk",100,10);
        controller.knightCreator("KNGHT",100,30);
        controller.thiefCreator("Thief",1000,10);
        controller.blackMageCreator("BM1",100,10,1);
        controller.enemyCreator("Enemy",1000,1,1,100000);
        //controller.enemyCreator("Enemy2",15,100,13,100);
        //controller.enemyCreator("Enemy3",10,100,5,300);
        //controller.enemyCreator("Enemy4",12,100,0,70);
        //controller.enemyCreator("Enemy5",15,120,0,240);


        controller.bowCreator("Bow0",10000,1);
        controller.bowCreator("Bow1",7000,7);
        controller.swordCreator("excaliber", 100000,10);
        controller.knifeCreator("karambit", 69000,11);

        controller.tryToEquip(controller.selectInventoryItem("Bow0"), controller.getFromParty(0));
        controller.tryToEquip(controller.selectInventoryItem("Bow1"), controller.getFromParty(2));
        controller.tryToEquip(controller.selectInventoryItem("excaliber"), controller.getFromParty(1));
        controller.tryToEquip(controller.selectInventoryItem("karambit"), controller.getFromParty(3));




    }
    @Test
    void turnTest() throws InterruptedException {
        controller.loadingGame();
        Thread.sleep(5500);
        controller.tryToAttack(controller.getActualCharacter(), controller.getFromEnemy(0));
        assertTrue(controller.winner());
        assertFalse(controller.looser());
        controller.blackMageCreator("jaja", 1,2,4);
        controller.whiteMageCreator("jaja1", 1,2,4);
        controller.knightCreator("jaja2", 1,2);
        controller.thiefCreator("jaja3", 1,2);
        controller.engineerCreator("jaja4", 1,2);
        controller.enemyCreator("jaja4", 1,2, 1, 1);
        controller.loadingGame();
        controller.getActualName();
        controller.tryToBeginTurn();


    }




}
