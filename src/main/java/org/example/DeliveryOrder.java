package org.example;

import java.util.List;

public class DeliveryOrder extends Order {
    private final String address;

    public DeliveryOrder(User user, Restaurant restaurant, List<MenuItem> items, IPaymentStrategy paymentStrategy, String address) {
        super(user, restaurant, items, paymentStrategy);
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    @Override
    public OrderType getType() {
        return OrderType.DELIVERY;
    }
}
