package edu.penzgtu.oop.dataparsers;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class JSONDataParser<T> {
    private final String dataPath;
    private final Class<T> model;

    public JSONDataParser(String dataPath, Class<T> model) {
        this.dataPath = dataPath;
        this.model = model;
    }

    public T parse() {
        try (FileReader reader = new FileReader(this.dataPath)) {
            Gson gson = new Gson();

            return gson.fromJson(reader, this.model);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

        return null;
    }

    public <K> void create(K newData) {
        try (FileWriter writer = new FileWriter(this.dataPath)) {
            Gson gson = new GsonBuilder().create();
            gson.toJson(newData, writer);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
