package com.github.doragonUni.finalreality.model.character.player;

import com.github.doragonUni.finalreality.model.character.ICharacter;
import com.github.doragonUni.finalreality.model.weapon.IWeapon;

public interface IPlayerCharacter extends ICharacter {

    void equipWeapon(IWeapon weapon);
    IWeapon getEquippedWeapon();
    void setEquippedWeapon(IWeapon weapon);

}
