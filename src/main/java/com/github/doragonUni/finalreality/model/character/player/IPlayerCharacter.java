package com.github.doragonUni.finalreality.model.character.player;

import com.github.doragonUni.finalreality.model.character.ICharacter;
import com.github.doragonUni.finalreality.model.weapon.IWeapon;

public interface IPlayerCharacter extends ICharacter {
    /**
     * equip a weapon to the character
     * @param weapon
     */
    void equipWeapon(IWeapon weapon);
    /**
     * get the  weapon to the character
     */
    IWeapon getEquippedWeapon();

    /**
     * sets the equpped weapon
     * @param weapon
     */
    void setEquippedWeapon(IWeapon weapon);

    /**
     * get the Weapon Name
     * @return
     */
    String getWeaponName();

}
