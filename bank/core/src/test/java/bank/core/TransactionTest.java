package bank.core;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;

public class TransactionTest {

  /**
   * Get current date
   * 
   * @return current date in format dd.mm.yyyy
   */
  public String getDate() {
    LocalDateTime date = LocalDateTime.now();
    String day = String.valueOf(date.getDayOfMonth());
    String month = String.valueOf(date.getMonthValue());
    String year = String.valueOf(date.getYear());
    return day + "." + month + "." + year;
  }

  /**
   * Test creation of deposit
   */
  @Test
  public void testDeposit() {
    assertThrows(IllegalArgumentException.class, () -> new Bank().deposit(-1));
    Deposit a = new Deposit(100, 100);
    assertEquals(getDate(), a.getDate());
    assertEquals(true, a.getType());
    assertEquals(100, a.getAmount());
    assertEquals(100, a.getBalanceAfter());
  }

  /**
   * Test creation of withdrawal
   */
  @Test
  public void testWithdrawal() {
    assertThrows(IllegalArgumentException.class, () -> new Bank().withdrawal(-1));
    Withdrawal a = new Withdrawal(100, 100);
    assertEquals(getDate(), a.getDate());
    assertEquals(false, a.getType());
    assertEquals(100, a.getAmount());
    assertEquals(100, a.getBalanceAfter());
  }

}
