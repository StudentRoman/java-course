package edu.penzgtu.oop;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.PathMatcher;
import java.util.ArrayList;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        FileSearch searcher = new FileSearch();

        System.out.println("[1] - поиск по названию файла | [2] - поиск по содержимому текстового файла");
        int choice = Integer.parseInt(scanner.nextLine());

        System.out.println("Введите путь к директории: ");
        String directoryPath = scanner.nextLine();

        try {
            switch (choice) {
                case 1 -> {
                    System.out.println("Введите название файла:");
                    String fileName = scanner.nextLine();

                    PathMatcher matcher = matches("regex:.*" + fileName + ".*");
                    var filesList = searcher.findFiles(directoryPath, matcher);

                    System.out.printf("Найденные файлы %s", filesList);
                }
                case 2 -> {
                    System.out.println("Введите содержимое файла:");
                    String content = scanner.nextLine();

                    PathMatcher matcher = matches("regex:.*.txt");
                    var filesList = searcher.findFiles(directoryPath, matcher);

                    ArrayList<Path> pathList = new ArrayList<>();

                    for (var file : filesList) {
                        if (searcher.isContentExistsInFile(file, content)) {
                            pathList.add(file);
                        }
                    }

                    System.out.printf("Текст содержится в этих файлах: %s", pathList);
                }
            }
        } catch (FileNotFoundException error) {
            System.err.println("Файл не найден.");
            System.err.println(error);
        } catch (IOException error) {
            System.err.println("Ошибка при чтении файла.");
            System.err.println(error);
        }

        scanner.close();
    }

    private static PathMatcher matches(String regex) {
        return FileSystems.getDefault().getPathMatcher(regex);
    }
}
