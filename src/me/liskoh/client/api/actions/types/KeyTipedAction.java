package me.liskoh.client.api.actions.types;

import lombok.Getter;
import lombok.Setter;
import me.liskoh.client.api.actions.Action;

@Getter @Setter
public abstract class KeyTipedAction extends Action {

    public KeyTipedAction(int key) {
        this.key = key;
    }

    private int key;

}
