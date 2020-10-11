package me.liskoh.client.example.actions;

import me.liskoh.client.ExampleClient;
import me.liskoh.client.api.components.actions.ClickAction;

public class CloseUIAction extends ClickAction {

    @Override
    public void call() {
        ExampleClient.getInstance().closeUI();
    }
}
