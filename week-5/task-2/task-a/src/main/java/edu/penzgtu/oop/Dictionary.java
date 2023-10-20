package edu.penzgtu.oop;

import java.util.*;

public class Dictionary {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите количество английских слов");
        String userInput = scanner.nextLine();
        int wordsCount = Integer.parseInt(userInput);

        System.out.println("Введите: английское слово - его описания через запятую");
        HashMap<String, List<String>> dictionary = fillMap(wordsCount);
        SortedMap<String, List<String>> resultDictionary = createDict(dictionary);

        System.out.println("Результат: ");
        System.out.println(resultDictionary.size());
        resultDictionary.forEach((key, words) -> {
            Collections.sort(words);
            System.out.printf("%s - %s%n", key, String.join(", ", words));
        });

        scanner.close();
    }

    private static SortedMap<String, List<String>> createDict(Map<String, List<String>> dictionary) {
        TreeMap<String, List<String>> resultDictionary = new TreeMap<>();

        for (var entry : dictionary.entrySet()) {
            for (String latinWord : entry.getValue()) {
                List<String> words = new ArrayList<>();

                if (resultDictionary.containsKey(latinWord)) {
                    words = resultDictionary.get(latinWord);
                }

                words.add(entry.getKey());
                resultDictionary.put(latinWord, words);
            }
        }

        return resultDictionary;
    }

    private static HashMap<String, List<String>> fillMap(int arrayLength) {
        Scanner scanner = new Scanner(System.in);
        HashMap<String, List<String>> resultDictionary = new HashMap<>();

        for (int i = 0; i < arrayLength; i++) {
            String[] words = scanner.nextLine().split(" - ");
            String englishWord = words[0];
            String[] latinWords = words[1].split(", ");

            resultDictionary.put(englishWord, Arrays.asList(latinWords));
        }

        scanner.close();

        return resultDictionary;
    }
}