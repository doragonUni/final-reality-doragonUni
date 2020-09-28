package com.github.doragonUni.finalreality.model.character;

import com.github.doragonUni.finalreality.model.character.player.CharacterClass;
import com.github.doragonUni.finalreality.model.character.player.PlayerCharacter;
import com.github.doragonUni.finalreality.model.weapon.Weapon;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import org.jetbrains.annotations.NotNull;

/**
 * An abstract class that holds the common behaviour of all the characters in the game.
 *
 * @author Ignacio Slater Muñoz.
 * @author <Your name>
 */
public abstract class AbstractCharacter implements ICharacter {

  protected final BlockingQueue<ICharacter> turnsQueue;
  protected final String name;
  private final CharacterClass characterClass;
  //private Weapon equippedWeapon = null; down to playercharacter
  protected ScheduledExecutorService scheduledExecutor;

  protected AbstractCharacter(@NotNull BlockingQueue<ICharacter> turnsQueue,
                              @NotNull String name, CharacterClass characterClass) {
    this.turnsQueue = turnsQueue;
    this.name = name;
    this.characterClass = characterClass;
  }

 //wait durn divided into enemy and playerChARACTER

  /**
   * Adds this character to the turns queue.
   */
  protected void addToQueue() {
    turnsQueue.add(this);
    scheduledExecutor.shutdown();
  }

  @Override
  public String getName() {
    return name;
  }

  //void equipWeapon down to player character
  // weapon getEquippedWeapon DOWN TO PLAYERCHARACTER


  @Override
  public CharacterClass getCharacterClass() {
    return characterClass;
  }
}

