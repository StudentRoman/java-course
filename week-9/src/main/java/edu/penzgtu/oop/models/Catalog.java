package edu.penzgtu.oop.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class Catalog {
    private ArrayList<Book> books;
}
