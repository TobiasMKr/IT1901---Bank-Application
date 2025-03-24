package bank.core;

public class Deposit extends Transaction {

  /**
   * Default constructor for Deposit
   */
  public Deposit() {
    super();
  }

  /**
   * Constructor for Deposit
   * 
   * @param amount       Amount to be deposited
   * @param balanceAfter Balance after deposit
   */
  public Deposit(double amount, double balanceAfter) {
    super(amount, true, balanceAfter);
  }
}
