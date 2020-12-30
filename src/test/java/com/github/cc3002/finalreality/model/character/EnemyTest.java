package com.github.cc3002.finalreality.model.character;

import com.github.doragonUni.finalreality.model.character.Enemy;
import com.github.doragonUni.finalreality.model.character.ICharacter;
import com.github.doragonUni.finalreality.model.character.player.Knight;

import com.github.doragonUni.finalreality.model.weapon.Sword;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import static org.junit.jupiter.api.Assertions.*;


class EnemyTest {

  private static final String ENEMY_NAME = "Goblin";
  private static final int WEIGHT = 10;
  private int hp = 500;
  private int def = 100;
  private int attack = 430;
  protected BlockingQueue<ICharacter> turns;
  protected List<Enemy> EnemyList;

  Enemy testEnemy;
  Enemy testEnemy1;
  Enemy testEnemy2;
  Enemy testEnemy3;
  Enemy testEnemy4;
  Enemy testEnemy5;
  Knight fakeEnemy;
  Sword sword;

  /**
   * TEST FOR THE GETTERS
   */
  @BeforeEach
  void setUp(){

    turns = new LinkedBlockingQueue<>();
    EnemyList = new ArrayList<>();

    testEnemy = new Enemy(ENEMY_NAME, turns, WEIGHT, hp, def, attack);
    testEnemy1 = new Enemy("minion",turns, WEIGHT, hp, def, attack);
    testEnemy2 = new Enemy(ENEMY_NAME, turns, 20, hp, def, attack);
    testEnemy3 = new Enemy(ENEMY_NAME, turns, WEIGHT, 5, def, attack);
    testEnemy4 = new Enemy(ENEMY_NAME, turns, WEIGHT, hp, 10, attack);
    testEnemy5 = new Enemy(ENEMY_NAME, turns, WEIGHT, hp, def, 1000);

    fakeEnemy = new Knight("stealth", turns, hp, def);
    sword = new Sword("AliexpressSword", 100000, 40);

    EnemyList.add(testEnemy);
    EnemyList.add(testEnemy1);
    EnemyList.add(testEnemy2);
    EnemyList.add(testEnemy3);
    EnemyList.add(testEnemy4);

  }

  /**
   * TEST FOR THE CONSTRUCTOR
   */
  @Test
  void constructorTest(){
    var expectedEnemy = new Enemy(ENEMY_NAME, turns, WEIGHT, hp, def, attack);
    assertEquals(expectedEnemy, testEnemy);
    assertEquals(expectedEnemy.hashCode(), testEnemy.hashCode());
    assertNotEquals(testEnemy.hashCode(), fakeEnemy.hashCode());
    assertEquals(testEnemy, testEnemy);
    assertNotEquals(testEnemy, fakeEnemy);

    assertNotEquals(expectedEnemy, testEnemy1);
    assertNotEquals(expectedEnemy, testEnemy2);
    assertNotEquals(expectedEnemy, testEnemy3);
    assertNotEquals(expectedEnemy, testEnemy4);
    assertNotEquals(expectedEnemy, testEnemy5);

  }

  /**
   * TEST FOR THE GETTERS
   */
  @Test
  void getTests(){
    assertEquals(hp, testEnemy.getHp());
    assertEquals(def, testEnemy.getDef());
    assertEquals(ENEMY_NAME, testEnemy.getName());
    assertEquals(WEIGHT, testEnemy.getWeight());
    assertEquals(attack, testEnemy.getAttack());
    assertEquals(hp, testEnemy.getTotalHp());
    assertEquals(0, testEnemy.getCharacter());

  }




  /**
   * TEST FOR WAIT TURN ENEMY
   */
  @Test
  void waitTurnTest() {
    assertTrue(turns.isEmpty());
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