package com.github.doragonUni.finalreality.controller.phases;

import com.github.doragonUni.finalreality.model.character.player.IPlayerCharacter;
import com.github.doragonUni.finalreality.model.weapon.IWeapon;

public class LoadingPhase extends Phase {



    @Override
    public boolean isSetUpPhase(){
        return true;
    }

    @Override
    public void toWaitingPhase(){
        changePhase(new WaitingPhase());
    }

    @Override
    public void tryEquip(IWeapon weapon, IPlayerCharacter player){
        controller.equipWeaponInventory(weapon, player);
    }

}
