package com.github.doragonUni.finalreality.model.character;


import com.github.doragonUni.finalreality.controller.IDeathHandler;
import org.jetbrains.annotations.NotNull;

import java.beans.PropertyChangeSupport;
import java.util.concurrent.BlockingQueue;

public abstract class AbstractCharacter  implements  ICharacter {

    private final String name;
    private int hp;
    private final int defense;
    private boolean isAlive;
    protected final BlockingQueue<ICharacter> turnsQueue;
    private final PropertyChangeSupport characterDeathEvent = new PropertyChangeSupport(this);

    public AbstractCharacter(@NotNull BlockingQueue<ICharacter> turnsQueue, String name, int hp, int defense) {
        this.turnsQueue = turnsQueue;
        this.name = name;
        this.hp = hp;
        this.defense = defense;
        this.isAlive = true;
    }

    @Override
    public abstract void waitTurn();

    @Override
    public abstract void addToQueue();

    @Override
    public abstract int getAttack();


    /**
     * get's the name of this Character
     * @return
     */
    @Override
    public String getName() {
        return this.name;
    }

    /**
     * gets the name Hp of the Character
     */
    @Override
    public int getHp(){
        return this.hp;
    }

    /**
     * gets the defense of the Character
     */
    @Override
    public int getDef(){
        return this.defense;
    }

    /**
     * verify if this character is alive or nto
     * @return
     */
    @Override
    public boolean isAlive(){
        return this.isAlive;
    }

    /**
     * this attacks to a target (pj)
     * @param pj
     */
    @Override
    public void attack(ICharacter pj){
        pj.attackedBy(this);
    }

    /**
     * double dispatch for the attack method
     * @param character
     */
    @Override
    public void attackedBy(ICharacter character){

        int damageDealt = character.getAttack() - this.getDef();

        if(damageDealt < 0){
            damageDealt = 0;
        }
        this.setHp(this.getHp()-damageDealt);
    }

    /**
     * set's the healthpoint of the character
     * @param hp
     */
    @Override
    public void setHp(int hp){
        if (hp <= 0){
            hp = 0;
            characterDeathEvent.firePropertyChange("Dead Character: " + name, null, this);
            this.isAlive = false;
        }
        this.hp = hp;
    }

    /**
     * adds a listener for the dead event
     * @param handler
     */
    public void addDeathListener(IDeathHandler handler){
        characterDeathEvent.addPropertyChangeListener(handler);
    }



}
