package me.liskoh.client;


import lombok.Getter;
import me.liskoh.client.api.BasicsClient;
import me.liskoh.client.api.events.Event;
import me.liskoh.client.api.events.impl.KeyTypedEvent;
import me.liskoh.client.api.events.impl.RenderEvent;
import me.liskoh.client.api.events.impl.TickEvent;
import me.liskoh.client.api.renderers.InGameRenderer;
import me.liskoh.client.example.commands.TestCommand;
import me.liskoh.client.example.configuration.ClientConfiguration;
import me.liskoh.client.example.renderers.ArmorRenderer;
import org.lwjgl.input.Keyboard;

import java.io.File;

@Getter
public class ExampleClient extends BasicsClient {

    @Getter
    private static ExampleClient instance;

    private ClientConfiguration configuration;

    public ExampleClient() {
        super("Basics");
    }

    @Override
    public void onEnable() {

        instance = this;

        //modules
//        this.addModule(new RankingModule("Ranking"));

        //commands
        this.registerCommand(new TestCommand("test"));

        //configurations
        this.getConfigs().add(this.configuration = new ClientConfiguration(new File(this.getMc().mcDataDir, "settings.json")));

        //renderers
        this.addRenderer(new ArmorRenderer());

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
        } else if (event instanceof KeyTypedEvent) {

            final KeyTypedEvent keyTypedEvent = (KeyTypedEvent) event;

            if (keyTypedEvent.getKey() == Keyboard.KEY_Q) { }

        } else if (event instanceof RenderEvent) {
            this.getRenderers().forEach(InGameRenderer::draw);
        }
    }
}
