package bank.core;

public class Withdrawal extends Transaction {

  /**
   * Default constructor
   */
  public Withdrawal() {
    super();
  }

  /**
   * Constructor
   * 
   * @param withdrawal_amount amount to withdraw
   * @param balanceAfter      balance after withdrawal
   */
  public Withdrawal(double withdrawal_amount, double balanceAfter) {
    super(withdrawal_amount, false, balanceAfter);
  }
}