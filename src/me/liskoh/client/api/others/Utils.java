package me.liskoh.client.api.others;

import java.io.File;
import java.io.IOException;

public class Utils {

  public static final String SMALL_LINE = "�7�m--------------------------";

  public static File tryCreateFile(File file) {
    if (!file.exists()) {
      try {
        file.createNewFile();
        return file;
      } catch (IOException ex) {
        ex.printStackTrace();
      }
    }
    return file;
  }
}
