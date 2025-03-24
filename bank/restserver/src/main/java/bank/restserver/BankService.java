package bank.restserver;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import bank.core.Bank;
import bank.core.Transaction;
import bank.persistence.JSONHandler;

@Service
public class BankService {

  private final static String path = "bank.json";
  private Bank bank;
  private JSONHandler jsonHandler;

  /**
   * Constructor
   */
  public BankService() {
    jsonHandler = new JSONHandler(path);
    try {
      bank = jsonHandler.readValue();
    } catch (Exception e) {
      bank = new Bank();
      jsonHandler.writeValue(bank);
    }
  }

  /**
   * Get the account
   * 
   * @return bank object
   */
  public Bank getAccount() {
    Bank bankCopy = new Bank();
    bankCopy.setBalance(this.bank.getBalance());
    bankCopy.setTransactions(this.bank.getTransactions());
    return bankCopy;
  }

  /**
   * Get the balance
   * 
   * @return balance
   */
  public double getBalance() {
    return bank.getBalance();
  }

  /**
   * Deposit funds into the account and
   * writes the updated bank object to the JSON file
   * 
   * @param amount the amount to deposit
   */
  public void deposit(double amount) {
    bank.deposit(amount);
    jsonHandler.writeValue(bank);
  }

  /**
   * Withdraw funds from the account and
   * writes the updated bank object to the JSON file
   * 
   * @param amount the amount to withdraw
   */
  public void withdraw(double amount) {
    bank.withdrawal(amount);
    jsonHandler.writeValue(bank);
  }

  /**
   * Get the transactions
   * 
   * @return list of transactions
   */
  public List<Transaction> getTransactions() {
    return new ArrayList<>(bank.getTransactions());
  }

  /**
   * Reset the bank
   * Write a new bank object to the JSON file
   */
  public void reset() {
    bank = new Bank();
    jsonHandler.writeValue(bank);
  }
}
