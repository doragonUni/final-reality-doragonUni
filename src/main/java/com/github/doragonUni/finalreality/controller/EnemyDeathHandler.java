package com.github.doragonUni.finalreality.controller;

import com.github.doragonUni.finalreality.model.character.Enemy;
import com.github.doragonUni.finalreality.model.character.ICharacter;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class EnemyDeathHandler implements IDeathHandler {
    private final GameController controller;

    public EnemyDeathHandler(GameController controller) {
        this.controller = controller;
    }
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        controller.enemyDeathNotification((Enemy) evt.getNewValue());
    }

}
