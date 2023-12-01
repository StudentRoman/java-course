package edu.penzgtu.oop.frontend;

import com.github.freva.asciitable.AsciiTable;
import com.github.freva.asciitable.Column;
import edu.penzgtu.oop.models.Book;
import edu.penzgtu.oop.services.CatalogService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class CatalogFrontend {
    private static final CatalogService catalogService = new CatalogService();

    public static void show() {
        showTable();
        showMenu();
        choiceMenu();
    }

    private static void choiceMenu() {
        int choice = getUserChoiceInput();

        switch (choice) {
            case 1 -> CartFrontend.addProductToCart();
            case 2 -> CartFrontend.deleteProductFromCart();
        }
    }

    private static void showMenu() {
        System.out.println("[1] - Добавить книгу в корзину по ID");
        System.out.println("[0] - Вернуться в главное меню");
    }
    
    private static void showTable() {
        ArrayList<Book> books = catalogService.findAll();

        System.out.println("Каталог книг: ");
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

    private static int getUserChoiceInput() {
        Scanner scanner = new Scanner(System.in);

        return scanner.nextInt();
    }
}
