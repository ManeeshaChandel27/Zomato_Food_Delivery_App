package org.example;

public class NotificationService {
    public void notifyUser(Order order) {
        System.out.println("Notifying " + order.getUser().getName() + ": your order #" + order.getId()
                + " (" + order.getType() + ") has been placed. Total: Rs." + order.getTotalCost());
    }
}
