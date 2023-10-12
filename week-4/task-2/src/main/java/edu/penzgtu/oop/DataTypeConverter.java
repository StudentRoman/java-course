package edu.penzgtu.oop;

import java.util.Scanner;

public class DataTypeConverter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите сообщение:");
        String userInput = scanner.nextLine();

        System.out.println("Выберите тип данных:");
        System.out.println("Byte, Integer, Short, Long, Double, Float, Boolean, Char");
        String type = scanner.nextLine().toLowerCase();

        try {
            System.out.printf("Сообщение %s приведено к типу %s, Результат: %s", userInput, type, convertData(userInput, type));
        } catch (Exception error) {
            System.err.printf("Сообщение невозможно привести к типу %s \n", type);
            System.err.println(error);
        }

        scanner.close();
    }

    public static Object convertData(String data, String type) throws Exception {
        switch (type) {
            case "byte":
                return Byte.parseByte(data);
            case "integer":
                return Integer.parseInt(data);
            case "short":
                return Short.parseShort(data);
            case "long":
                return Long.parseLong(data);
            case "double":
                return Double.parseDouble(data);
            case "float":
                return Float.parseFloat(data);
            case "boolean":
                return Boolean.parseBoolean(data);
            case "char":
                return data.charAt(0);
            default:
                throw new Exception("Неверный выбор типа данных.");
        }
    }
}