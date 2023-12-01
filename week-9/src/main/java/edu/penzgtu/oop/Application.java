package edu.penzgtu.oop;

import edu.penzgtu.oop.frontend.MainFrontend;
import edu.penzgtu.oop.utils.ConfigUtil;

import java.io.IOException;


public class Application {
    public static void main(String[] args) throws IOException {
        ConfigUtil.setConfig("config.properties");
        MainFrontend.show();
    }
}
