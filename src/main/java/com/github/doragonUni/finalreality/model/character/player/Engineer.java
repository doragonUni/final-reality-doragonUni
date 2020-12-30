package com.github.doragonUni.finalreality.model.character.player;

import com.github.doragonUni.finalreality.model.character.ICharacter;
import com.github.doragonUni.finalreality.model.weapon.IWeapon;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;
import java.util.concurrent.BlockingQueue;

public class Engineer extends AbstractPlayerCharacter {
    /**
     * Creates a new Engineer.
     *
     * @param name       the character's name
     * @param turnsQueue     the queue with the characters waiting for their turn
     * @param hp        this character's health points
     * @param defense    this character defense points
     */

    public Engineer(@NotNull String name, @NotNull BlockingQueue<ICharacter> turnsQueue, int hp, int defense) {
        super(turnsQueue, name, hp, defense);
    }

    /**
     *equip a weapon to this Engineer
     */
    @Override
    public void equipWeapon(IWeapon weapon) {
        if (this.isAlive()) {
            weapon.equipToEngineer(this);

        }
    }


    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Engineer)) {
            return false;
        }
        final Engineer that = (Engineer) o;
        return getName().equals(that.getName()) &&
                getHp() == that.getHp() &&
                getDef() == that.getDef();
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(Engineer.class);
    }


}



