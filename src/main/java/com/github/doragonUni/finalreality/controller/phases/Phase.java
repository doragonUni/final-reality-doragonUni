package com.github.doragonUni.finalreality.controller.phases;

import com.github.doragonUni.finalreality.controller.GameController;

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



    public boolean isWaitingPhase(){
        return false;
    }
    public boolean isTurnPhase(){
        return false;
    }
    public boolean isSetUpPhase(){
        return false;
    }
    public boolean isSelectPhase(){return false;}


}
