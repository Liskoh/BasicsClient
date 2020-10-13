package me.liskoh.client.api.configuration;

import lombok.Getter;
import lombok.Setter;
import me.liskoh.client.api.others.Utils;

import java.io.File;

@Getter
@Setter
public abstract class AbstractConfiguration {

  private File file;

  public AbstractConfiguration(File file) {
    this.file = file;

    if (!this.file.exists() || this.file == null) {
        this.file = Utils.tryCreateFile(this.file);
    }

  }

  public abstract void load();

  public abstract void save();
}
