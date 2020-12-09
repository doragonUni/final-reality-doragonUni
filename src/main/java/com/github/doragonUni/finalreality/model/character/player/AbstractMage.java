package com.github.doragonUni.finalreality.model.character.player;

import com.github.doragonUni.finalreality.model.character.ICharacter;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.BlockingQueue;

public abstract class AbstractMage extends AbstractPlayerCharacter implements IMage {
    int mana;
    protected AbstractMage(@NotNull BlockingQueue<ICharacter> turnsQueue, String name, int hp, int defense, int mana) {
        super(turnsQueue, name, hp, defense);
        this.mana = mana;
    }

    /**
     * getter for the mage's mana point
     * @return
     */
    public int getMana(){
        return this.mana;
    }

}
