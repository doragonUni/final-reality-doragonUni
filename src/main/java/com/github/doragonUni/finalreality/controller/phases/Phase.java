package com.github.doragonUni.finalreality.controller.phases;

import com.github.doragonUni.finalreality.controller.GameController;
import com.github.doragonUni.finalreality.model.character.ICharacter;
import com.github.doragonUni.finalreality.model.character.player.IPlayerCharacter;
import com.github.doragonUni.finalreality.model.weapon.IWeapon;

public class Phase {
    protected GameController controller;

    public void setController(GameController controller){
        this.controller = controller;
    }

    protected void changePhase(Phase phase){
        controller.setPhase(phase);
    }

    public void toWaitingPhase()  {

    }

   public void toSelectPhase(){

   }


    public void toTurnPhase()  {

    }

    public void toMatchOverPhase(){

    }

    public void tryAttack(ICharacter attacker, ICharacter target) {

    }
    public void tryBeginTurn(){

    }
    public void tryEquip(IWeapon weapon, IPlayerCharacter player){

    }

    public boolean isTurnPhase(){return false;}
    public boolean isWaitingPhase(){return false;}
    public boolean isSetUpPhase(){
        return false;
    }



}
