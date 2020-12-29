package com.github.doragonUni.finalreality.model.weapon;

import com.github.doragonUni.finalreality.model.character.player.*;

import java.util.Objects;

public class Knife extends AbstractWeapon {
    /**
     * Creates a Knife with a name, a base damage, speed and (it's type).
     *
     * @param name
     *          weapon's name
     * @param damage
     *          weapon's dmg
     * @param weight
     *          weapon's "speed"
     *
     */
    public Knife(String name, int damage, int weight) {

        super(name, damage, weight);
    }

    /**
     * double dispatch for equipping weapons
     * @param BlackMage
     */
    @Override
    public void equipToBlackMage(BlackMage blackMage) {
        blackMage.setEquippedWeapon(this);
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
        if (!(o instanceof Knife)) {
            return false;
        }
        final Knife knife = (Knife) o;
        return getDamage() == knife.getDamage() &&
                getWeight() == knife.getWeight() &&
                getName().equals(knife.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(Knife.class);
    }
}
