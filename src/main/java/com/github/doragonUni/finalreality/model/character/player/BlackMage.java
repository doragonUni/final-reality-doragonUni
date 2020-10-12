package com.github.doragonUni.finalreality.model.character.player;

import com.github.doragonUni.finalreality.model.character.AbstractCharacter;
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

public class BlackMage extends AbstractCharacter {
    /**
     * Creates a new character.
     *
     * @param name       the character's name
     * @param turnsQueue the queue with the characters waiting for their turn
     */

    private int mana;


    public BlackMage(@NotNull String name, @NotNull BlockingQueue<ICharacter> turnsQueue, int mana) {
        super(turnsQueue, name);
        this.mana = mana;
    }

    public void equipStaff(Staff staff) {
        this.equippedWeapon = staff;
    }

    public void equipKnife(Knife knife) {
        this.equippedWeapon = knife;
    }

    public int getMana(){
        return mana;
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
                getMana() == that.getMana();
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(BlackMage.class);
    }


}


