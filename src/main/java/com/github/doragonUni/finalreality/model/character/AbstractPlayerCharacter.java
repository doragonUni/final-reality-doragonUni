package com.github.doragonUni.finalreality.model.character;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import com.github.doragonUni.finalreality.model.weapon.IWeapon;
import org.jetbrains.annotations.NotNull;

/**
 * An abstract class that holds the common behaviour of all the PLAYER characters in the game.
 *
 * @author Ignacio Slater Muñoz.
 * @author <Your name>
 */
public abstract class AbstractPlayerCharacter extends AbstractCharacter implements IPlayerCharacter {

  /**
   * Abstract Class for Characters
   *
   *
   * @param name       the character's name
   * @param turnsQueue the queue with the characters waiting for their turn
   * @param hp         this character's health points
   * @param defense    this character defense points
   * @param equipWeapon the character's equipped weapon
   * @param isAlive     character live status
   */

  private ScheduledExecutorService scheduledExecutor;
  private IWeapon equippedWeapon = null;




  protected AbstractPlayerCharacter(@NotNull BlockingQueue<ICharacter> turnsQueue, String name, int hp, int defense) {
    super(turnsQueue, name, hp, defense);


  }



  /**
   * get the physical Damage of the weapon equipped by this mage
   */


  /**
   * gets the Weapon equipped by the Character
   */
  @Override
  public IWeapon getEquippedWeapon() {
    return this.equippedWeapon;
  }


  @Override
  public void setEquippedWeapon(IWeapon weapon){
    this.equippedWeapon = weapon;
  }

  public abstract void equipWeapon(IWeapon weapon);


  @Override
  public int getAttack() {
    if (this.equippedWeapon == null){
      return 0;
    }
    else{
      return equippedWeapon.getDamage();
    }
  }

  @Override
  public void attack(ICharacter pj){
    pj.attackedBy(this.getAttack());
  }





  /**
   * Adds this character to the turns queue.
   */
  @Override
  public void addToQueue() {
    turnsQueue.add(this);
    scheduledExecutor.shutdown();
  }

  /**
   * function that wait the turn of the round
   */
  @Override
  public void waitTurn() {
    scheduledExecutor = Executors.newSingleThreadScheduledExecutor();
    scheduledExecutor
            .schedule(this::addToQueue, equippedWeapon.getWeight() / 10, TimeUnit.SECONDS);
  }

}

