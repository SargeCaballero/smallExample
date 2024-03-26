package com.sarge.enums;

public enum AccountType {
    BLUE(50000, 10000),
    GOLD(100000, 5000),
    BLACK(Double.POSITIVE_INFINITY, 10000);

    private final double maxAmount;
    private final double minAmount;

    AccountType(double maxAmount, double minAmount) {
        this.maxAmount = maxAmount;
        this.minAmount = minAmount;
    }

    public double getMaxAmount() {
        return maxAmount;
    }
    public double getMinAmount() {
        return minAmount;
    }
}
