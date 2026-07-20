package org.example;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private Restaurant restaurant;
    private final List<MenuItem> items = new ArrayList<>();

    public void addToCart(Restaurant restaurant, MenuItem item) {
        if (this.restaurant != null && this.restaurant.getRestaurantId() != restaurant.getRestaurantId()) {
            throw new IllegalStateException("Cart already has items from another restaurant: " + this.restaurant.getName());
        }
        this.restaurant = restaurant;
        items.add(item);
    }

    public double totalCost() {
        double total = 0;
        for (MenuItem item : items) {
            total += item.getPrice();
        }
        return total;
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public List<MenuItem> getItems() {
        return items;
    }

    public void clear() {
        items.clear();
        restaurant = null;
    }
}
