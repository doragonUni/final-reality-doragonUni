package com.github.doragonUni.finalreality.model.weapon;

import com.github.doragonUni.finalreality.model.character.player.*;

import java.util.Objects;

public class Sword extends AbstractWeapon {
    /**
     * Creates a Sword with a name, a base damage, speed and (it's type).
     *
     * @param name
     *          weapon's name
     * @param damage
     *          weapon's dmg
     * @param weight
     *          weapon's "speed"
     *
     */
    public Sword(String name, int damage, int weight) {
        super(name, damage, weight);
    }

    /**
     * double dispatch for equipping weapons
     */
    @Override
    public void equipToKnight(Knight knight) {
        knight.setEquippedWeapon(this);
    }
    /**
     * double dispatch for equipping weapons
     */
    @Override
    public void equipToThief(Thief thief) {
        thief.setEquippedWeapon(this);
    }




    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Sword)) {
            return false;
        }
        final Sword sword = (Sword) o;
        return getDamage() == sword.getDamage() &&
                getWeight() == sword.getWeight() &&
                getName().equals(sword.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(Sword.class);
    }
}
