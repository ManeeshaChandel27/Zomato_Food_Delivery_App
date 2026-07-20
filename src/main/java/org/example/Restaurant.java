package org.example;

import java.util.ArrayList;
import java.util.List;

public class Restaurant {
    private final int restaurantId;
    private final String name;
    private final String loc;
    private final List<MenuItem> menu = new ArrayList<>();

    public Restaurant(int restaurantId, String name, String loc) {
        this.restaurantId = restaurantId;
        this.name = name;
        this.loc = loc;
    }

    public int getRestaurantId() {
        return restaurantId;
    }

    public String getName() {
        return name;
    }

    public String getLoc() {
        return loc;
    }

    public List<MenuItem> getMenu() {
        return menu;
    }

    public void addMenuItem(MenuItem item) {
        menu.add(item);
    }
}
