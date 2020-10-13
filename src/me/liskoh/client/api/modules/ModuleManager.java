package me.liskoh.client.api.modules;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class ModuleManager {

    private static ModuleManager instance;

    private List<Module> modules;

    public ModuleManager() {

        instance = this;

        this.modules = new ArrayList<>();

    }

    public <T extends Module> T getModule(Class <T> clazz) {
        try {
            Module module = clazz.newInstance();
            return (T) module;
        } catch(IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void addModule(Module module) {
        if (!this.modules.contains(module))
            this.modules.add(module);
    }

    public static ModuleManager getInstance() {
        if (instance == null)
            instance = new ModuleManager();
        return instance;
    }

}
