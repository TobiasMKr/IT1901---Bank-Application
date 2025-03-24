package bank.ui.dataaccess;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpResponse;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import bank.core.Bank;
import bank.core.Transaction;

public class RemoteBankAccess implements BankAccess {
  private ObjectMapper mapper;

  // Creates a new ObjectMapper and registers the JavaTimeModule
  public RemoteBankAccess() {
    this.mapper = new ObjectMapper();
    mapper.registerModule(new JavaTimeModule());
  }

  // Sends a GET request to the server to get the balance
  public Double getBalance() {
    try {
      HttpRequest request = HttpRequest.newBuilder(new URI("http://localhost:8080/bank/balance"))
          .header("Accept", "application/json")
          .GET()
          .build();
      HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());

      return mapper.readValue(response.body().toString(), Double.class);
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  // Sends a GET request to the server to get the Bank object
  protected Bank getBank() {
    try {
      HttpRequest request = HttpRequest.newBuilder(new URI("http://localhost:8080/bank/account"))
          .header("Accept", "application/json")
          .GET()
          .build();
      HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());

      return mapper.readValue(response.body().toString(), Bank.class);
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  // Sends a GET request to the server to get the transactions
  public List<Transaction> getTransactions() {
    Bank bank = getBank();
    return bank.getTransactions();
  }

  // Sends a POST request to the server to deposit the amount
  public void deposit(Double amount) {
    try {
      HttpRequest request = HttpRequest.newBuilder()
          .uri(new URI("http://localhost:8080/bank/deposit"))
          .header("Content-Type", "application/x-www-form-urlencoded")
          .POST(BodyPublishers.ofString("amount=" + String.valueOf(amount)))
          .build();

      HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  // Sends a POST request to the server to withdraw the amount
  public void withdrawal(Double amount) {
    try {
      HttpRequest request = HttpRequest.newBuilder()
          .uri(new URI("http://localhost:8080/bank/withdraw"))
          .header("Content-Type", "application/x-www-form-urlencoded")
          .POST(BodyPublishers.ofString("amount=" + String.valueOf(amount)))
          .build();

      HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  // Sends a GET request to the server to reset the bank
  public void reset() {
    try {
      HttpRequest request = HttpRequest.newBuilder(new URI("http://localhost:8080/bank/reset"))
          .header("Accept", "application/json")
          .GET()
          .build();
      HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
    } catch (Exception e) {
      throw new RuntimeException(e);
    }

  }
}
