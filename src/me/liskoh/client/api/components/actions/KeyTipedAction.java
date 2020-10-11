package me.liskoh.client.api.components.actions;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public abstract class KeyTipedAction extends Action{

    public KeyTipedAction(int key) {
        this.key = key;
    }

    private int key;

}
