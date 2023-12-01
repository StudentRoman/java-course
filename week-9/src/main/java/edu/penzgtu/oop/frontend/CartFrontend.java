package edu.penzgtu.oop.frontend;

import com.github.freva.asciitable.AsciiTable;
import com.github.freva.asciitable.Column;
import edu.penzgtu.oop.models.Book;
import edu.penzgtu.oop.models.Customer;
import edu.penzgtu.oop.models.CustomerCart;
import edu.penzgtu.oop.services.CartService;
import edu.penzgtu.oop.services.CatalogService;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;

public class CartFrontend {
    private static final CartService cartService = new CartService();
    private static final CatalogService catalogService = new CatalogService();

    @Setter
    @Getter
    private static Customer currentCustomer;

    public static void show() {
        showTable();
        showMenu();
        choiceMenu();
    }

    public static void initCustomerCart(String username) {
        CustomerCart currentCart = cartService.findByName(username);

        if (currentCart == null) {
            int customerId = (int) ((new Date().getTime() / 1000L) % Integer.MAX_VALUE);
            Customer newCustomer = new Customer(customerId, username);

            setCurrentCustomer(newCustomer);
            cartService.createCart(newCustomer);
        } else {
            System.out.println("Ваша корзина уже существует");
            setCurrentCustomer(currentCart.getCustomer());
            showTable();
        }
    }

    public static void addProductToCart() {
        System.out.println("Введите ID книги");
        int bookId = getUserChoiceInput();
        Book book = catalogService.findById(bookId);

        cartService.addItem(currentCustomer.getName(), book);
    }

    public static void deleteProductFromCart() {
        System.out.println("Введите ID книги");
        int bookId = getUserChoiceInput();
        Book book = catalogService.findById(bookId);

        cartService.deleteItem(currentCustomer.getName(), book);
    }

    private static void getTotalPrice() {
        System.out.println("Общая цена");
        CustomerCart currentCart = cartService.findByName(currentCustomer.getName());

        System.out.println(currentCart.getTotalPrice());
    }

    private static void choiceMenu() {
        int choice = getUserChoiceInput();

        switch (choice) {
            case 1 -> deleteProductFromCart();
            case 2 -> getTotalPrice();
        }
    }

    private static void showMenu() {
        System.out.println("[1] - Удалить книгу из корзины по ID");
        System.out.println("[2] - Общая стоймость");
        System.out.println("[0] - Вернуться в главное меню");
    }

    private static void showTable() {
        ArrayList<Book> books = cartService.findByName(currentCustomer.getName()).getList();

        System.out.println("Ваша корзина: ");
        if (books.isEmpty()) {
            System.out.println("В корзине ничего нет");
        } else {
            System.out.println(AsciiTable.getTable(
                    books,
                    Arrays.asList(
                            new Column().header("ID").with(book -> Integer.toString(book.getId())),
                            new Column().header("Название").with(Book::getName),
                            new Column().header("Цена").with(book -> String.format("%s ₽", book.getPrice())),
                            new Column().header("Автор").with(book -> book.getAuthor().getName()),
                            new Column().header("Год").with(book -> Integer.toString(book.getYear()))
                    )
            ));
        }
    }

    private static int getUserChoiceInput() {
        Scanner scanner = new Scanner(System.in);

        return scanner.nextInt();
    }
}
