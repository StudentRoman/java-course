package edu.penzgtu.oop.frontend;

import java.util.Scanner;

public class MainFrontend {
    public static void show() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите имя пользователя");
        String username = scanner.nextLine();

        CartFrontend.initCustomerCart(username);
        choiceMenu();
    }

    private static void showMenu() {
        System.out.println("[1] - Каталог книг");
        System.out.println("[2] - Корзина");
        System.out.println("[0] - Выход");
    }

    private static void choiceMenu() {
        do {
            showMenu();
            int choice = getUserChoiceInput();

            switch (choice) {
                case 1 -> CatalogFrontend.show();
                case 2 -> CartFrontend.show();
                case 0 -> System.exit(0);
            }
        } while (true);
    }


    private static int getUserChoiceInput() {
        Scanner scanner = new Scanner(System.in);

        return scanner.nextInt();
    }

}
