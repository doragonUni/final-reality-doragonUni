package com.github.doragonUni.finalreality.controller.phases;

public class WaitingPhase extends Phase{

    @Override
    public boolean isWaitingPhase(){
        return true;
    }

    @Override
    public void toTurnPhase(){
        changePhase(new TurnPhase());
    }







}
