package me.liskoh.client.api.others;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Macro {

    private int key;
    private String command;

    public Macro(int key, String command) {
        this.key = key;
        this.command = command;
    }

}
