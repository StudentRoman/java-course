package edu.penzgtu.oop;

import java.util.Scanner;
import java.util.Arrays;
import java.util.Comparator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Application {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите показания: ");
        String userInput = scanner.nextLine();

        System.out.println("Сортировка по возрастанию 1 - id; 2 - средняя температура: ");
        int option = scanner.nextInt();

        Sensor[] dataArray = {};

        try {
            dataArray = transformData(userInput);
        } catch (Exception e) {
            System.err.println(e);
        }

        if (option == 1) {
            Arrays.sort(dataArray, Comparator.comparingDouble(Sensor::getId));
            outputData(dataArray);
        } else {
            Arrays.sort(dataArray, Comparator.comparingDouble(Sensor::getId));
            outputData(dataArray);
        }
    }

    private static void outputData(Sensor[] array) {
        for (Sensor element : array) {
            if (element.getId() != 0) {
                System.out.println(element);
            }
        }
    }

    public static Sensor[] transformData(String str) throws Exception {
        if (str.length() > 512) {
            throw new MalformedLengthSensorDataException("Длина строки составляет более 512 символов");
        }

        if (!isValidSensorData(str + "@")) {
            throw new NotValidSensorDataException("Введенные показания не валидны");
        }

        String[] stringsArray = str.split("@");
        Sensor[] resultArray = new Sensor[stringsArray.length];

        for (int i = 0; i < resultArray.length; i++) {
            double id = Double.parseDouble(stringsArray[i].substring(0, 2));
            double temp = Double.parseDouble(stringsArray[i].substring(2));

            if (temp > 50 || temp < -50) {
                throw new ValueOutOfRangeException("Значение температуры должно находиться в диапазоне от -50 до 50");
            }

            resultArray[i] = new Sensor(id, temp);
        }

        averageData(resultArray);

        return resultArray;
    }

    public static void averageData(Sensor[] array) {
        for (int i = 0; i < array.length; i++) {
            int sum = 1;

            for (int j = i + 1; j < array.length; j++) {
                if (array[i].getId() == array[j].getId()) {
                    array[i].setTemp(array[i].getTemp() + array[j].getTemp());
                    array[j].setId(0);
                    sum++;
                }
            }

            array[i].setTemp(array[i].getTemp() / sum);
        }
    }

    private static boolean isValidSensorData(String str) {
        String emailRegex = "(((\\d{2}-?(\\d{1,2})))@){1,}";
        Pattern emailPattern = Pattern.compile(emailRegex);
        Matcher matcher = emailPattern.matcher(str);

        return matcher.matches();
    }
}
