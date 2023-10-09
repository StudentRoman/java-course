package edu.penzgtu.oop;

import java.util.Scanner;
import java.util.Arrays;
import java.util.Comparator;

public class Application {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите показания: ");
        String userInput = scanner.nextLine();

        System.out.println("Сортировка по возрастанию 1 - id; 2 - средняя температура: ");
        int option = scanner.nextInt();

        Sensor[] dataArray = transformData(userInput);

        if (option == 1) {
            Arrays.sort(dataArray, Comparator.comparingDouble(a -> a.id));
            outputData(dataArray);
        } else {
            Arrays.sort(dataArray, Comparator.comparingDouble(a -> a.temp));
            outputData(dataArray);
        }
    }

    private static void outputData(Sensor[] array) {
        for (Sensor element : array) {
            if (element.id != 0) {
                System.out.println(element);
            }
        }
    }

    public static Sensor[] transformData(String str) {
        String[] stringsArray = str.split("@");
        Sensor[] resultArray = new Sensor[stringsArray.length];

        for (int i = 0; i < resultArray.length; i++) {
            double id = Double.parseDouble(stringsArray[i].substring(0, 2));
            double temp = Double.parseDouble(stringsArray[i].substring(2));

            resultArray[i] = new Sensor(id, temp);
        }

        averageData(resultArray);

        return resultArray;
    }

    public static void averageData(Sensor[] array) {
        for (int i = 0; i < array.length; i++) {
            int sum = 1;

            for (int j = i + 1; j < array.length; j++) {
                if (array[i].id == array[j].id) {
                    array[i].temp += array[j].temp;
                    array[j].id = 0;
                    sum++;
                }
            }

            array[i].temp /= sum;
        }
    }
}
