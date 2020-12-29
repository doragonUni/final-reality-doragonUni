package com.github.cc3002.finalreality.model.controller;

import com.github.doragonUni.finalreality.controller.GameController;
import com.github.doragonUni.finalreality.controller.phases.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Turn2Test {
    GameController controller;




    @BeforeEach
    protected void SetUp() {
        controller = new GameController();
        controller.engineerCreator("Elon Musk",1,0);
        controller.knightCreator("KNGHT",1,0);
        controller.thiefCreator("Thief",1,0);
        controller.blackMageCreator("BM1",1,10,1);
        controller.enemyCreator("Enemy",5,1000,10,100000);
        controller.enemyCreator("Enemy2",15,100,13,100);
        controller.enemyCreator("Enemy3",10,100,5,300);
        //controller.enemyCreator("Enemy4",12,100,0,70);
        //controller.enemyCreator("Enemy5",15,120,0,240);


        controller.bowCreator("Bow0",1,40);
        controller.bowCreator("Bow1",7,40);
        controller.swordCreator("excaliber", 1,40);
        controller.knifeCreator("karambit", 6,11);

        controller.tryToEquip(controller.selectInventoryItem("Bow0"), controller.getFromParty(0));
        controller.tryToEquip(controller.selectInventoryItem("Bow1"), controller.getFromParty(2));
        controller.tryToEquip(controller.selectInventoryItem("excaliber"), controller.getFromParty(1));
        controller.tryToEquip(controller.selectInventoryItem("karambit"), controller.getFromParty(3));

    }

    @Test
    void turnTest() throws InterruptedException {
        controller.loadingGame();
        Thread.sleep(5500);





    }


}

