package edu.penzgtu.oop;

import java.util.*;

public class Square {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите координаты линий через запятую: ");
        String userInput = scanner.nextLine();

        List<Integer> data = stringToNumArray(userInput.split(","));

        System.out.printf("Результат %n%d", maxContainerArea(data));
    }

    private static long maxContainerArea(List<Integer> coordinates) {
        int left = 0;
        int right = coordinates.size() - 1;
        int max = 0;

        while (left < right) {
            int width = right - left;
            int height = Math.min(coordinates.get(left), coordinates.get(right));
            int area = height * width;
            max = Math.max(max, area);

            if (coordinates.get(left) < coordinates.get(right)) {
                left++;
            } else if (coordinates.get(left) > coordinates.get(right)) {
                right--;
            } else {
                left++;
                right--;
            }
        }

        return max;
    }

    private static List<Integer> stringToNumArray(String[] strArrayList) {
        List<Integer> result = new ArrayList<>(strArrayList.length);

        for (String element : strArrayList) {
            result.add(Integer.parseInt(element));
        }

        return result;
    }
}
