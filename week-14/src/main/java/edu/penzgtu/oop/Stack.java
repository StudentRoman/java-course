package edu.penzgtu.oop;

public interface Stack<T> {
    T peek();

    void pop();

    void push(T element);

    public int getSize();

    boolean isEmpty();
}
