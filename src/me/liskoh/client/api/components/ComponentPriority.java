package me.liskoh.client.api.components;

import lombok.Getter;

@Getter
public enum ComponentPriority {


    LOWER(-1),
    DEFAULT(0),
    BUTTON(1),
    BACKGROUND(10),
    MAXIMUM(100),

    ;

    private int priority;

    ComponentPriority(int priority) {
        this.priority = priority;
    }

}
