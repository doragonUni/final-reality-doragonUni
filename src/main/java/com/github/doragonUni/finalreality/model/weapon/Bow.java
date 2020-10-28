package com.github.doragonUni.finalreality.model.weapon;

import com.github.doragonUni.finalreality.model.character.player.*;

import java.util.Objects;

public class Bow extends AbstractWeapon {
    /**
     * Creates a Bow with a name, a base damage, speed and (it's type).
     *
     * @param name
     *          weapon's name
     * @param damage
     *          weapon's dmg
     * @param weight
     *          weapon's "speed"
     *
     */
    public Bow(String name, int damage, int weight) {
        super(name, damage, weight);
    }

    @Override
    public void equipToBlackMage(BlackMage blackMage) {
        return;
    }

    @Override
    public void equipToEngineer(Engineer engineer) {
        engineer.setEquippedWeapon(this);
    }

    @Override
    public void equipToKnight(Knight knight) {
        return;
    }

    @Override
    public void equipToThief(Thief thief) {
        thief.setEquippedWeapon(this);
    }

    @Override
    public void equipToWhiteMage(WhiteMage WhiteMage) {
        return;
    }


    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Bow)) {
            return false;
        }
        final Bow bow = (Bow) o;
        return getDamage() == bow.getDamage() &&
                getWeight() == bow.getWeight() &&
                getName().equals(bow.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(Bow.class);
    }



}
