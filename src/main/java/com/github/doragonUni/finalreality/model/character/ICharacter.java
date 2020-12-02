package com.github.doragonUni.finalreality.model.character;

/**
 * This represents a character from the game.
 * A character can be controlled by the player or by the CPU (an enemy).
 *
 * @author Ignacio Slater Muñoz.
 * @author <Your name>
 */
public interface ICharacter {

  /**
   * Sets a scheduled executor to make this character (thread) wait for {@code speed / 10}
   * seconds before adding the character to the queue.
   */
  void waitTurn();
  /**
   * add an ICharacter to the Queue
   */
  void addToQueue();
  /**
   * get the HP of the character
   */
  int getHp();
  /**
   *  get the Defense of the character
   */
  int getDef();
  /**
   * Returns this character's name.
   */
  String getName();

  /**
   *get this character attack points
   */
  int getAttack();

  boolean isAlive();
  /**
   * sets this character health points
   */

  void attackedBy(ICharacter character);

  void attack(ICharacter pj);
  

  void setHp(int hp);



}

