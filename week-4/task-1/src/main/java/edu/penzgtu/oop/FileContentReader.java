package edu.penzgtu.oop;

import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileContentReader {
    public static void main(String[] args) {
        String filename = "text.txt";

        try {
            String content = fileRead(filename);

            System.out.printf("Содержимое файла %s: \n", filename);
            System.out.println(content);
        } catch (FileNotFoundException error) {
            System.err.println("Файл не найден.");
            System.err.println(error);
        } catch (IOException error) {
            System.err.println("Ошибка при чтении файла.");
            System.err.println(error);
        }
    }

    public static String fileRead(String filename) throws IOException {
        FileReader fileReader = new FileReader(filename);
        char[] chars = new char[1024];
        fileReader.read(chars);

        String result = new String(chars);
        fileReader.close();

        return result;
    }
}