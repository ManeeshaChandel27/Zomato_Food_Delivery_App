package org.example;

import java.time.LocalDateTime;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Zomato zomato = new Zomato();

        Restaurant biryaniHouse = new Restaurant(1, "Biryani House", "Koramangala");
        biryaniHouse.addMenuItem(new MenuItem("M1", "Chicken Biryani", 250));
        biryaniHouse.addMenuItem(new MenuItem("M2", "Veg Biryani", 200));
        zomato.registerRestaurant(biryaniHouse);

        Restaurant pizzaPlace = new Restaurant(2, "Pizza Place", "Indiranagar");
        pizzaPlace.addMenuItem(new MenuItem("P1", "Margherita", 300));
        zomato.registerRestaurant(pizzaPlace);

        User user = new User(1, "Maneesha", "5th Block, Koramangala");

        List<Restaurant> nearbyRestaurants = zomato.searchRestaurantsByLocation("Koramangala");
        System.out.println("Restaurants in Koramangala: " + nearbyRestaurants.size());

        zomato.addToCart(user, biryaniHouse, biryaniHouse.getMenu().get(0));
        zomato.addToCart(user, biryaniHouse, biryaniHouse.getMenu().get(1));

        Order deliveryOrder = zomato.placeOrder(user, new NowOrderFactory(), OrderType.DELIVERY,
                new UPI(), user.getAddress());

        zomato.addToCart(user, pizzaPlace, pizzaPlace.getMenu().get(0));
        Order pickupOrder = zomato.placeOrder(user, new ScheduleOrderFactory(LocalDateTime.now().plusHours(2)),
                OrderType.PICKUP, new CreditCard(), pizzaPlace.getLoc());

        System.out.println("Total orders placed: " + zomato.listOrders().size());
    }
}
