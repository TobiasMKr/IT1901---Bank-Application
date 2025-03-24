package bank.core;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class BankTest {

  /**
   * Testing the constructor
   */
  @Test
  public void testConstructor(){
    Bank a = new Bank();
    //Checking if the balance is 0
    assertEquals(0, a.getBalance());
    //Checking if the transaction list is empty
    assertEquals(0, a.getTransactions().size());
  }

  /**
    * Testing the withdrawal method, of class Bank.
   */
  @Test
  public void testWithdrawal() {
    // Checking for exceptions when trying to withdraw negetive sum
    assertThrows(IllegalArgumentException.class, () -> new Bank().withdrawal(-1));
    Bank a = new Bank();
    a.deposit(100);
    double before = a.getBalance();
    a.withdrawal(50);
    // Checking if balance is correct after withdrawal
    assertEquals(before - 50, a.getBalance());
    // Cheking if exception is thrown when trying to withdraw more than saldo
    assertThrows(IllegalStateException.class, () -> a.withdrawal(10000));
  }

  /**
   * Test of deposit method, of class Bank.
   */
  @Test
  public void testDeposit() {
    // Checking for exceptions when trying to deposit negetive sum
    assertThrows(IllegalArgumentException.class, () -> new Bank().deposit(-1));
    Bank a = new Bank();
    double before = a.getBalance();
    a.deposit(100);
    // Checking if balance is correct after deposit
    assertEquals(before + 100, a.getBalance());
  }
  
  /**
   * Testing the getTransaction method
   */
  @Test
  public void testGetTransaction() {
    Bank a = new Bank();
    a.deposit(100);
    a.withdrawal(50);
    //Checking if the transaction list is correct
    assertEquals(2, a.getTransactions().size());
    //Checking if the balance is correct
    assertEquals(50, a.getTransactions().get(0).amount);
  }

  /**
   * Testing the getBalance method
   */
  @Test
  public void testSetBalance(){
    Bank a = new Bank();
    a.setBalance(100);
    //Checking if the balance is correct
    assertEquals(100, a.getBalance());
    //Checking if exception is thrown when trying to set balance to negetive
    assertThrows(IllegalArgumentException.class, () -> a.setBalance(-1));
  }

  /**
   * Testing the setTransactions method
   */
  @Test
  public void testSetTransactions(){
    Bank a = new Bank();
    a.deposit(100);
    a.withdrawal(50);
    Bank b = new Bank();
    b.setTransactions(a.getTransactions());
    //Checking if the transaction list is correct
    assertEquals(2, b.getTransactions().size());
    //Checking if the balance is correct
    assertEquals(50, b.getTransactions().get(0).amount);
  }
}
