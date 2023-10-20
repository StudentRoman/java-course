package edu.penzgtu.oop;

import java.io.*;
import java.util.*;


public class CustomersInfo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите имя файла: ");
        String fileName = scanner.nextLine();

        SortedMap<String, SortedMap<String, Integer>> result = new TreeMap<>();

        try (BufferedReader buffReader = new BufferedReader(new FileReader(fileName))) {
            String currentLine;

            while ((currentLine = buffReader.readLine()) != null) {
                addCustomerInformation(result, currentLine.split(" "));
            }

            buffReader.close();
            outputData(result);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        scanner.close();
    }

    private static void addCustomerInformation(SortedMap<String, SortedMap<String, Integer>> data, String[] information) {
        String customer = information[0];
        String product = information[1];
        int quantity = Integer.parseInt(information[2]);

        if (!data.containsKey(customer)) {
            data.put(customer, new TreeMap<>());
        }

        data.get(customer).merge(product, quantity, Integer::sum);
    }

    private static void outputData(SortedMap<String, SortedMap<String, Integer>> data) {
        ArrayList<String> keys = new ArrayList<>(data.keySet());

        for (String key : keys) {
            System.out.printf("%s:%n", key);
            data.get(key).forEach((k, v) -> System.out.printf("%s - %s%n", k, v));
        }
    }
}