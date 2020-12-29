package com.github.doragonUni.finalreality.controller.handlers;

import com.github.doragonUni.finalreality.controller.GameController;
import com.github.doragonUni.finalreality.model.character.Enemy;

import java.beans.PropertyChangeEvent;

/**
 * Handler for every Enemy's Death
 * @Params controller
 *
 */
public class EnemyDeathHandler implements IHandler {
    private final GameController controller;

    public EnemyDeathHandler(GameController controller) {
        this.controller = controller;
    }

    /**
     * Notify to the controller every time an enemy is death
     * @param evt
     */
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        controller.enemyDeathNotification((Enemy) evt.getNewValue());
    }

}
