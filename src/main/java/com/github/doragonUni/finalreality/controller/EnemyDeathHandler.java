package com.github.doragonUni.finalreality.controller;

import com.github.doragonUni.finalreality.model.character.Enemy;
import com.github.doragonUni.finalreality.model.character.ICharacter;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

/**
 * Handler for every Enemy's Death
 * @Params controller
 *
 */
public class EnemyDeathHandler implements IDeathHandler {
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
