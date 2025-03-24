package bank.restserver;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import bank.core.Bank;

@AutoConfigureMockMvc
@TestInstance(Lifecycle.PER_CLASS)
@WebMvcTest
public class BankControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @MockBean
  private BankService bankService; // Mock the BankService dependency

  /**
   * Test if the rest server respond
   * 
   * @throws Exception if the server does not respond
   */
  @Test
  public void contextLoads() throws Exception {
    assertNotNull(bankService);
  }

  /**
   * Test if the rest server can get the account
   * 
   * @throws Exception if the server does not respond
   */
  @Test
  public void testGetAccount() throws Exception {
    Bank mockBank = new Bank();
    when(bankService.getAccount()).thenReturn(mockBank);

    mockMvc.perform(get("/bank/account"))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.balance").value(0.0));
  }

  /**
   * Test if the rest server can get the balance
   * 
   * @throws Exception if the server does not respond
   */
  @Test
  public void testGetBalance() throws Exception {
    when(bankService.getBalance()).thenReturn(0.0);
    mockMvc.perform(get("/bank/balance"))
        .andExpect(status().isOk())
        .andExpect(content().string("0.0"));
  }

  /**
   * Test if the rest server can get the transaction history
   * 
   * @throws Exception if the server does not respond
   */
  @Test
  public void testGetTransactions() throws Exception {
    Bank mockBank = new Bank();
    mockBank.deposit(10);
    mockBank.withdrawal(5);
    System.out.println((mockBank.getTransactions().get(0).getBalanceAfter()));

    when(bankService.getTransactions()).thenReturn(mockBank.getTransactions());
    mockMvc.perform(get("/bank/transactions"))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.length()").value(2));
  }

  /**
   * Test if the rest server can deposit money
   * 
   * @throws Exception if the server does not respond
   */
  @Test
  public void testDeposit() throws Exception {
    mockMvc.perform(post("/bank/deposit").param("amount", String.valueOf(10.0)))
        .andExpect(status().isOk());

    verify(bankService).deposit(10.0);

  }

  /**
   * Test if the rest server can withdraw money
   * 
   * @throws Exception if the server does not respond
   */
  @Test
  public void testWithdraw() throws Exception {
    mockMvc.perform(post("/bank/withdraw").param("amount", String.valueOf(10.0)))
        .andExpect(status().isOk());

    verify(bankService).withdraw(10.0);

  }

  /**
   * Test if the rest server can reset the bank
   * 
   * @throws Exception if the server does not respond
   */
  @Test
  public void testReset() throws Exception {
    mockMvc.perform(get("/bank/reset"))
        .andExpect(status().isOk())
        .andExpect(content().string("Success. Bank has been reset"));
  }
}