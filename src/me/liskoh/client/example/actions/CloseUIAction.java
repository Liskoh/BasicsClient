package me.liskoh.client.example.actions;

import me.liskoh.client.ExampleClient;
import me.liskoh.client.api.actions.types.ClickAction;

public class CloseUIAction extends ClickAction {

    @Override
    public void call() {
        ExampleClient.getInstance().closeUI();
    }
}
