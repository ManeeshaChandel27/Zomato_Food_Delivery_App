package org.example;

import java.util.List;

public class NowOrderFactory implements IOrderFactory {
    @Override
    public Order createOrder(OrderType type, User user, Restaurant restaurant, List<MenuItem> items,
                              IPaymentStrategy paymentStrategy, String address) {
        switch (type) {
            case DELIVERY:
                return new DeliveryOrder(user, restaurant, items, paymentStrategy, address);
            case PICKUP:
                return new PickupOrder(user, restaurant, items, paymentStrategy, address);
            default:
                throw new IllegalArgumentException("Unsupported order type: " + type);
        }
    }
}
