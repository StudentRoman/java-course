package edu.penzgtu.oop.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
@AllArgsConstructor
public class Cart {
    private ArrayList<CustomerCart> cart;
}
