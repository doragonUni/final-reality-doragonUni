package com.github.doragonUni.finalreality.controller.phases;

public class WaitingPhase extends Phase{

    @Override
    public void toTurnPhase(){
        changePhase(new TurnPhase());
    }


    @Override
    public boolean isWaitingPhase(){
        return true;
    }

    @Override
    public void tryBeginTurn(){
        toTurnPhase();
        controller.characterTurn();
    }




}
