package edu.penzgtu.oop.repositories;

import edu.penzgtu.oop.models.Book;
import edu.penzgtu.oop.models.Catalog;
import edu.penzgtu.oop.parsers.CatalogParser;

import java.util.ArrayList;

public class CatalogRepository extends Catalog {

    public CatalogRepository() {
        super(CatalogParser.parse());
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
