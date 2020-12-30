package com.github.doragonUni.finalreality.model.character.player;

import com.github.doragonUni.finalreality.model.character.ICharacter;
import com.github.doragonUni.finalreality.model.weapon.IWeapon;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;
import java.util.concurrent.BlockingQueue;

public class BlackMage extends AbstractMage {
    /**
     * Creates a new BlackMage
     *
     * @param name       the character's name
     * @param turnsQueue     the queue with the characters waiting for their turn
     * @param hp        this character's health points
     * @param defense    this character defense points
     * @param mana       mana value for this mage
     */

    /**
     * Constructor of BlackMage
     */
    public BlackMage(@NotNull String name, @NotNull BlockingQueue<ICharacter> turnsQueue, int hp, int defense,
                     int mana) {
        super(turnsQueue, name, hp, defense, mana);
        this.mana = mana;
    }

    /**
     *equip a weapon to this BlackMAGE
     */
    @Override
    public void equipWeapon(IWeapon weapon) {
        if (this.isAlive()) {
            weapon.equipToBlackMage(this);
        }
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


