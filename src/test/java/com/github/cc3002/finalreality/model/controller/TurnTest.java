package com.github.cc3002.finalreality.model.controller;

import com.github.doragonUni.finalreality.controller.GameController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TurnTest {

    GameController controller;

    @BeforeEach
    void setUp(){
        controller = new GameController();


        controller.swordCreator("sword", 10000000,4);

        controller.enemyCreator("enemy1", 15, 20, 0, 1);
        controller.enemyCreator("enemy2", 26, 20, 0, 1);




        controller.knightCreator("knight", 10, 10);





    }

    @Test
    public void turnTest() {
        controller.equipWeaponInventory(controller.selectInventoryItem("sword"), controller.getFromParty(0) );



        controller.start();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        controller.beginTurn();
        controller.controllerAttack(controller.getActualCharacter(), controller.getFromEnemy(0));
        controller.beginTurn();
        controller.controllerAttack(controller.getActualCharacter(), controller.getFromParty(0));
        controller.beginTurn();
        controller.controllerAttack(controller.getActualCharacter(), controller.getFromParty(0));
        controller.beginTurn();
        controller.controllerAttack(controller.getActualCharacter(), controller.getFromEnemy(1));







    }
}
