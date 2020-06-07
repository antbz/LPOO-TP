package com.aor.refactoring.example3;

public class PercentDiscount implements Discount {
    private final double percentage;

    public PercentDiscount(double percentage) {
        this.percentage = percentage;
    }

    @Override
    public double applyDiscount(double price) { return price - price * percentage; }
}
