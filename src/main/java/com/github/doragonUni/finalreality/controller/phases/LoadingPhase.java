package com.github.doragonUni.finalreality.controller.phases;

public class LoadingPhase extends Phase {



    @Override
    public boolean isSetUpPhase(){
        return true;
    }

    @Override
    public void toWaitingPhase(){
        changePhase(new WaitingPhase());
    }

}
