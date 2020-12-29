package com.github.doragonUni.finalreality.controller.phases;

public class WaitingPhase extends Phase{
    /**
     * changes the phase to Turn Phase
     */
    @Override
    public void toTurnPhase(){
        changePhase(new TurnPhase());
    }

    /**
     * return true if the current phase is this
     */
    @Override
    public boolean isWaitingPhase(){
        return true;
    }





}
