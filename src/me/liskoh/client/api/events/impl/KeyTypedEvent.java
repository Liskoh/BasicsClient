package me.liskoh.client.api.events.impl;

import lombok.Getter;
import lombok.Setter;
import me.liskoh.client.api.events.Event;

@Getter @Setter
public class KeyTypedEvent extends Event {

    private int key;

    public KeyTypedEvent(int key) {
        this.key = key;
    }

}
