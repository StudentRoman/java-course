package edu.penzgtu.oop.services;

import edu.penzgtu.oop.models.Book;
import edu.penzgtu.oop.models.Customer;
import edu.penzgtu.oop.models.CustomerCart;

import java.util.ArrayList;

public interface CartService {

    ArrayList<CustomerCart> findAll();

    CustomerCart findByName(String customerName);

    void createCart(Customer customer);

    void addItem(String customerName, Book book);

    void deleteItem(String customerName, Book book);
}
