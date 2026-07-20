package org.example;

public class User {
    private final int userId;
    private final String name;
    private final String address;
    private final Cart cart = new Cart();

    public User(int userId, String name, String address) {
        this.userId = userId;
        this.name = name;
        this.address = address;
    }

    public int getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public Cart getCart() {
        return cart;
    }
}
