package edu.penzgtu.oop;

import de.vandermeer.asciitable.AsciiTable;
import de.vandermeer.skb.interfaces.transformers.textformat.TextAlignment;
import edu.penzgtu.oop.models.Book;
import edu.penzgtu.oop.models.Customer;
import edu.penzgtu.oop.models.CustomerCart;
import edu.penzgtu.oop.services.CartService;
import edu.penzgtu.oop.services.CatalogService;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;


public class Application {
    private static final CatalogService catalogService = new CatalogService();
    private static final CartService cartService = new CartService();

    @Setter
    @Getter
    private static Customer currentCustomer;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите имя пользователя");
        String username = scanner.nextLine();

        initCustomer(username);
        mainChoiceMenu();
    }

    private static void initCustomer(String username) {
        CustomerCart currentCart = cartService.findByName(username);

        if (currentCart == null) {
            int customerId = (int) ((new Date().getTime() / 1000L) % Integer.MAX_VALUE);
            Customer newCustomer = new Customer(customerId, username);

            setCurrentCustomer(newCustomer);
            cartService.createCart(newCustomer);
        } else {
            System.out.println("Ваша корзина уже существует");
            setCurrentCustomer(currentCart.getCustomer());
            showCartTable();
        }
    }

    private static void mainChoiceMenu() {
        do {
            showMainMenu();
            int choice = getUserChoiceInput();

            switch (choice) {
                case 1 -> {
                    showCatalogTable();
                    showCatalogMenu();
                    catalogChoiceMenu();
                }
                case 2 -> {
                    showCartTable();
                    showCartMenu();
                    cartChoiceMenu();
                }
                case 0 -> System.exit(0);
            }
        } while (true);
    }

    private static void catalogChoiceMenu() {
        int choice = getUserChoiceInput();

        switch (choice) {
            case 1 -> addProductToCart();
            case 2 -> deleteProductFromCart();
        }
    }

    private static void cartChoiceMenu() {
        int choice = getUserChoiceInput();

        switch (choice) {
            case 1 -> deleteProductFromCart();
            case 2 -> getTotalPrice();
        }
    }

    private static void addProductToCart() {
        System.out.println("Введите ID книги");
        int bookId = getUserChoiceInput();
        Book book = catalogService.findById(bookId);

        cartService.addItem(currentCustomer.getName(), book);
    }

    private static void getTotalPrice() {
        System.out.println("Общая цена");
        CustomerCart currentCart = cartService.findByName(currentCustomer.getName());

        System.out.println(currentCart.getTotalPrice());
    }


    private static void deleteProductFromCart() {
        System.out.println("Введите ID книги");
        int bookId = getUserChoiceInput();
        Book book = catalogService.findById(bookId);

        cartService.deleteItem(currentCustomer.getName(), book);
    }

    private static void showCartTable() {
        ArrayList<Book> books = cartService.findByName(currentCustomer.getName()).getList();

        System.out.println("Ваша корзина: ");
        if (books.isEmpty()) {
            System.out.println("В корзине ничего нет");
        } else {
            generateBookTable(books);
        }
    }

    private static void showCatalogTable() {
        ArrayList<Book> books = catalogService.findAll();

        System.out.println("Каталог книг: ");
        generateBookTable(books);
    }

    private static void generateBookTable(ArrayList<Book> books) {
        AsciiTable asciiTable = new AsciiTable();
        asciiTable.addRule();
        asciiTable.addRow("ID", "Название", "Цена", "Автор", "Год");
        asciiTable.addRule();

        for (Book book : books) {
            asciiTable.addRow(
                    book.getId(),
                    book.getName(),
                    book.getPrice() + " ₽",
                    book.getAuthor().getName(),
                    book.getYear()
            );
            asciiTable.addRule();
        }

        asciiTable.setTextAlignment(TextAlignment.CENTER);
        String render = asciiTable.render();
        System.out.println(render);
    }

    private static int getUserChoiceInput() {
        Scanner scanner = new Scanner(System.in);

        return scanner.nextInt();
    }

    private static void showMainMenu() {
        System.out.println("[1] - Каталог книг");
        System.out.println("[2] - Корзина");
        System.out.println("[0] - Выход");
    }

    private static void showCatalogMenu() {
        System.out.println("[1] - Добавить книгу в корзину по ID");
        System.out.println("[0] - Вернуться в главное меню");
    }

    private static void showCartMenu() {
        System.out.println("[1] - Удалить книгу из корзины по ID");
        System.out.println("[2] - Общая стоймость");
        System.out.println("[0] - Вернуться в главное меню");
    }
}
