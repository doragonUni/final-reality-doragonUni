package com.github.doragonUni.finalreality.controller;

import com.github.doragonUni.finalreality.model.character.ICharacter;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class DeathHandler implements PropertyChangeListener {
    private final GameController controller;

    public DeathHandler(GameController controller) {
        this.controller = controller;
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        controller.deadNotification((ICharacter) evt.getNewValue());
    }

}
