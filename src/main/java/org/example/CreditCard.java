package org.example;

public class CreditCard implements IPaymentStrategy {
    @Override
    public void pay(double amount) {
        System.out.println("Paid Rs." + amount + " using Credit Card");
    }
}
