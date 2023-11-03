package edu.penzgtu.oop;

import java.time.Duration;
import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

public class DatasetGenerator {
    public Map<Integer, Long> generateBrackets(int length) {
        Map<Integer, Long> result = new HashMap<>();

        BracketsCheck bracketsCheck = new BracketsCheck();
        var bracketsArray = bracketsCheck.generateParenthesis(length);

        for (int i = 1; i < bracketsArray.size(); i++) {
            Instant timeStart = Instant.now();

            bracketsCheck.isValid(bracketsArray.get(i));

            long timeEnd = Duration.between(timeStart, Instant.now()).toNanos();

            result.put(i, timeEnd == 0 ? 1 : timeEnd);
        }

        return result;
    }
}
