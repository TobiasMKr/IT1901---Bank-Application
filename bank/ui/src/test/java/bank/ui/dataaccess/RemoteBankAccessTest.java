package bank.ui.dataaccess;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.equalTo;
import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static com.github.tomakehurst.wiremock.client.WireMock.post;
import static com.github.tomakehurst.wiremock.client.WireMock.postRequestedFor;
import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo;
import static com.github.tomakehurst.wiremock.client.WireMock.getRequestedFor;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.WireMock;

import bank.core.Bank;
import bank.core.Transaction;

public class RemoteBankAccessTest {

  private WireMockServer wireMockServer;
  private RemoteBankAccess remoteBankAccess;

  
  /**
   * Setup Before RemoteBankAccessTest
   */
  @BeforeEach
  public void setup() {
    // Start WireMock server on port 8080
    wireMockServer = new WireMockServer(8080);
    wireMockServer.start();

    // Configure WireMock for local testing
    WireMock.configureFor("localhost", 8080);

    // Initialize RemoteBankAccess instance
    remoteBankAccess = new RemoteBankAccess();
  }

  @AfterEach
  public void teardown() {
    wireMockServer.stop();
  }

  /**
   * Tests if getBalance() works as expected
   * @throws Exception
   */
  @Test
  public void testGetBalance() throws Exception {
    // Stub the /bank/balance endpoint to return a balance of 1000.0
    wireMockServer.stubFor(get(urlEqualTo("/bank/balance"))
        .willReturn(aResponse()
            .withStatus(200)
            .withHeader("Content-Type", "application/json")
            .withBody("1000.0")));

    // Call the getBalance method
    Double balance = remoteBankAccess.getBalance();

    // Verify the result
    assertThat(balance).isEqualTo(1000.0);
  }

  /**
   * Tests if getBank() works as expected
   */
  @Test
  public void testGetBank() throws Exception {
    // Define a sample Bank object in JSON format
    String bankJson = "{ \"balance\": 0.0, \"transactions\":[]}";

    // Stub the /bank/account endpoint to return the bankJson
    wireMockServer.stubFor(get(urlEqualTo("/bank/account"))
        .willReturn(aResponse()
            .withStatus(200)
            .withHeader("Content-Type", "application/json")
            .withBody(bankJson)));

    // Verify the result
    assertThat(remoteBankAccess.getBank() instanceof Bank);
  }

  /**
   * Tests if getTransactions() works as expected
   */
  @Test
  public void testGetTransactions() {
    // Define a sample Bank object with transactions in JSON format
    String bankJson = """
        {
          "balance":50.0,
          "transactions":[
            {"amount":50.0,"type":false,"balanceAfter":50.0,"date":"7.11.2024"},
            {"amount":100.0,"type":true,"balanceAfter":100.0,"date":"7.11.2024"}
          ]
        }
        """;

    // Stub the /bank/account endpoint to return the bankJson with transactions
    wireMockServer.stubFor(get(urlEqualTo("/bank/account"))
        .willReturn(aResponse()
            .withStatus(200)
            .withHeader("Content-Type", "application/json")
            .withBody(bankJson)));

    // Call the getTransactions method
    List<Transaction> transactions = remoteBankAccess.getTransactions();

    // Verify the result
    assertThat(transactions).hasSize(2);
    assertThat(transactions.get(0).getAmount() == 50.0);
    assertThat(transactions.get(1).getAmount() == 100);
  }

  /**
   * Tests if deposit() works as expected
   */
  @Test
  public void testDeposit() {
    // Define the deposit amount
    Double depositAmount = 500.0;

    // Stub the /bank/deposit endpoint to accept a POST request
    wireMockServer.stubFor(post(urlEqualTo("/bank/deposit"))
        .withHeader("Content-Type", equalTo("application/x-www-form-urlencoded"))
        .withRequestBody(equalTo("amount=" + depositAmount))
        .willReturn(aResponse()
            .withStatus(200)
            .withBody("Deposit successful")));

    // Call the deposit method
    remoteBankAccess.deposit(depositAmount);

    // Verify that the request was sent as expected
    wireMockServer.verify(postRequestedFor(urlEqualTo("/bank/deposit"))
        .withHeader("Content-Type", equalTo("application/x-www-form-urlencoded"))
        .withRequestBody(equalTo("amount=" + depositAmount)));
  }
  /**
   * Tests if withdrawal() works as excpected
   */
  @Test
  public void testWithdrawal() {
    // Define the withdrawal amount
    Double withdrawalAmount = 200.0;

    // Stub the /bank/withdraw endpoint to accept a POST request
    wireMockServer.stubFor(post(urlEqualTo("/bank/withdraw"))
        .withHeader("Content-Type", equalTo("application/x-www-form-urlencoded"))
        .withRequestBody(equalTo("amount=" + withdrawalAmount.toString())) // Ensure amount is converted to String
        .willReturn(aResponse()
            .withStatus(200)
            .withBody("Withdrawal successful")));

    // Call the withdrawal method
    remoteBankAccess.withdrawal(withdrawalAmount);

    // Verify that the request was sent as expected
    wireMockServer.verify(postRequestedFor(urlEqualTo("/bank/withdraw"))
        .withHeader("Content-Type", equalTo("application/x-www-form-urlencoded"))
        .withRequestBody(equalTo("amount=" + withdrawalAmount.toString()))); // Ensure amount is converted to String
  }
  /**
   * Tests if reset() works as expected
   */
  @Test
  public void testReset() {
    // Stub the /bank/reset endpoint to accept a GET request
    wireMockServer.stubFor(get(urlEqualTo("/bank/reset"))
        .withHeader("Accept", equalTo("application/json"))
        .willReturn(aResponse()
            .withStatus(200)
            .withBody("Bank reset successful")));

    // Call the reset method
    remoteBankAccess.reset();

    // Verify that the request was sent as expected
    wireMockServer.verify(getRequestedFor(urlEqualTo("/bank/reset"))
        .withHeader("Accept", equalTo("application/json")));
  }
}
