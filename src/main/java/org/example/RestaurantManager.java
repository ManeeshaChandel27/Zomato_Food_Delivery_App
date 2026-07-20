package org.example;

import java.util.ArrayList;
import java.util.List;

public class RestaurantManager {
    private static RestaurantManager instance;

    private final List<Restaurant> restaurants = new ArrayList<>();

    private RestaurantManager() {
    }

    public static synchronized RestaurantManager getInstance() {
        if (instance == null) {
            instance = new RestaurantManager();
        }
        return instance;
    }

    public void addRestaurant(Restaurant restaurant) {
        restaurants.add(restaurant);
    }

    public List<Restaurant> searchByLoc(String loc) {
        List<Restaurant> result = new ArrayList<>();
        for (Restaurant restaurant : restaurants) {
            if (restaurant.getLoc().equalsIgnoreCase(loc)) {
                result.add(restaurant);
            }
        }
        return result;
    }
}
