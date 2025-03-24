package bank.core;

import java.util.ArrayList;
import java.util.List;

public class Bank {
  private double balance;
  private List<Transaction> transactions;

  /**
   * Constructor for Bank class
   */
  public Bank() {
    this.balance = 0;
    this.transactions = new ArrayList<>();
  }

  /**
   * Withdrawal method. Withdraws money from the bank account
   * 
   * @param amount Amount to be withdrawn
   * @throws IllegalArgumentException If amount is less than 0
   */
  public void withdrawal(double amount) {
    if (amount < 0) {
      throw new IllegalArgumentException("Amount can't be less than 0");
    }
    if (amount > balance) {
      throw new IllegalStateException("Can't withdraw more than balance");
    }
    this.balance -= amount;
    Withdrawal withdrawal = new Withdrawal(amount, balance);
    this.transactions.add(0, withdrawal);
  }

  /**
   * Deposit method. Deposits money into the bank account
   * 
   * @param amount Amount to be deposited
   * @throws IllegalArgumentException If amount is less than 0
   */
  public void deposit(double amount) {
    if (amount < 0) {
      throw new IllegalArgumentException("Amount can't be less than 0");
    }
    this.balance += amount;
    Deposit deposit = new Deposit(amount, balance);
    this.transactions.add(0, deposit);
  }

  /**
   * Returns the current balance of the account
   * 
   * @return The current balance of the account
   */
  public double getBalance() {
    return balance;
  }

  /**
   * Returns the transaction history of the account
   * 
   * @return List of transactions
   */
  public List<Transaction> getTransactions() {
    return new ArrayList<>(transactions);
  }

  /**
   * Sets the balance of the account
   * 
   * @param balance The balance to be set
   * @throws IllegalArgumentException If balance is less than 0
   */
  public void setBalance(double balance) {
    if (balance < 0) {
      throw new IllegalArgumentException("Balance cannot be less than zero");
    }
    this.balance = balance;
  }

  /**
   * Sets the transaction history of the account
   * 
   * @param transactions List of transactions
   */
  public void setTransactions(List<Transaction> transactions) {
    this.transactions = new ArrayList<Transaction>(transactions);
  }
}