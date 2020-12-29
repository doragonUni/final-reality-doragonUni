package com.github.doragonUni.finalreality.controller.phases;

import com.github.doragonUni.finalreality.model.character.ICharacter;
import com.github.doragonUni.finalreality.model.character.player.IPlayerCharacter;
import com.github.doragonUni.finalreality.model.weapon.IWeapon;

public class SelectPhase extends Phase {
    /**
     * changes the phase to Waiting Phase
     */
    @Override
    public void toWaitingPhase(){
        changePhase(new WaitingPhase());
    }


    /**
     * changes the phase to Win Phase
     */
    @Override
    public void toWinPhase(){ changePhase( new WinPhase());}
    /**
     * changes the phase to Lose Phase
     */
    @Override
    public void toLosePhase(){ changePhase( new LosePhase());}



    /**
     * call the  attack method from controller trying to do the action
     */
    @Override
    public void tryAttack(ICharacter attacker, ICharacter target){
        controller.controllerAttack(attacker, target);
    }

    /**
     * call the  equipWeaponInventory method from controller trying to do the action
     */
    @Override
    public void tryEquip(IWeapon weapon, IPlayerCharacter player){
        controller.equipWeaponInventory(weapon, player);
    }


}


