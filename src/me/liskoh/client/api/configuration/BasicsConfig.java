package me.liskoh.client.api.configuration;

import lombok.Getter;
import lombok.Setter;

import java.io.*;
import java.util.Properties;

@Getter
@Setter
public abstract class BasicsConfig {

    private File file;
    private Properties properties;
    private InputStream input;
    private OutputStream output;

    public BasicsConfig(File file) {

        try {
            this.file = file;
            this.properties = new Properties();
            this.input = new FileInputStream(this.file);
            this.output = new FileOutputStream(this.file);
        } catch(Exception ex) {
            ex.printStackTrace();
        }
    }

    public abstract void load();

    public abstract void save();
}
