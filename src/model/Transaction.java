package model;

public class Transaction {

    private String type;
    private String stockSymbol;
    private int quantity;
    private double amount;

    public Transaction(String type, String stockSymbol,
                       int quantity, double amount) {

        this.type = type;
        this.stockSymbol = stockSymbol;
        this.quantity = quantity;
        this.amount = amount;
    }

    @Override
    public String toString() {
        return type + " | "
                + stockSymbol + " | Qty: "
                + quantity + " | ₹"
                + amount;
    }
}