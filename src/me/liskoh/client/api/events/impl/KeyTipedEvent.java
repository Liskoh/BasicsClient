package me.liskoh.client.api.events.impl;

import lombok.Getter;
import lombok.Setter;
import me.liskoh.client.api.events.Event;

@Getter @Setter
public class KeyTipedEvent extends Event {

    private int key;

    public KeyTipedEvent(int key) {
        this.key = key;
    }

}
