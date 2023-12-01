package edu.penzgtu.oop.repositories;

import edu.penzgtu.oop.dataparsers.JSONDataParser;
import edu.penzgtu.oop.models.Book;
import edu.penzgtu.oop.models.Cart;
import edu.penzgtu.oop.models.Customer;
import edu.penzgtu.oop.models.CustomerCart;
import edu.penzgtu.oop.utils.ConfigUtil;

import java.util.ArrayList;
import java.util.Objects;

public class CartRepository extends Cart {
    private static final JSONDataParser<Cart> cartParser = new JSONDataParser<>(
            ConfigUtil.getConfig().getProperty("cartDataPath"),
            Cart.class
    );

    public CartRepository() {
        super(cartParser.parse().getCart());
    }

    public ArrayList<CustomerCart> findAll() {
        return this.getCart();
    }

    public CustomerCart findByName(String name) {
        return this.getCart() == null ? null :
                this.getCart()
                        .stream()
                        .filter(item -> Objects.equals(item.getCustomer().getName(), name))
                        .findFirst()
                        .orElse(null);
    }

    public void insertOne(Customer customer) {
        CustomerCart customerCart = new CustomerCart(new ArrayList<>(), 0.0, customer);

        this.getCart().add(customerCart);
        cartParser.create(this);
    }

    public void updateOne(String customerName, Book book) {
        this.getCart()
                .stream()
                .filter(item -> Objects.equals(item.getCustomer().getName(), customerName))
                .findFirst()
                .ifPresent(customerCart -> customerCart.addItem(book));
        cartParser.create(this);
    }

    public void deleteOne(String customerName, Book book) {
        this.getCart()
                .stream()
                .filter(item -> Objects.equals(item.getCustomer().getName(), customerName))
                .findFirst()
                .ifPresent(customerCart -> customerCart.deleteItem(book));
        cartParser.create(this);
    }
}
