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
  protected final String name;
  private ScheduledExecutorService scheduledExecutor;
  private final int weight;

  /**
   * Creates a new enemy with a name, a weight and the queue with the characters ready to
   * play.
   */
  public Enemy(@NotNull final String name, final int weight,
               @NotNull final BlockingQueue<ICharacter> turnsQueue) {
    this.turnsQueue = turnsQueue;
    this.name = name;
    this.weight = weight;

  }

  /**
   * Returns the weight of this enemy.
   */

  @Override
  public void addToQueue() {
    turnsQueue.add(this);
    scheduledExecutor.shutdown();
  }

  @Override
  public void waitTurn() {
    scheduledExecutor = Executors.newSingleThreadScheduledExecutor();
    var enemy = (Enemy) this;
    scheduledExecutor
            .schedule(this::addToQueue, enemy.getWeight() / 10, TimeUnit.SECONDS);
  }

  @Override
  public String getName() {
    return this.name;
  }

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
            getName().equals(enemy.getName());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getWeight());
  }
}