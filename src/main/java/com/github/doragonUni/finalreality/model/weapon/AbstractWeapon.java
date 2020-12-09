package com.github.doragonUni.finalreality.model.weapon;

import com.github.doragonUni.finalreality.model.character.player.*;

/**
 * An abstract class that holds the common behaviour of all the Weapons in the game.
 *
 * @author Ignacio Slater Muñoz.
 * @author <Your name>
 */
public abstract class AbstractWeapon implements IWeapon {
    /**
     * @param name       weapon's name
     * @param damage  it's damage
     * @param weight     it's weight (speed)
     */
    private final String name;
    private final int damage;
    private final int weight;

    protected AbstractWeapon(String name, int damage, int weight) {
        this.name = name;
        this.damage = damage;
        this.weight = weight;
    }

    /**
     * gets the Weapon's Name
     */
    @Override
    public String getName(){
        return this.name;
    }
    /**
     * gets the Weapon's damage
     */
    @Override
    public int getDamage(){
        return this.damage;
    }
    /**
     *gets the Weapon's Weight
     */
    @Override
    public int getWeight(){
        return this.weight;
    }

    @Override
    public void equipToBlackMage(BlackMage blackMage){

    }
    @Override
    public void equipToEngineer(Engineer engineer){
    }
    @Override
    public void equipToKnight(Knight knight){

    }
    @Override
    public void equipToThief(Thief thief){

    }
    @Override
    public void equipToWhiteMage(WhiteMage whiteMage){

    }


}
