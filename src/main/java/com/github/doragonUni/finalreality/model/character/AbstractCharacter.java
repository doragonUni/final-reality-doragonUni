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
public abstract class AbstractCharacter implements ICharacter {

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
  protected final BlockingQueue<ICharacter> turnsQueue;
  private final String name;
  private int hp;
  private final int defense;
  private boolean isAlive;



  protected AbstractCharacter(@NotNull BlockingQueue<ICharacter> turnsQueue,
                              @NotNull String name,
                              int hp,
                              int defense) {
    this.turnsQueue = turnsQueue;
    this.name = name;
    this.hp = hp;
    this.defense = defense;
    this.isAlive = true;
  }



  /**
   * gets the name (String) of the Character
   */
  @Override
  public String getName() {
    return this.name;
  }

  /**
   * gets the name Hp of the Character
   */
  public int getHp(){
    return this.hp;
  }

  /**
   * gets the defense of the Character
   */
  public int getDef(){
    return this.defense;
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
   * gets the Weapon equipped by the Character
   */
  public IWeapon getEquippedWeapon() {
    return this.equippedWeapon;
  }


  /**
   * sets the health points
   */
  @Override
  public void setHp(int hp){
    if (hp <= 0){
      hp = 0;
      this.isAlive = false;
    }
    this.hp = hp;
  }

  public void setEquippedWeapon(IWeapon weapon){
    this.equippedWeapon = weapon;

  }

  @Override
  public boolean isAlive(){
    return this.isAlive;
  }

  @Override
  public void attackedBy(int damage){
    int damageDealt = damage - this.getDef();

    if(damageDealt < 0){
      damageDealt = 0;
    }
    this.setHp(this.getHp()-damageDealt);
  }



  @Override
  public void attack(ICharacter pj){
    pj.attackedBy(this.getAttack());
  }

  public abstract void equipWeapon(IWeapon weapon);

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

