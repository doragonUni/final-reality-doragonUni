package com.github.doragonUni.finalreality.controller.handlers;

import com.github.doragonUni.finalreality.controller.GameController;

import java.beans.PropertyChangeEvent;

public class TurnHandler implements IHandler {
    private final GameController controller;

    public TurnHandler(GameController controller) {
        this.controller = controller;
    }


    @Override
    public void propertyChange(PropertyChangeEvent evt) {
            controller.tryToBeginTurn();
    }

}
