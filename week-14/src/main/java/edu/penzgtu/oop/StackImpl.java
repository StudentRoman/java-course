package edu.penzgtu.oop;

import java.util.ArrayList;

public class StackImpl<T> implements Stack<T> {
    private final ArrayList<T> stack = new ArrayList<>();

    @Override
    public T peek() {
        if (stack.isEmpty()) {
            return null;
        }

        return stack.get(stack.size() - 1);
    }

    @Override
    public void pop() {
        if (stack.isEmpty()) {
            return;
        }

        T top = stack.get(stack.size() - 1);
        stack.remove(stack.size() - 1);

    }

    @Override
    public void push(T element) {
        stack.add(element);
    }

    @Override
    public int getSize() {
        return stack.size();
    }

    @Override
    public boolean isEmpty() {
        return stack.isEmpty();
    }

    @Override
    public String toString() {
        return "StackImpl{stack=" + stack + "}";
    }
}
