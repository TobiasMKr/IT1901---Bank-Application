package bank.restserver;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

import bank.core.Bank;
import bank.persistence.JSONHandler;

@TestInstance(Lifecycle.PER_CLASS)
public class BankServiceTest {

  private BankService bankService;

  /**
   * Remove the balance.json file before all tests and after each test
   */
  @BeforeAll
  @AfterEach
  public void clean() {
    Bank bank = new Bank();
    JSONHandler jsonHandler = new JSONHandler("bank.json");
    try {
      jsonHandler.writeValue(bank);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * Create a new BankService object before each test and aftre all tests have ran
   */
  @AfterAll
  @BeforeEach
  public void beforeEach() {
    bankService = new BankService();
  }

  /**
   * Test if you can get the account
   */
  @Test
  public void testGetAccount() {
    Bank bank = bankService.getAccount();
    assertNotNull(bank);
    assertEquals(0.0, bank.getBalance());
    assertEquals(0, bank.getTransactions().size());
  }

  /**
   * Test if you can get the balance
   */
  @Test
  public void testGetBalance() {
    assertEquals(0.0, bankService.getBalance());
  }

  /**
   * Test if you can deposit money
   */
  @Test
  public void testDeposit() {
    bankService.deposit(10.0);
    assertEquals(10, bankService.getBalance());
  }

  /**
   * Test if you can withdraw money
   */
  @Test
  public void testWithdraw() {
    bankService.deposit(10.0);
    bankService.withdraw(5.0);
    assertEquals(5, bankService.getBalance());
  }

  /**
   * Test if you can get the transaction history
   */
  @Test
  public void testGetTransactions() {
    bankService.deposit(10.0);
    bankService.withdraw(5.0);
    assertEquals(2, bankService.getTransactions().size());
    assertEquals(10.0, bankService.getTransactions().get(1).getAmount());
    assertEquals(5, bankService.getTransactions().get(0).getBalanceAfter());
  }

  /**
   * Test if you can reset the account
   */
  @Test
  public void testReset() {
    bankService.deposit(10.0);
    assertEquals(1, bankService.getTransactions().size());
    bankService.reset();
    assertEquals(0, bankService.getTransactions().size());
  }
}
