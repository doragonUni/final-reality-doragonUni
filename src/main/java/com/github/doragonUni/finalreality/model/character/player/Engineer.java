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
     * Creates a new character.
     *
     * @param name       the character's name
     * @param turnsQueue
     */





    public Engineer(@NotNull String name, @NotNull BlockingQueue<ICharacter> turnsQueue) {
        super(turnsQueue, name);
    }

    public void equipBow(Bow bow) {
        this.equippedWeapon = bow;
    }

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
        return getName().equals(that.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(Engineer.class);
    }


}



