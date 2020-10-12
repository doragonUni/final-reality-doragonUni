package com.github.cc3002.finalreality.model.character;

import com.github.doragonUni.finalreality.model.character.Enemy;
import com.github.doragonUni.finalreality.model.character.ICharacter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import static org.junit.jupiter.api.Assertions.assertEquals;


class EnemyTest {

  private static final String ENEMY_NAME = "Goblin";
  protected BlockingQueue<ICharacter> turns;
  protected List<Enemy> EnemyList;

  Enemy testEnemy;
  Enemy testEnemy1;
  Enemy testEnemy2;

  @BeforeEach
  void setUp(){

    turns = new LinkedBlockingQueue<>();
    EnemyList = new ArrayList<>();
    testEnemy = new Enemy(ENEMY_NAME, 10 , turns);
    testEnemy1 = new Enemy(ENEMY_NAME, 10 , turns);
    testEnemy2 = new Enemy(ENEMY_NAME, 10 , turns);
    EnemyList.add(testEnemy);
    EnemyList.add(testEnemy1);
    EnemyList.add(testEnemy2);



  }

  @Test
  void constructorTest(){
    var expectedEnemy = new Enemy(ENEMY_NAME, 10, turns);
    assertEquals(expectedEnemy, testEnemy);
    assertEquals(expectedEnemy.hashCode(), testEnemy.hashCode());
  }

  @Test
  void waitTurnTest() {
    Assertions.assertTrue(turns.isEmpty());
    EnemyList.get(0).waitTurn();
    try {
      // Thread.sleep is not accurate so this values may be changed to adjust the
      // acceptable error margin.
      // We're testing that the character waits approximately 1 second.
      Thread.sleep(900);
      Assertions.assertEquals(0, turns.size());
      Thread.sleep(200);
      Assertions.assertEquals(1, turns.size());
      Assertions.assertEquals(EnemyList.get(0), turns.peek());
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }



}