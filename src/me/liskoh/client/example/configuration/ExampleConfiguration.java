package me.liskoh.client.example.configuration;

import lombok.Getter;
import lombok.Setter;
import me.liskoh.client.api.configuration.BasicsConfig;
import me.liskoh.client.api.others.Macro;
import org.lwjgl.input.Keyboard;

import java.io.File;

@Getter
@Setter
public class ExampleConfiguration extends BasicsConfig {

    private Macro macro;

    public ExampleConfiguration(File file) {
        super(file);
    }

    @Override
    public void load() {
        try {
            if(this.getInput() == null)
                return;

            this.getProperties().load(this.getInput());

            final String[] sMacro = this.getProperties().getProperty("macro").split("@");
            this.macro = new Macro(Integer.parseInt(sMacro[0]), sMacro[1]);
        } catch(Exception ex) {
            this.macro = new Macro(Keyboard.KEY_Q, "gamemode 1");
            ex.printStackTrace();
        }
    }

    @Override
    public void save() {
        try{
            if(this.getOutput() == null)
                return;
            this.getProperties().setProperty("macro",this.macro.getKey() + "@" + this.macro.getCommand());
            this.getProperties().save(this.getOutput(), null);
        }catch(Exception ex) {
            ex.printStackTrace();
        }
    }
}
