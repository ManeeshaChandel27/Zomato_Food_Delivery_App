package org.example;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class Order {
    private static final AtomicInteger ID_GENERATOR = new AtomicInteger(1);

    private final int id;
    private final User user;
    private final Restaurant restaurant;
    private final List<MenuItem> items;
    private final IPaymentStrategy paymentStrategy;

    protected Order(User user, Restaurant restaurant, List<MenuItem> items, IPaymentStrategy paymentStrategy) {
        this.id = ID_GENERATOR.getAndIncrement();
        this.user = user;
        this.restaurant = restaurant;
        this.items = items;
        this.paymentStrategy = paymentStrategy;
    }

    public abstract OrderType getType();

    public int getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public List<MenuItem> getItems() {
        return items;
    }

    public IPaymentStrategy getPaymentStrategy() {
        return paymentStrategy;
    }

    public double getTotalCost() {
        double total = 0;
        for (MenuItem item : items) {
            total += item.getPrice();
        }
        return total;
    }
}
