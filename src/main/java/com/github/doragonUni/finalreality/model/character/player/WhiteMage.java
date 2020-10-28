package com.github.doragonUni.finalreality.model.character.player;

import com.github.doragonUni.finalreality.model.character.AbstractPlayerCharacter;
import com.github.doragonUni.finalreality.model.character.ICharacter;
import com.github.doragonUni.finalreality.model.weapon.IWeapon;
import com.github.doragonUni.finalreality.model.weapon.Staff;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class WhiteMage  extends AbstractPlayerCharacter {
    /**
     * Creates a new WhiteMage.
     *
     * @param name       the character's name
     * @param turnsQueue the queue with the characters waiting for their turn
     * @param hp         this character's health points
     * @param defense    this character defense points
     * @param mana       mana value for this mage
     */

    private int mana;

    public WhiteMage(@NotNull String name, @NotNull BlockingQueue<ICharacter> turnsQueue, int hp, int defense,
                     int mana) {
        super(turnsQueue, name, hp, defense);
        this.mana = mana;
    }


    /**
     *
     */
    @Override
    public void equipWeapon(IWeapon weapon) {
        if (this.isAlive()) {
            weapon.equipToWhiteMage(this);
        }
    }

    /**
     * get the Mana value of this WhiteMage
     */
    public int getMana(){
        return this.mana;
    }



    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof WhiteMage)) {
            return false;
        }
        final WhiteMage that = (WhiteMage) o;
        return getName().equals(that.getName()) &&
                getHp() == that.getHp() &&
                getDef() == that.getDef() &&
                getMana() == that.getMana();
    }
    @Override
    public int hashCode() {
        return Objects.hashCode(WhiteMage.class);
    }


}
