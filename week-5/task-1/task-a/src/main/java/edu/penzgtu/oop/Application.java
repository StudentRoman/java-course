package edu.penzgtu.oop;


import java.util.*;

public class Application {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите значения через пробел ");
        String userInput = scanner.nextLine();
        List<String> data = Arrays.asList(userInput.split(" "));

        List<List<String>> result = permute(data);

        System.out.println("Результат: ");
        System.out.println(result);

        scanner.close();
    }

    private static List<List<String>> permute(List<String> data) {
        List<List<String>> result = new ArrayList<>();
        List<String> element = new ArrayList<>();

        generate(result, element, data, 0);

        return result;
    }

    private static void generate(List<List<String>> result, List<String> element, List<String> data, int number){
        if(number == data.size()){
            result.add(element);
            return;
        }

        for(int i = 0; i <= element.size(); i++){
            List<String> temp = new ArrayList<>(element);
            temp.add(i, data.get(number));
            generate(result, temp, data, number + 1);
        }
    }
}
