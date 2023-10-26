package edu.penzgtu.oop;

import edu.penzgtu.oop.models.Order;

import java.time.Month;
import java.util.ArrayList;

public class Application {
    public static void main(String[] args) {
        DataGenerator data = new DataGenerator();
        ArrayList<Order> ordersList = data.createOrders();

        System.out.printf("Общая сумма всех заказов, размещенных в феврале 2020 г = %s", getTotalOrderAmount(ordersList));
    }

    private static double getTotalOrderAmount(ArrayList<Order> ordersList) {
        return ordersList.stream()
                .filter(order -> order.getOrderDate().getMonth() == Month.FEBRUARY && order.getOrderDate().getYear() == 2020)
                .flatMap(order -> order.getProducts().stream())
                .reduce(0.0, (prev, current) -> prev + current.getPrice(), Double::sum);
    }
}