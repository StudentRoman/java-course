package edu.penzgtu.oop;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Profit {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите список чисел через запятую ");
        String userInput = scanner.nextLine();
        List<Integer> data = stringToNumArray(userInput.split(","));

        int result = maxProfit(data);

        System.out.printf("Максимальная прибыль %d", result);

        scanner.close();
    }

    private static int maxProfit(List<Integer> prices) {
        int result = 0;
        int buy = 1000000;

        for (int price : prices) {
            buy = Math.min(buy, price);
            result = Math.max(result, price - buy);
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
