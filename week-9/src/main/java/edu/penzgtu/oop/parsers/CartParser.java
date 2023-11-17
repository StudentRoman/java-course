package edu.penzgtu.oop.parsers;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import edu.penzgtu.oop.models.Cart;
import edu.penzgtu.oop.models.CustomerCart;
import edu.penzgtu.oop.repositories.CartRepository;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class CartParser {
    private static final String dataPath = "./data/cart.json";

    public static ArrayList<CustomerCart> parse() {
        try (FileReader reader = new FileReader(dataPath)) {
            Gson gson = new Gson();
            Cart cart = gson.fromJson(reader, Cart.class);

            return cart.getCart();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

        return null;
    }

    public static void create(CartRepository cart) {
        try (FileWriter writer = new FileWriter(dataPath)) {
            Gson gson = new GsonBuilder().create();
            gson.toJson(cart, writer);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
