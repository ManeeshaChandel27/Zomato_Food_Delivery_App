package org.example;

import java.util.List;

public class PickupOrder extends Order {
    private final String resAddress;

    public PickupOrder(User user, Restaurant restaurant, List<MenuItem> items, IPaymentStrategy paymentStrategy, String resAddress) {
        super(user, restaurant, items, paymentStrategy);
        this.resAddress = resAddress;
    }

    public String getResAddress() {
        return resAddress;
    }

    @Override
    public OrderType getType() {
        return OrderType.PICKUP;
    }
}
