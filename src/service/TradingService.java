package service;

import model.PortfolioItem;
import model.Stock;
import model.Transaction;

import java.util.ArrayList;

public class TradingService {

    private ArrayList<Stock> marketStocks;
    private ArrayList<PortfolioItem> portfolio;
    private ArrayList<Transaction> transactions;

    private double walletBalance;

    public TradingService() {

        marketStocks = new ArrayList<>();
        portfolio = new ArrayList<>();
        transactions = new ArrayList<>();

        walletBalance = 100000;

        loadMarketStocks();
    }

    private void loadMarketStocks() {

        marketStocks.add(new Stock("AAPL", "Apple", 190));
        marketStocks.add(new Stock("GOOGL", "Google", 250));
        marketStocks.add(new Stock("TSLA", "Tesla", 300));
        marketStocks.add(new Stock("MSFT", "Microsoft", 220));
    }

    public void viewMarket() {

        System.out.println("\n===== MARKET DATA =====");

        for (Stock stock : marketStocks) {
            System.out.println(stock);
        }
    }

    public void buyStock(String symbol, int quantity) {

        Stock stock = findStock(symbol);

        if (stock == null) {
            System.out.println("Stock not found!");
            return;
        }

        double totalCost = stock.getPrice() * quantity;

        if (totalCost > walletBalance) {
            System.out.println("Insufficient wallet balance!");
            return;
        }

        walletBalance -= totalCost;

        PortfolioItem existingItem = findPortfolioItem(symbol);

        if (existingItem != null) {

            existingItem.setQuantity(
                    existingItem.getQuantity() + quantity
            );

        } else {

            portfolio.add(
                    new PortfolioItem(
                            stock,
                            quantity,
                            stock.getPrice()
                    )
            );
        }

        transactions.add(
                new Transaction(
                        "BUY",
                        symbol,
                        quantity,
                        totalCost
                )
        );

        System.out.println("Stock purchased successfully!");
    }

    public void sellStock(String symbol, int quantity) {

        PortfolioItem item = findPortfolioItem(symbol);

        if (item == null) {
            System.out.println("You do not own this stock.");
            return;
        }

        if (quantity > item.getQuantity()) {
            System.out.println("Not enough quantity.");
            return;
        }

        double sellAmount =
                item.getStock().getPrice() * quantity;

        walletBalance += sellAmount;

        item.setQuantity(
                item.getQuantity() - quantity
        );

        if (item.getQuantity() == 0) {
            portfolio.remove(item);
        }

        transactions.add(
                new Transaction(
                        "SELL",
                        symbol,
                        quantity,
                        sellAmount
                )
        );

        System.out.println("Stock sold successfully!");
    }

    public void viewPortfolio() {

        System.out.println("\n===== PORTFOLIO =====");

        if (portfolio.isEmpty()) {
            System.out.println("Portfolio is empty.");
            return;
        }

        for (PortfolioItem item : portfolio) {

            double currentValue =
                    item.getQuantity()
                            * item.getStock().getPrice();

            System.out.println(
                    item.getStock().getSymbol()
                            + " | Qty: "
                            + item.getQuantity()
                            + " | Current Value: ₹"
                            + currentValue
            );
        }

        System.out.println(
                "\nTotal Portfolio Value: ₹"
                        + calculatePortfolioValue()
        );
    }

    public void showTransactions() {

        System.out.println("\n===== TRANSACTIONS =====");

        if (transactions.isEmpty()) {
            System.out.println("No transactions available.");
            return;
        }

        for (Transaction transaction : transactions) {
            System.out.println(transaction);
        }
    }

    public double calculatePortfolioValue() {

        double total = 0;

        for (PortfolioItem item : portfolio) {

            total += item.getQuantity()
                    * item.getStock().getPrice();
        }

        return total;
    }

    public void calculateProfitLoss() {

        double investedAmount = 0;
        double currentValue = 0;

        for (PortfolioItem item : portfolio) {

            investedAmount +=
                    item.getPurchasePrice()
                            * item.getQuantity();

            currentValue +=
                    item.getStock().getPrice()
                            * item.getQuantity();
        }

        double profitLoss =
                currentValue - investedAmount;

        System.out.println(
                "\nInvested Amount: ₹" + investedAmount
        );

        System.out.println(
                "Current Value: ₹" + currentValue
        );

        System.out.println(
                "Profit/Loss: ₹" + profitLoss
        );
    }

    public void showWalletBalance() {

        System.out.println(
                "\nWallet Balance: ₹"
                        + walletBalance
        );
    }

    private Stock findStock(String symbol) {

        for (Stock stock : marketStocks) {

            if (stock.getSymbol()
                    .equalsIgnoreCase(symbol)) {

                return stock;
            }
        }

        return null;
    }

    private PortfolioItem findPortfolioItem(
            String symbol) {

        for (PortfolioItem item : portfolio) {

            if (item.getStock()
                    .getSymbol()
                    .equalsIgnoreCase(symbol)) {

                return item;
            }
        }

        return null;
    }


}

