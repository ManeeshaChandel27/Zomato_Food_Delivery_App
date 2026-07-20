package org.example;

public class NetBanking implements IPaymentStrategy {
    @Override
    public void pay(double amount) {
        System.out.println("Paid Rs." + amount + " using Net Banking");
    }
}
