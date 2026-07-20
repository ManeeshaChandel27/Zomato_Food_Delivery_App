package org.example;

import java.util.List;

public interface IOrderFactory {
    Order createOrder(OrderType type, User user, Restaurant restaurant, List<MenuItem> items,
                       IPaymentStrategy paymentStrategy, String address);
}
