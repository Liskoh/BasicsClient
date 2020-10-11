package me.liskoh.client.api.others;

import java.io.File;
import java.io.IOException;

public class Utils {

    public static final String SMALL_LINE = "�7�m--------------------------";

    public static boolean fileExist(File file) {
        if(! file.exists()) {
            try {
                file.createNewFile();
                return false;
            } catch(IOException ex) {
                ex.printStackTrace();
            }
        }
        return true;
    }

}
