package com.github.doragonUni.finalreality.controller;

import com.github.doragonUni.finalreality.model.character.ICharacter;
import com.github.doragonUni.finalreality.model.character.player.IPlayerCharacter;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class PlayerDeathHandler implements IDeathHandler {
    private final GameController controller;

    public PlayerDeathHandler(GameController controller) {
        this.controller = controller;
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        controller.playerDeathNotification((IPlayerCharacter) evt.getNewValue());
    }

}
