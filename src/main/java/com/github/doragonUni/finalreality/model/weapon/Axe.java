package com.github.doragonUni.finalreality.model.weapon;

import com.github.doragonUni.finalreality.model.character.player.*;

import java.util.Objects;

public class Axe extends AbstractWeapon {
    /**
     * Creates an Axe with a name, a base damage, speed and (it's type).
     *
     * @param name
     *          weapon's name
     * @param damage
     *          weapon's dmg
     * @param weight
     *          weapon's "speed"
     *
     */


    public Axe(final String name, final int damage, final int weight) {

        super(name, damage, weight);
    }



    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Axe)) {
            return false;
        }
        final Axe axe = (Axe) o;
        return getDamage() == axe.getDamage() &&
                getWeight() == axe.getWeight() &&
                getName().equals(axe.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(Axe.class);
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
        knight.setEquippedWeapon(this);
    }

    @Override
    public void equipToThief(Thief thief) {
        return;
    }

    @Override
    public void equipToWhiteMage(WhiteMage WhiteMage) {
        return;
    }
}
