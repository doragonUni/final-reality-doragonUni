package com.github.doragonUni.finalreality.controller.phases;

import com.github.doragonUni.finalreality.controller.GameController;
import com.github.doragonUni.finalreality.model.character.ICharacter;
import com.github.doragonUni.finalreality.model.character.player.IPlayerCharacter;
import com.github.doragonUni.finalreality.model.weapon.IWeapon;

public class Phase {
    protected GameController controller;

    /**
     * sets the controller to this phase
     * @param controller
     */
    public void setController(GameController controller){
        this.controller = controller;
    }

    /**
     * changes this phase
     * @param phase
     */
    protected void changePhase(Phase phase){
        controller.setPhase(phase);
    }

    /**
     * if is in the right phase this method changes the phase to waiting phase
     */
    public void toWaitingPhase()  {

    }

    /**
     * if is in the right phase this method changes the phase to select phase
     */
   public void toSelectPhase(){

   }

    /**
     * if is in the right phase this method changes the phase to Turn phase
     */
    public void toTurnPhase()  {

    }

    /**
     * if is in the right phase this method changes the phase to win phase
     */
    public void toWinPhase(){

    }

    /**
     * if is in the right phase this method changes the phase to lose phase
     */
    public void toLosePhase(){

    }

    /**
     * if is in the right phase this method try to call the attack method from the controller
     */
    public void tryAttack(ICharacter attacker, ICharacter target) {

    }


    /**
     * if is in the right phase this method try to equip a weapon calling the controller method
     */
    public void tryEquip(IWeapon weapon, IPlayerCharacter player){

    }

    /**
     * verify whether or not is in Turn Phase
     */
    public boolean isTurnPhase(){return false;}
    /**
     * verify whether or not is in Waiting Phase
     */
    public boolean isWaitingPhase(){return false;}
    /**
     * erify whether or not is in setup Phase
     */
    public boolean isSetUpPhase(){
        return false;
    }




}
