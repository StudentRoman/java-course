package edu.penzgtu.oop.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
@AllArgsConstructor
public class CustomerCart {
    private ArrayList<Book> list;
    private double totalPrice;
    private Customer customer;

    public void addItem(Book book) {
        this.list.add(book);
        this.totalPrice += book.getPrice();
    }

    public void deleteItem(Book book) {
        list.removeIf(item -> book.getId() == item.getId());
        this.totalPrice -= book.getPrice();
    }
}
