package org.example;

public class UPI implements IPaymentStrategy {
    @Override
    public void pay(double amount) {
        System.out.println("Paid Rs." + amount + " using UPI");
    }
}
