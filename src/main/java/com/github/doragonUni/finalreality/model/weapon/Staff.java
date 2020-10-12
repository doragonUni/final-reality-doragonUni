package com.github.doragonUni.finalreality.model.weapon;

import java.util.Objects;

public class Staff extends AbstractWeapon {
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

    private final int magicDamage ;

    public Staff(String name, int damage, int weight, int magicDamage) {
        super(name, damage, weight);
        this.magicDamage = magicDamage;
    }

    public int getMagicDamage(){
        return magicDamage;
    }


    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Staff)) {
            return false;
        }
        final Staff staff = (Staff) o;
        return getDamage() == staff.getDamage() &&
                getWeight() == staff.getWeight() &&
                getMagicDamage() == staff.getMagicDamage() &&
                getName().equals(staff.getName());
    }


    public int hashCode() {
        return Objects.hash(getName(), getDamage(), getWeight(), getMagicDamage());
    }
}
