package me.liskoh.client.api;

import lombok.Getter;
import lombok.Setter;
import me.liskoh.client.ExampleClient;
import me.liskoh.client.api.commands.BasicsCommand;
import me.liskoh.client.api.configuration.BasicsConfig;
import me.liskoh.client.api.events.Event;
import me.liskoh.client.api.others.Utils;
import me.liskoh.client.api.uis.UI;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.ScaledResolution;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public abstract class BasicsClient {

    private String name;
    private Minecraft mc;

    private List<BasicsCommand> commands;
    private List<BasicsConfig> configs;
    private ScaledResolution resolution;
    private int guiScale;

    public BasicsClient(String name) {
        this.name = name;
        this.mc = Minecraft.getMinecraft();
        this.commands = new ArrayList<>();
        this.configs = new ArrayList<>();
        this.resetResolution();
    }

    public void resetResolution() {
        this.resolution = new ScaledResolution(this.mc, this.mc.displayWidth, this.mc.displayHeight);
    }

    public boolean handleCommands(String cmd) {
        if(cmd.contains("/"))
            cmd = cmd.replace("/","");

        for(BasicsCommand target : this.commands) {
            boolean completed = true;
            for(int i = 0; i < cmd.toCharArray().length && i < target.getCommand().toCharArray().length; i++)
                if(cmd.charAt(i) != target.getCommand().charAt(i))
                    completed = false;
            if(completed){
              //  System.out.println("good " + target.getCommand() + " " + Arrays.toString(cmd.replace(target.getCommand() + " ", "").split(" ")));
                target.perform(ExampleClient.getInstance().getMc().thePlayer, target.getCommand(), cmd.replace(target.getCommand() + " ", "").split(" "));
                return true;
            }
        }
        return false;
    }

    public void registerCommand(BasicsCommand clasz) {
        if(this.commands.contains(clasz))
            throw new IllegalArgumentException(clasz.getCommand() + " is already registred.");
        this.commands.add(clasz);
    }

    public void displayUI(UI ui) {
        this.mc.displayGuiScreen(ui);
    }

    public void closeUI() {
        this.mc.displayGuiScreen(null);
        this.mc.setIngameFocus();
    }

    public void close() {
        this.saveFiles();
        this.onDisable();
    }

    public void loadFiles() {
        this.configs.forEach(configFile -> {
            if(Utils.fileExist(configFile.getFile()))
                configFile.load();
        });
    }

    public void saveFiles() {
        this.configs.forEach(configFile -> {
            if(Utils.fileExist(configFile.getFile()))
                configFile.save();
        });
    }

    public abstract void onEnable();
    public abstract void onDisable();
    public abstract void onEvent(Event event);

}
