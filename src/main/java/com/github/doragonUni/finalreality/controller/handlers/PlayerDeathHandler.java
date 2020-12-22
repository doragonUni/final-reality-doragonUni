package com.github.doragonUni.finalreality.controller.handlers;

import com.github.doragonUni.finalreality.controller.GameController;
import com.github.doragonUni.finalreality.controller.handlers.IHandler;

import java.beans.PropertyChangeEvent;


/**
 * Handler for every PlayerChracter's Death
 * @Params controller
 *
 */
public class PlayerDeathHandler implements IHandler {
    private final GameController controller;

    public PlayerDeathHandler(GameController controller) {
        this.controller = controller;
    }

    /**
     * Notify to the controller every time an enemy is death
     * @param evt
     */
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        controller.playerDeathNotification();
    }

}
