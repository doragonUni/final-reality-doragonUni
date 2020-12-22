package com.github.cc3002.finalreality.model.controller;

import com.github.doragonUni.finalreality.controller.GameController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

class TurnTest {
    GameController controller;




    @BeforeEach
    protected void SetUp() {
        controller = new GameController();
        controller.engineerCreator("Elon Musk",100,10);
        controller.knightCreator("KNGHT",100,30);
        controller.thiefCreator("Thief",100,10);
        controller.blackMageCreator("BM1",100,10,1);
        controller.enemyCreator("Enemy",14,100,10,100000);
        controller.enemyCreator("Enemy2",15,100,10,100);
        controller.enemyCreator("Enemy3",20,100,5,300);
        controller.enemyCreator("Enemy4",12,100,0,70);


        controller.bowCreator("Bow0",110,15);
        controller.bowCreator("Bow1",70,13);
        controller.swordCreator("excaliber", 100000,20);
        controller.knifeCreator("karambit", 69,12);

        controller.equipWeaponInventory(controller.selectInventoryItem("Bow0"), controller.getFromParty(0));
        controller.equipWeaponInventory(controller.selectInventoryItem("Bow1"), controller.getFromParty(2));
        controller.equipWeaponInventory(controller.selectInventoryItem("excaliber"), controller.getFromParty(1));
        controller.equipWeaponInventory(controller.selectInventoryItem("karambit"), controller.getFromParty(3));




    }
    @RepeatedTest(1)
    void turnTest() throws InterruptedException {


        controller.loadingGame();
        Thread.sleep(5000);

        controller.blackMageCreator("jaja", 1,2,4);
        controller.whiteMageCreator("jaja1", 1,2,4);
        controller.knightCreator("jaja2", 1,2);
        controller.thiefCreator("jaja3", 1,2);
        controller.engineerCreator("jaja4", 1,2);













    }

}
