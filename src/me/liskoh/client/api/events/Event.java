package me.liskoh.client.api.events;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Event {

    private boolean cancelled;

    public Event() {
        cancelled = false;
    }

}
