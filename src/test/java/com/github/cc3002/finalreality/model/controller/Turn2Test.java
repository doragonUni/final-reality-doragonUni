package com.github.cc3002.finalreality.model.controller;

import com.github.doragonUni.finalreality.controller.GameController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;

public class Turn2Test {
    GameController controller;




    @BeforeEach
    protected void SetUp() {
        controller = new GameController();
        controller.engineerCreator("Elon Musk",100,10);
        controller.knightCreator("KNGHT",100,30);
        controller.thiefCreator("Thief",100,10);
        controller.blackMageCreator("BM1",100,10,1);
        controller.enemyCreator("Enemy",14,100,10,403);
        controller.enemyCreator("Enemy2",32,100,10,100);
        controller.enemyCreator("Enemy3",40,100,5,300);
        controller.enemyCreator("Enemy4",22,100,0,70);


        controller.bowCreator("Bow0",110,35);
        controller.bowCreator("Bow1",70,13);
        controller.swordCreator("excaliber", 1000,23);
        controller.knifeCreator("karambit", 69,17);

        controller.equipWeaponInventory(controller.selectInventoryItem("Bow0"), controller.getFromParty(0));
        controller.equipWeaponInventory(controller.selectInventoryItem("Bow1"), controller.getFromParty(2));
        controller.equipWeaponInventory(controller.selectInventoryItem("excaliber"), controller.getFromParty(1));
        controller.equipWeaponInventory(controller.selectInventoryItem("karambit"), controller.getFromParty(3));




    }
    @RepeatedTest(1)
    void turnTest() throws InterruptedException {


        controller.loadingGame();
        Thread.sleep(5000);

        System.out.println("END OF THE GAME ");











    }

}
