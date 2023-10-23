package edu.penzgtu.oop;


import java.util.*;

public class Application {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите значения через пробел ");
        String userInput = scanner.nextLine();
        List<Integer> data = stringToNumArray(userInput.split(" "));

        List<List<Integer>> result = perms(data);

        System.out.println("Результат: ");
        System.out.println(result);

        scanner.close();
    }

    private static List<List<Integer>> perms(List<Integer> data) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> element = new ArrayList<>();

        generate(result, element, data, 0);

        return result;
    }

    private static void generate(List<List<Integer>> result, List<Integer> element, List<Integer> data, int number){
        if(number == data.size()){
            result.add(element);
            return;
        }

        for(int i = 0; i <= element.size(); i++){
            List<Integer> temp = new ArrayList<>(element);
            temp.add(i, data.get(number));
            generate(result, temp, data, number + 1);
        }
    }
    private static List<Integer> stringToNumArray(String[] strArrayList) {
        List<Integer> result = new ArrayList<>(strArrayList.length);

        for (String element : strArrayList) {
            result.add(Integer.parseInt(element));
        }

        return result;
    }

}
