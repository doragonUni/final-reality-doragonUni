package com.github.doragonUni.finalreality.controller.phases;

import com.github.doragonUni.finalreality.model.character.ICharacter;
import com.github.doragonUni.finalreality.model.character.player.IPlayerCharacter;
import com.github.doragonUni.finalreality.model.weapon.IWeapon;

public class SelectPhase extends Phase {

    @Override
    public void toWaitingPhase(){
        changePhase(new WaitingPhase());
    }



    @Override
    public void toMatchOverPhase(){ changePhase( new MatchOverPhase());}


    @Override
    public void tryAttack(ICharacter attacker, ICharacter target){
        controller.controllerAttack(attacker, target);
    }

    @Override
    public void tryEquip(IWeapon weapon, IPlayerCharacter player){
        controller.equipWeaponInventory(weapon, player);
    }
}
