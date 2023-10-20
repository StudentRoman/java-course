package edu.penzgtu.oop;

import java.util.*;

public class Application {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите количество студентов");
        int countStudents = scanner.nextInt();

        HashMap<String, Integer> languageMap = new HashMap<>();
        TreeSet<String> languageSet = new TreeSet<>();

        addStudentsInformation(languageMap, languageSet, countStudents);

        ArrayList<String> result = getAllKnownLanguages(languageMap, countStudents);

        System.out.println("Языки, которые знают все студенты");
        System.out.println(result.size());
        for (String language : result) {
            System.out.println(language);
        }

        System.out.println("Языки, которые знает хотя бы один студент");
        System.out.println(languageSet.size());
        for (String language : languageSet) {
            System.out.println(language);
        }

        scanner.close();
    }

    private static void addStudentsInformation(HashMap<String, Integer> map, TreeSet<String> uniqueSet, int countStudents) {
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < countStudents; i++) {
            System.out.println("Введите количество языков, которые знает студент");
            int countLanguages = scanner.nextInt();

            System.out.println("Введите названия языков");
            for (int j = 0; j < countLanguages; j++) {
                String language = scanner.next();
                uniqueSet.add(language);

                if (map.containsKey(language)) {
                    map.put(language, map.get(language) + 1);
                } else {
                    map.put(language, 1);
                }
            }
        }

        scanner.close();
    }

    private static ArrayList<String> getAllKnownLanguages(HashMap<String, Integer> map, int number) {
        ArrayList<String> result = new ArrayList<>();

        for (HashMap.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() == number) {
                result.add(entry.getKey());
            }
        }

        Collections.sort(result);

        return result;
    }
}