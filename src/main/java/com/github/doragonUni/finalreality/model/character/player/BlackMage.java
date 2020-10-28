package com.github.doragonUni.finalreality.model.character.player;

import com.github.doragonUni.finalreality.model.character.AbstractPlayerCharacter;
import com.github.doragonUni.finalreality.model.character.ICharacter;
import com.github.doragonUni.finalreality.model.weapon.AbstractWeapon;
import com.github.doragonUni.finalreality.model.weapon.IWeapon;
import com.github.doragonUni.finalreality.model.weapon.Knife;
import com.github.doragonUni.finalreality.model.weapon.Staff;
import org.jetbrains.annotations.NotNull;

import java.util.Base64;
import java.util.Objects;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class BlackMage extends AbstractPlayerCharacter {
    /**
     * Creates a new BlackMage
     *
     * @param name       the character's name
     * @param turnsQueue     the queue with the characters waiting for their turn
     * @param hp        this character's health points
     * @param defense    this character defense points
     * @param mana       mana value for this mage
     */

    private int mana;

    /**
     * Constructor of BlackMage
     */
    public BlackMage(@NotNull String name, @NotNull BlockingQueue<ICharacter> turnsQueue, int hp, int defense,
                     int mana) {
        super(turnsQueue, name, hp, defense);
        this.mana = mana;
    }


    @Override
    public void equipWeapon(IWeapon weapon) {
        if (this.getHp()>0) {
            weapon.equipToBlackMage(this);
        }
    }

    /**
     * get the Mana value of this Mage
     */
    public int getMana(){
        return this.mana;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof BlackMage)) {
            return false;
        }
        final BlackMage that = (BlackMage) o;
        return getName().equals(that.getName()) &&
                getHp() == that.getHp() &&
                getDef() == that.getDef() &&
                getMana() == that.getMana();
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(BlackMage.class);
    }


}


