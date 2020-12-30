package com.github.doragonUni.finalreality.controller.phases;

public class TurnPhase extends Phase{

    /**
     * changes the phase to Lose Phase
     */
    @Override
    public void toSelectPhase(){
        changePhase(new SelectPhase());
    }

    /**
     * return true if the controller current phase is this
     */
    @Override
    public boolean isTurnPhase(){return true;}




}
