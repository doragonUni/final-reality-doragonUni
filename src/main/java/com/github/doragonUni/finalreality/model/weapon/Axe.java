package com.github.doragonUni.finalreality.model.weapon;

import java.util.Objects;

public class Axe extends AbstractWeapon {
    /**
     * Creates a weapon with a name, a base damage, speed and (it's type).
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


}
