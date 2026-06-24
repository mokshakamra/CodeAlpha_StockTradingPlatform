# Stock Trading Platform

A Java-based Stock Trading Platform that simulates a basic stock market environment where users can buy and sell stocks, manage their portfolio, track transactions, and monitor portfolio performance. The project is built using Object-Oriented Programming (OOP) principles and includes File I/O for persistent portfolio storage.

## Features

* View available market stocks and prices
* Buy stocks using wallet balance
* Sell owned stocks
* Track portfolio holdings
* Calculate portfolio value
* Monitor profit/loss performance
* View transaction history
* Wallet balance management
* File I/O support for portfolio persistence
* Exception handling for invalid inputs

## Technologies Used

* Java
* Object-Oriented Programming (OOP)
* Collections Framework (ArrayList)
* File Handling (BufferedReader & BufferedWriter)
* Exception Handling

## Project Structure

```text
StockTradingPlatform
│
├── src
│   ├── model
│   │   ├── Stock.java
│   │   ├── PortfolioItem.java
│   │   └── Transaction.java
│   │
│   ├── service
│   │   └── TradingService.java
│   │
│   └── Main.java
│
├── portfolio.txt
└── README.md
```

## Functionalities

### Market Data

Displays available stocks with their symbols, company names, and prices.

### Buy Stocks

Users can purchase stocks if sufficient wallet balance is available.

### Sell Stocks

Users can sell owned stocks and receive funds back into their wallet.

### Portfolio Tracking

Displays owned stocks, quantities, and current portfolio value.

### Portfolio Performance

Calculates:

* Invested Amount
* Current Portfolio Value
* Profit/Loss

### Transaction History

Maintains a record of buy and sell operations during execution.

### Persistent Storage

Portfolio and wallet balance are automatically saved to `portfolio.txt` and loaded when the application starts.

## How to Run

### Clone Repository

```bash
git clone https://github.com/mokshakamra/CodeAlpha_StockTradingPlatform.git
```

### Open Project

Open the project in IntelliJ IDEA or any Java IDE.

### Configure JDK

Use JDK 17 or above.

### Run Application

Run:

```text
Main.java
```

## Sample Stocks

| Symbol | Company   | Price |
| ------ | --------- | ----- |
| AAPL   | Apple     | ₹190  |
| GOOGL  | Google    | ₹250  |
| TSLA   | Tesla     | ₹300  |
| MSFT   | Microsoft | ₹220  |

## OOP Concepts Used

* Encapsulation
* Classes and Objects
* Constructors
* Method Abstraction
* Composition

## Future Enhancements

* Real-time stock price simulation
* User authentication
* Database integration
* GUI using JavaFX or Swing
* Persistent transaction history

## Author

Moksha Kamra

CodeAlpha Java Programming Internship Project

