package edu.penzgtu.oop.services;

import edu.penzgtu.oop.models.Book;
import edu.penzgtu.oop.repositories.CatalogRepository;

import java.util.ArrayList;

public class CatalogService {
    private final CatalogRepository catalogRepository = new CatalogRepository();

    public ArrayList<Book> findAll() {
        return catalogRepository.findAll();
    }

    public Book findById(int bookId) {
        return catalogRepository.findById(bookId);
    }
}
