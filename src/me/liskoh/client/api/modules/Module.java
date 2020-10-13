package me.liskoh.client.api.modules;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public abstract class Module {

    private String name;
    private boolean enabled;

    public Module(String name) {
        this.name = name;
        this.enabled = true;
    }

}
