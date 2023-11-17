package edu.penzgtu.oop.services;

import edu.penzgtu.oop.models.Book;
import edu.penzgtu.oop.models.Customer;
import edu.penzgtu.oop.models.CustomerCart;
import edu.penzgtu.oop.repositories.CartRepository;

import java.util.ArrayList;

public class CartService {
    private final CartRepository cartRepository = new CartRepository();

    private boolean findBookInList(int bookId, ArrayList<Book> books) {
        return books != null && books
                .stream()
                .anyMatch(item -> item.getId() == bookId);
    }

    public ArrayList<CustomerCart> findAll() {
        return cartRepository.findAll();
    }

    public CustomerCart findByName(String customerName) {
        return cartRepository.findByName(customerName);
    }

    public void createCart(Customer customer) {
        cartRepository.insertOne(customer);
    }

    public void addItem(String customerName, Book book) {
        CustomerCart cart = cartRepository.findByName(customerName);

        boolean isCartExist = this.findBookInList(book.getId(), cart.getList());

        if (!isCartExist) {
            cartRepository.updateOne(customerName, book);
        } else {
            System.out.println("Товар уже в корзине");
        }
    }

    public void deleteItem(String customerName, Book book) {
        cartRepository.deleteOne(customerName, book);
    }
}
