package edu.penzgtu.oop.dataparsers;

public interface DataParser<T> {

    T parse();

    void create(Object newData);
}
