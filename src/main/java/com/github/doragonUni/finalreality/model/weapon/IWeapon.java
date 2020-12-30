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

    /**
     * double dispatch for equipping weapons
     * @param BlackMage
     */
    void equipToBlackMage(BlackMage blackMage);
    /**
     * double dispatch for equipping weapons
     * @param Engineer
     */
    void equipToEngineer(Engineer engineer);
    /**
     * double dispatch for equipping weapons
     * @param Knight
     */
    void equipToKnight(Knight knight);
    /**
     * double dispatch for equipping weapons
     * @param Thief
     */
    void equipToThief(Thief thief);
    /**
     * double dispatch for equipping weapons
     * @param WhiteMage
     */
    void equipToWhiteMage(WhiteMage WhiteMage);




}

