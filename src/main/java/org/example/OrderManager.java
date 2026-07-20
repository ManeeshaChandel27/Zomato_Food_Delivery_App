package org.example;

import java.util.ArrayList;
import java.util.List;

public class OrderManager {
    private static OrderManager instance;

    private final List<Order> orderList = new ArrayList<>();

    private OrderManager() {
    }

    public static synchronized OrderManager getInstance() {
        if (instance == null) {
            instance = new OrderManager();
        }
        return instance;
    }

    public void addOrder(Order order) {
        orderList.add(order);
    }

    public List<Order> listOrder() {
        return orderList;
    }
}
