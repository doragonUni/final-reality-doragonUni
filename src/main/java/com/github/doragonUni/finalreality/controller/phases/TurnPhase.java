package com.github.doragonUni.finalreality.controller.phases;

public class TurnPhase extends Phase{


    @Override
    public void toSelectPhase(){
        changePhase(new SelectPhase());
    }

    @Override
    public boolean isTurnPhase(){
        return true;
    }




}
