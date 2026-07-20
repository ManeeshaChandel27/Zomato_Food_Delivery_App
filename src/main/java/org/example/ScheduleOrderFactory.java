package org.example;

import java.time.LocalDateTime;
import java.util.List;

public class ScheduleOrderFactory implements IOrderFactory {
    private final LocalDateTime scheduleTime;

    public ScheduleOrderFactory(LocalDateTime scheduleTime) {
        this.scheduleTime = scheduleTime;
    }

    public LocalDateTime getScheduleTime() {
        return scheduleTime;
    }

    @Override
    public Order createOrder(OrderType type, User user, Restaurant restaurant, List<MenuItem> items,
                              IPaymentStrategy paymentStrategy, String address) {
        System.out.println("Order scheduled for " + scheduleTime);
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
