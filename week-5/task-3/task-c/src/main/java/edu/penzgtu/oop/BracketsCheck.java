package edu.penzgtu.oop;

import java.util.Scanner;
import java.util.Stack;

public class BracketsCheck {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите строку, содержащую только символы '(', ')', '{', '}', '[' и ']' ");
        String userInput = scanner.nextLine();

        boolean result = isValid(userInput);
        
        if (result) {
            System.out.println("Строка прошла валидацию");
        } else {
            System.err.println("Строка не прошла валидацию");
        }

        scanner.close();
    }

    public static boolean isValid(String str) {
        Stack<Character> stack = new Stack<>();

        for (char c : str.toCharArray()) {
            if (c == '(')
                stack.push(')');
            else if (c == '{')
                stack.push('}');
            else if (c == '[')
                stack.push(']');
            else if (stack.isEmpty() || stack.pop() != c)
                return false;
        }

        return stack.isEmpty();
    }
}
