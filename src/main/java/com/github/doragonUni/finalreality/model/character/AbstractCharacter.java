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


    @Override
    public boolean isAlive(){
        return this.isAlive;
    }

    @Override
    public void attack(ICharacter pj){
        pj.attackedBy(this);
    }

    @Override
    public void attackedBy(ICharacter character){

        int damageDealt = character.getAttack() - this.getDef();

        if(damageDealt < 0){
            damageDealt = 0;
        }
        this.setHp(this.getHp()-damageDealt);
    }


    @Override
    public void setHp(int hp){
        if (hp <= 0){
            hp = 0;
            characterDeathEvent.firePropertyChange("Dead Character: " + name, null, this);
            this.isAlive = false;
        }
        this.hp = hp;
    }


    public void addDeathListener(IDeathHandler handler){
        characterDeathEvent.addPropertyChangeListener(handler);
    }



}
