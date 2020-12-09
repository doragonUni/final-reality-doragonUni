package com.github.doragonUni.finalreality.model.character.player;

import com.github.doragonUni.finalreality.model.character.ICharacter;
import com.github.doragonUni.finalreality.model.weapon.IWeapon;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;
import java.util.concurrent.BlockingQueue;

public class WhiteMage extends AbstractMage {
    /**
     * Creates a new WhiteMage.
     *
     * @param name       the character's name
     * @param turnsQueue the queue with the characters waiting for their turn
     * @param hp         this character's health points
     * @param defense    this character defense points
     * @param mana       mana value for this mage
     */


    public WhiteMage(@NotNull String name, @NotNull BlockingQueue<ICharacter> turnsQueue, int hp, int defense,
                     int mana) {
        super(turnsQueue, name, hp, defense, mana);

    }



    @Override
    public void equipWeapon(IWeapon weapon) {
        if (this.isAlive()) {
            weapon.equipToWhiteMage(this);
        }
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
