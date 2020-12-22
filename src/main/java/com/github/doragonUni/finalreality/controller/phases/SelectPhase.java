package com.github.doragonUni.finalreality.controller.phases;

public class SelectPhase extends Phase {

    @Override
    public void toWaitingPhase(){
        changePhase(new WaitingPhase());
    }

    @Override
    public boolean isSelectPhase(){
        return true;
    }

    @Override
    public void toMatchOverPhase(){ changePhase( new MatchOverPhase());}
}
