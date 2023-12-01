package edu.penzgtu.oop.utils;

import lombok.Getter;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigUtil {
    @Getter
    private static Properties config = null;

    public static void setConfig(String configName) throws IOException {
        InputStream inputStream = null;

        try {
            Properties prop = new Properties();
            inputStream = ConfigUtil.class.getClassLoader().getResourceAsStream(configName);

            if (inputStream != null) {
                prop.load(inputStream);
            } else {
                throw new FileNotFoundException("Файл " + configName + "' не найден");
            }

            config = prop;
        } catch (Exception e) {
            System.out.println("Ошибка: " + e);
        } finally {
            inputStream.close();
        }

    }

}