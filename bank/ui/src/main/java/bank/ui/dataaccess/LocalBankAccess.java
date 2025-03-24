package bank.ui.dataaccess;

import java.util.List;

import bank.core.Bank;
import bank.core.Transaction;
import bank.persistence.JSONHandler;

public class LocalBankAccess implements BankAccess {

  private Bank bank;
  private JSONHandler jsonHandler;
  private final static String path = "bank.json";

  // Tries to read the balance from the file, if it fails, creates a new Bank
  // object
  public LocalBankAccess() {
    this.jsonHandler = new JSONHandler(path);
    try {
      bank = jsonHandler.readValue();
    } catch (Exception e) {
      bank = new Bank();
      e.printStackTrace();
    }
  }

  public Double getBalance() {
    return bank.getBalance();
  }

  public void deposit(Double amount) {
    bank.deposit(amount);
    jsonHandler.writeValue(bank);
  }

  public void withdrawal(Double amount) {
    bank.withdrawal(amount);
    jsonHandler.writeValue(bank);
  }

  public List<Transaction> getTransactions() {
    return bank.getTransactions();
  }

  public void reset() {
    bank = new Bank();
    jsonHandler.writeValue(bank);
  }
}
