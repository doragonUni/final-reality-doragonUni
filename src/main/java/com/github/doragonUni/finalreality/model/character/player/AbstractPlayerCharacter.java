package com.github.doragonUni.finalreality.model.character.player;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import com.github.doragonUni.finalreality.model.character.AbstractCharacter;
import com.github.doragonUni.finalreality.model.character.ICharacter;
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


  private IWeapon equippedWeapon;





  protected AbstractPlayerCharacter(@NotNull BlockingQueue<ICharacter> turnsQueue, String name, int hp, int defense) {
    super(turnsQueue, name, hp, defense);
    this.equippedWeapon = null;


  }






  /**
   * gets the Weapon equipped by the Character
   */
  @Override
  public IWeapon getEquippedWeapon() {
    return this.equippedWeapon;
  }

  /**
   * change the current equipWeapon
   * @param weapon
   */
  @Override
  public void setEquippedWeapon(IWeapon weapon){
    this.equippedWeapon = weapon;
  }

  /**
   * equips this weapon to the character
   * @param weapon
   */
  public abstract void equipWeapon(IWeapon weapon);

  /**
   * get the weapon name if there is any null weapon;
   */
  @Override
  public String getWeaponName(){
    if (this.equippedWeapon==null){
      return "------";
    }
    else{
      return this.equippedWeapon.getName();
    }
  }

  /**
   * get the physical Damage of the weapon equipped by this mage
   */
  @Override
  public int getAttack() {
    if (this.equippedWeapon == null){
      return 0;
    }
    else{
      return equippedWeapon.getDamage();
    }
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

  /**
   * return 1 to verify that is a playerCharacter
   */
  @Override
  public int getCharacter(){
    return 1;
  }

}
