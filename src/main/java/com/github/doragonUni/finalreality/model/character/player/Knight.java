package com.github.doragonUni.finalreality.model.character.player;

import com.github.doragonUni.finalreality.model.character.AbstractCharacter;
import com.github.doragonUni.finalreality.model.character.ICharacter;
import com.github.doragonUni.finalreality.model.weapon.Axe;
import com.github.doragonUni.finalreality.model.weapon.IWeapon;
import com.github.doragonUni.finalreality.model.weapon.Knife;
import com.github.doragonUni.finalreality.model.weapon.Sword;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Knight extends AbstractCharacter {
    /**
     * Creates a new Knight.
     *
     * @param name       the character's name
     * @param turnsQueue     the queue with the characters waiting for their turn
     * @param hp        this character's health points
     * @param defense    this character defense points
     */





    public Knight(@NotNull String name, @NotNull BlockingQueue<ICharacter> turnsQueue, int hp, int defense) {
        super(turnsQueue, name, hp, defense);

    }

    /**
     * equip an Axe to this Knight
     */
    public void equipAxe(Axe axe) {
        this.equippedWeapon = axe;
    }
    /**
     * equip a Sword to this Knight
     */
    public void equipSword(Sword sword) {
        this.equippedWeapon = sword;
    }
    /**
     * equip a Knife to this Knight
     */
    public void equipKnife(Knife knife) {
        this.equippedWeapon = knife;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Knight)) {
            return false;
        }
        final Knight that = (Knight) o;
        return getName().equals(that.getName()) &&
                getHp() == that.getHp() &&
                getDef() == that.getDef();
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(Knight.class);
    }


}
