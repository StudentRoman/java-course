package edu.penzgtu.oop.repositories;

import edu.penzgtu.oop.dataparsers.JSONDataParser;
import edu.penzgtu.oop.models.Book;
import edu.penzgtu.oop.models.Catalog;
import edu.penzgtu.oop.utils.ConfigUtil;

import java.util.ArrayList;

public class CatalogRepository extends Catalog {
    private static final JSONDataParser<Catalog> catalogParser = new JSONDataParser<>(
            ConfigUtil.getConfig().getProperty("catalogDataPath"),
            Catalog.class
    );

    public CatalogRepository() {
        super(catalogParser.parse().getBooks());
    }

    public ArrayList<Book> findAll() {
        return this.getBooks();
    }

    public Book findById(int bookId) {
        return this.getBooks().stream()
                .filter(book -> book.getId() == bookId)
                .findFirst()
                .orElse(null);
    }
}
