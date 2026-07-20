package org.example;

import java.util.List;

public class Zomato {
    private final RestaurantManager restaurantManager = RestaurantManager.getInstance();
    private final OrderManager orderManager = OrderManager.getInstance();
    private final NotificationService notificationService = new NotificationService();

    public void registerRestaurant(Restaurant restaurant) {
        restaurantManager.addRestaurant(restaurant);
    }

    public List<Restaurant> searchRestaurantsByLocation(String loc) {
        return restaurantManager.searchByLoc(loc);
    }

    public void addToCart(User user, Restaurant restaurant, MenuItem item) {
        user.getCart().addToCart(restaurant, item);
    }

    public Order placeOrder(User user, IOrderFactory orderFactory, OrderType type, IPaymentStrategy paymentStrategy, String address) {
        Cart cart = user.getCart();
        if (cart.isEmpty()) {
            throw new IllegalStateException("Cannot place an order with an empty cart");
        }

        Order order = orderFactory.createOrder(type, user, cart.getRestaurant(), cart.getItems(), paymentStrategy, address);
        paymentStrategy.pay(order.getTotalCost());
        orderManager.addOrder(order);
        notificationService.notifyUser(order);
        cart.clear();
        return order;
    }

    public List<Order> listOrders() {
        return orderManager.listOrder();
    }
}
