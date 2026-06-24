import service.TradingService;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        TradingService tradingService = new TradingService();

        while (true) {

            System.out.println("\n=================================");
            System.out.println("     STOCK TRADING PLATFORM");
            System.out.println("=================================");
            System.out.println("1. View Market");
            System.out.println("2. Buy Stock");
            System.out.println("3. Sell Stock");
            System.out.println("4. View Portfolio");
            System.out.println("5. Transaction History");
            System.out.println("6. Portfolio Performance");
            System.out.println("7. Wallet Balance");
            System.out.println("8. Exit");

            System.out.print("\nEnter your choice: ");

            int choice;

            try {
                choice = sc.nextInt();
            } catch (Exception e) {
                System.out.println("Invalid input!");
                sc.nextLine();
                continue;
            }

            switch (choice) {

                case 1:
                    tradingService.viewMarket();
                    break;

                case 2:

                    System.out.print("Enter Stock Symbol: ");
                    String buySymbol = sc.next();

                    System.out.print("Enter Quantity: ");
                    int buyQuantity = sc.nextInt();

                    tradingService.buyStock(
                            buySymbol,
                            buyQuantity
                    );

                    break;

                case 3:

                    System.out.print("Enter Stock Symbol: ");
                    String sellSymbol = sc.next();

                    System.out.print("Enter Quantity: ");
                    int sellQuantity = sc.nextInt();

                    tradingService.sellStock(
                            sellSymbol,
                            sellQuantity
                    );

                    break;

                case 4:

                    tradingService.viewPortfolio();

                    break;

                case 5:

                    tradingService.showTransactions();

                    break;

                case 6:

                    tradingService.calculateProfitLoss();

                    break;

                case 7:

                    tradingService.showWalletBalance();

                    break;

                case 8:

                    System.out.println(
                            "\nThank you for using Stock Trading Platform!"
                    );

                    sc.close();
                    System.exit(0);

                default:

                    System.out.println(
                            "Please enter a valid option."
                    );
            }
        }
    }


}
