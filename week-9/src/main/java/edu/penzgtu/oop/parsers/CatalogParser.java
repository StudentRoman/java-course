package edu.penzgtu.oop.parsers;

import com.google.gson.Gson;
import edu.penzgtu.oop.models.Book;
import edu.penzgtu.oop.models.Catalog;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class CatalogParser {
    private static final String dataPath = "./data/books.json";

    public static ArrayList<Book> parse() {
        try (FileReader reader = new FileReader(dataPath)) {
            Gson gson = new Gson();
            Catalog catalog = gson.fromJson(reader, Catalog.class);

            return catalog.getBooks();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

        return null;
    }
}
