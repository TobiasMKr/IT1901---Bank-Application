package bank.ui.dataaccess;

import java.util.List;
import bank.core.Transaction;

/**
 * Interface for accessing bank account data.
 */
public interface BankAccess {

  /**
   * Retrieves the current balance of the bank account.
   *
   * @return the current balance as a Double.
   */
  public Double getBalance();

  /**
   * Deposits a specified amount into the bank account.
   *
   * @param amount the amount to deposit as a Double.
   */
  public void deposit(Double amount);

  /**
   * Withdraws a specified amount from the bank account.
   *
   * @param amount the amount to withdraw as a Double.
   */
  public void withdrawal(Double amount);

  /**
   * Retrieves a list of transactions made on the bank account.
   *
   * @return a List of Transaction objects.
   */
  public List<Transaction> getTransactions();

  /**
   * Resets the bank account data.
   */
  public void reset();
}
