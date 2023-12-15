package edu.penzgtu.oop.services;

import edu.penzgtu.oop.models.Book;

import java.util.ArrayList;

public interface CatalogService {
    ArrayList<Book> findAll();

    public Book findById(int bookId);

}
