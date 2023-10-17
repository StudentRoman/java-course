package edu.penzgtu.oop;

import java.util.Arrays;
import java.util.Scanner;

public class DataTypeConverter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите сообщение:");
        String userInput = scanner.nextLine();

        System.out.println("Выберите тип преобразования:");
        System.out.println("Типы: [1] - Byte, [2] - Integer, [3] - Short, [4] - Long, [5] - Double, [6] - Float, [7] - Boolean, [8] - Char, [9] - String");
        System.out.println("Массивы (разделитель - пустая строка): [10] - String в массив, [11] - String в Integer, [12] - String в Double");
        String type = scanner.nextLine().toLowerCase();

        try {
            System.out.printf("Сообщение %s приведено к типу [%s], Результат: %s", userInput, type, convertData(userInput, type));
        } catch (Exception error) {
            System.err.printf("Сообщение невозможно привести к типу %s \n", type);
            System.err.println(error);
        }

        scanner.close();
    }

    public static Object convertData(String data, String type) throws Exception {
        switch (type) {
            case "1":
                return Byte.parseByte(data);
            case "2":
                return Integer.parseInt(data);
            case "3":
                return Short.parseShort(data);
            case "4":
                return Long.parseLong(data);
            case "5":
                return Double.parseDouble(data);
            case "6":
                return Float.parseFloat(data);
            case "7":
                return Boolean.parseBoolean(data);
            case "8":
                return data.charAt(0);
            case "9":
                return data;
            case "10":
                return Arrays.toString(data.split(" "));
            case "11":
                String[] arrayInt = data.split(" ");
                int[] parseIntResult = new int[arrayInt.length];

                for (int i = 0; i < arrayInt.length; i++) {
                    parseIntResult[i] = Integer.parseInt(arrayInt[i]);
                }

                return Arrays.toString(parseIntResult);
            case "12":
                String[] arrayDouble = data.split(" ");
                double[] parseDoubleResult = new double[arrayDouble.length];

                for (int i = 0; i < arrayDouble.length; i++) {
                    parseDoubleResult[i] = Double.parseDouble(arrayDouble[i]);
                }

                return Arrays.toString(parseDoubleResult);
            default:
                throw new Exception("Неверный выбор типа данных.");
        }
    }
}