package edu.penzgtu.oop;

import java.util.*;

public class Square {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите координаты линий через запятую: ");
        String userInput = scanner.nextLine();

        List<Integer> data = stringToNumArray(userInput.split(","));

        System.out.printf("Результат %n%d", maxContainerSquare(data));
    }

    private static long maxContainerSquare(List<Integer> coordinates) {
        int result = 0;

        for (int i = 0; i < coordinates.size() - 1; i++) {
            for (int j = i + 1; j < coordinates.size(); j++) {
                int area = Math.min(coordinates.get(i), coordinates.get(j)) * (j - i);
                result = Math.max(result, area);
            }
        }

        return result;
    }

    private static List<Integer> stringToNumArray(String[] strArrayList) {
        List<Integer> result = new ArrayList<>(strArrayList.length);

        for (String element : strArrayList) {
            result.add(Integer.parseInt(element));
        }

        return result;
    }
}
