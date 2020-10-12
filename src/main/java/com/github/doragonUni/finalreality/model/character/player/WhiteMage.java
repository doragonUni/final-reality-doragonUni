package com.github.doragonUni.finalreality.model.character.player;

import com.github.doragonUni.finalreality.model.character.AbstractCharacter;
import com.github.doragonUni.finalreality.model.character.ICharacter;
import com.github.doragonUni.finalreality.model.weapon.IWeapon;
import com.github.doragonUni.finalreality.model.weapon.Staff;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class WhiteMage  extends AbstractCharacter {
    /**
     * Creates a new character.
     *
     * @param name       the character's name
     * @param turnsQueue
     * @param mana
     */

    private int mana;

    public WhiteMage(@NotNull String name, @NotNull BlockingQueue<ICharacter> turnsQueue, int mana) {
        super(turnsQueue, name);
        this.mana = mana;
    }

    public void equipStaff(Staff staff) {
        this.equippedWeapon = staff;
    }

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
                getMana() == that.getMana();

    }
    @Override
    public int hashCode() {
        return Objects.hashCode(WhiteMage.class);
    }

}
