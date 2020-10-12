package me.liskoh.client;


import lombok.Getter;
import me.liskoh.client.api.BasicsClient;
import me.liskoh.client.api.events.Event;
import me.liskoh.client.api.events.impl.KeyTipedEvent;
import me.liskoh.client.api.events.impl.TickEvent;
import me.liskoh.client.example.uis.ExamplePageUI;
import me.liskoh.client.example.commands.TestCommand;
import me.liskoh.client.example.configuration.ExampleConfiguration;
import org.lwjgl.input.Keyboard;

import java.io.File;

public class ExampleClient extends BasicsClient {

    @Getter
    private static ExampleClient instance;

    public ExampleClient() {
        super("Basics");
    }

    @Override
    public void onEnable() {

        instance = this;

        //commands
        this.registerCommand(new TestCommand("test"));

        //configurations
        this.getConfigs().add(new ExampleConfiguration(new File(this.getMc().mcDataDir, "macros.txt")));

        this.loadFiles();

    }

    @Override
    public void onDisable() {
        this.saveFiles();
    }

    @Override
    public void onEvent(Event event) {

        if (event.isCancelled())
            return;

        if (event instanceof TickEvent) {
            this.resetResolution();
        } else if (event instanceof KeyTipedEvent) {

            final KeyTipedEvent keyTipedEvent = (KeyTipedEvent) event;

            if (keyTipedEvent.getKey() == Keyboard.KEY_Q)
//                this.displayUI(new AuctionSellUI(new ItemStack(Items.diamond_sword)));
                this.displayUI(new ExamplePageUI());
        }

    }
}
