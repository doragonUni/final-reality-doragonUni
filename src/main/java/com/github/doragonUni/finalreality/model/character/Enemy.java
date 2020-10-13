package com.github.doragonUni.finalreality.model.character;

import java.util.Objects;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import org.jetbrains.annotations.NotNull;

/**
 * A class that holds all the information of a single enemy of the game.
 *
 * @author Ignacio Slater Muñoz
 * @author <Your name>
 */
public class Enemy implements ICharacter {

  protected final BlockingQueue<ICharacter> turnsQueue;
  private ScheduledExecutorService scheduledExecutor;
  protected final String name;
  private final int weight;
  private final int hp;
  private final int defense;

  /**
   * Creates a new enemy with a name, a weight and the queue with the characters ready to
   * play.
   */
  public Enemy(@NotNull final String name, @NotNull final BlockingQueue<ICharacter> turnsQueue,
               final int weight, final int hp, final int defense) {
    /**
     * Creates a new Enemy.
     *
     * @param name       the character's name
     * @param weight      enemy's weight
     * @param turnsQueue     the queue with the characters waiting for their turn
     * @param hp        this character's health points
     * @param defense    this character defense points
     *
     */
    this.turnsQueue = turnsQueue;
    this.name = name;
    this.weight = weight;
    this.hp = hp;
    this.defense = defense;

  }



  /**
   * gets the Enemy Health Points
   */
  @Override
  public int getHp() {
    return this.hp;
  }


  /**
   * gets the Enemy Defense
   */
  @Override
  public int getDef() {
    return this.defense;
  }

  /**
   *Adds an Enemy to the Queue
   */
  @Override
  public void addToQueue() {
    turnsQueue.add(this);
    scheduledExecutor.shutdown();
  }

  /**
   * @see ICharacter
   */
  @Override
  public void waitTurn() {
    scheduledExecutor = Executors.newSingleThreadScheduledExecutor();
    var enemy = (Enemy) this;
    scheduledExecutor
            .schedule(this::addToQueue, enemy.getWeight() / 10, TimeUnit.SECONDS);
  }


  /**
   * gets the Enemy name
   */
  @Override
  public String getName() {
    return this.name;
  }

  /**
   * gets the Enemy Weight
   */
  public int getWeight() {
    return weight;
  }



  @Override
  public boolean equals(final Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Enemy)) {
      return false;
    }
    final Enemy enemy = (Enemy) o;
    return getWeight() == enemy.getWeight() &&
            getName().equals(enemy.getName()) &&
            getHp() == enemy.getHp() &&
            getDef() == enemy.getDef();
  }

  @Override
  public int hashCode() {
    return Objects.hash(getWeight());
  }
}