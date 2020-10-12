package com.github.doragonUni.finalreality.model.character.player;

import com.github.doragonUni.finalreality.model.character.AbstractCharacter;
import com.github.doragonUni.finalreality.model.character.ICharacter;
import com.github.doragonUni.finalreality.model.weapon.Bow;
import com.github.doragonUni.finalreality.model.weapon.IWeapon;
import com.github.doragonUni.finalreality.model.weapon.Knife;
import com.github.doragonUni.finalreality.model.weapon.Sword;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Thief extends AbstractCharacter {


    /**
     * Creates a new character.
     *
     * @param name           the character's name
     * @param turnsQueue     the queue with the characters waiting for their turn
     *
     */


    public Thief(@NotNull String name, @NotNull BlockingQueue<ICharacter> turnsQueue) {
        super(turnsQueue, name);
    }


    public void equipSword(Sword sword) {
        this.equippedWeapon = sword;
    }

    public void equipBow(Bow bow) {
        this.equippedWeapon = bow;
    }

    public void equipKnife(Knife knife) { this.equippedWeapon = knife; }


    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Thief)) {
            return false;
        }
        final Thief that = (Thief) o;
        return getName().equals(that.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(Thief.class);
    }





}
