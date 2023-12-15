package edu.penzgtu.oop;

public class Application {
    public static void main(String[] args) {
        Stack<Integer> stack = new StackImpl<>();

        stack.push(1);
        stack.push(2);

        System.out.printf("Стек после добавления %s%n", stack);

        stack.pop();
        stack.pop();

        System.out.printf("Стек после удаления %s%n", stack);

        if (stack.isEmpty()) {
            System.out.println("Стек пустой");
        } else {
            System.out.println("В стеке есть элементы");
        }
    }
}
