package com.github.doragonUni.finalreality.controller.handlers;

import com.github.doragonUni.finalreality.controller.GameController;

import java.beans.PropertyChangeEvent;

public class TurnHandler implements IHandler {
    private final GameController controller;

    public TurnHandler(GameController controller) {
        this.controller = controller;
    }

    /**
     * notify every time a character enter to the Turns Queue
     * and try to begin a turn
     * @param evt
     */
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
            controller.tryToBeginTurn();
    }

}
