package com.github.doragonUni.finalreality.controller.phases;

import com.github.doragonUni.finalreality.model.character.player.IPlayerCharacter;
import com.github.doragonUni.finalreality.model.weapon.IWeapon;

public class LoadingPhase extends Phase {


    /**
     * boolean to check wheather is setup phase or not
     * @return
     */
    @Override
    public boolean isSetUpPhase(){
        return true;
    }

    /**
     * change the phase to waiting phase
     * @return
     */
    @Override
    public void toWaitingPhase(){
        changePhase(new WaitingPhase());
    }

    /**
     * try to equip a weapon calling the controller method equipWeaponInventory
     * @param weapon
     * @param player
     */
    @Override
    public void tryEquip(IWeapon weapon, IPlayerCharacter player){
        controller.equipWeaponInventory(weapon, player);
    }

}
