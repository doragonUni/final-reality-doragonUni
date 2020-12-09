package com.github.doragonUni.finalreality.model.weapon;

import com.github.doragonUni.finalreality.model.character.player.*;

public interface IWeapon {

    /**
     * get the Name for the Weapon
     */
    String getName();
    /**
     * get the Damage for the Weapon
     */
    int getDamage();
    /**
     * get the Weight for the Weapon
     */
    int getWeight();


    void equipToBlackMage(BlackMage blackMage);
    void equipToEngineer(Engineer engineer);
    void equipToKnight(Knight knight);
    void equipToThief(Thief thief);
    void equipToWhiteMage(WhiteMage WhiteMage);



}

