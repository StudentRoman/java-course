package edu.penzgtu.oop;

import edu.penzgtu.oop.models.Customer;
import edu.penzgtu.oop.models.Order;
import edu.penzgtu.oop.models.Product;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DataGenerator {
    private static ArrayList<Customer> createCustomers() {
        Customer firstCustomer = new Customer();
        firstCustomer.setId(1L);
        firstCustomer.setName("Ivanov");
        firstCustomer.setTier(1);

        Customer secondCustomer = new Customer();
        secondCustomer.setId(2L);
        secondCustomer.setName("Petrov");
        secondCustomer.setTier(1);

        return new ArrayList<>(List.of(firstCustomer, secondCustomer));
    }

    private static Set<Product> createProducts() {
        Product envelope = new Product();
        envelope.setId(1L);
        envelope.setName("Envelope");
        envelope.setCategory("Stationery");
        envelope.setPrice(10.0);

        Product marker = new Product();
        marker.setId(2L);
        marker.setName("Marker");
        marker.setCategory("Stationery");
        marker.setPrice(12.0);

        Product paper = new Product();
        paper.setId(3L);
        paper.setName("Paper");
        paper.setCategory("Stationery");
        paper.setPrice(4.0);

        return new HashSet<>(List.of(envelope, marker, paper));
    }

    public ArrayList<Order> createOrders() {
        ArrayList<Customer> customersList = createCustomers();
        Set<Product> productsList = createProducts();

        Order firstOrder = new Order();
        firstOrder.setId(1L);
        firstOrder.setCustomer(customersList.get(0));
        firstOrder.setProducts(productsList);
        firstOrder.setStatus("Completed");
        firstOrder.setOrderDate(LocalDate.parse("2023-05-04"));
        firstOrder.setDeliveryDate(LocalDate.parse("2023-05-04"));

        Order secondOrder = new Order();
        secondOrder.setId(2L);
        secondOrder.setCustomer(customersList.get(1));
        secondOrder.setProducts(productsList);
        secondOrder.setStatus("Completed");
        secondOrder.setOrderDate(LocalDate.parse("2020-02-04"));
        secondOrder.setDeliveryDate(LocalDate.parse("2020-02-04"));

        Order thirdOrder = new Order();
        thirdOrder.setId(3L);
        thirdOrder.setCustomer(customersList.get(1));
        thirdOrder.setProducts(productsList);
        thirdOrder.setStatus("Completed");
        thirdOrder.setOrderDate(LocalDate.parse("2020-02-21"));
        thirdOrder.setDeliveryDate(LocalDate.parse("2020-02-21"));

        Order fourthOrder = new Order();
        fourthOrder.setId(4L);
        fourthOrder.setCustomer(customersList.get(0));
        fourthOrder.setProducts(productsList);
        fourthOrder.setStatus("Completed");
        fourthOrder.setOrderDate(LocalDate.parse("2021-12-12"));
        fourthOrder.setDeliveryDate(LocalDate.parse("2021-12-12"));


        return new ArrayList<>(List.of(firstOrder, secondOrder, thirdOrder, fourthOrder));
    }
}
