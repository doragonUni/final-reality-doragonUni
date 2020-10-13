package com.github.doragonUni.finalreality.model.character.player;

import com.github.doragonUni.finalreality.model.character.AbstractCharacter;
import com.github.doragonUni.finalreality.model.character.ICharacter;
import com.github.doragonUni.finalreality.model.weapon.Axe;
import com.github.doragonUni.finalreality.model.weapon.Bow;
import com.github.doragonUni.finalreality.model.weapon.IWeapon;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Engineer extends AbstractCharacter {
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
     * equip a Bow to This Engineer
     */
    public void equipBow(Bow bow) {
        this.equippedWeapon = bow;
    }
    /**
     * equip an Axe to this Engineer
     */
    public void equipAxe(Axe axe) {
        this.equippedWeapon = axe;
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



