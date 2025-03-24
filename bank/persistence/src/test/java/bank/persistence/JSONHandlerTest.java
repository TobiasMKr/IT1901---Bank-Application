package bank.persistence;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import bank.core.Bank;
import bank.core.Transaction;

public class JSONHandlerTest {

  private Bank bank;
  private JSONHandler jsonHandler;

  /**
   * Removes the file after each test
   */
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
   * Create a new Bank object and JSONHandler object before each test
   */
  @BeforeEach
  public void beforeEach() {
    this.bank = new Bank();
    this.jsonHandler = new JSONHandler("bank.json");
  }

  /**
   * Test that the read and write value methods work as expected
   * 
   * @throws IOException If the file is not found
   */
  @Test
  public void testReadWriteValue() throws IOException {
    bank.deposit(200);
    jsonHandler.writeValue(bank);
    Bank bank2 = jsonHandler.readValue();
    Transaction deposit = jsonHandler.readValue().getTransactions().get(0);
    assertEquals(bank2.getBalance(), bank.getBalance());
    assertEquals(deposit.getAmount(), bank.getTransactions().get(0).getAmount());
    assertEquals(deposit.getDate(), bank.getTransactions().get(0).getDate());
  }

  /**
   * Test that write value does not throw an exception
   */
  @Test
  public void testWriteException() {
    this.jsonHandler = new JSONHandler("notBank.json");
    bank.deposit(200);
    assertDoesNotThrow(() -> jsonHandler.writeValue(bank));
  }

}