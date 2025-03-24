package bank.restserver;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import bank.core.Bank;
import bank.core.Transaction;

@RestController
@RequestMapping("/bank")
public class BankController {

  private final BankService bankService;

  /**
   * Constructor
   * 
   * @param bankService the bank service
   */
  @Autowired
  public BankController(final BankService bankService) {
    this.bankService = bankService;
  }

  /**
   * Get the account
   * 
   * @return bank object
   */
  @GetMapping(path = "/account")
  public Bank getAccount() {
    return bankService.getAccount();
  }

  /**
   * Home page
   * 
   * @return welcome message
   */
  @GetMapping()
  public String home() {
    return "Welcome to the bank!";
  }

  /**
   * Get the balance
   * 
   * @return balance
   */
  @GetMapping(path = "/balance")
  public double getBalance() {
    return bankService.getBalance();
  }

  /**
   * Get the transactions
   * 
   * @return list of transactions
   */
  @GetMapping(path = "/transactions")
  public List<Transaction> getTransactions() {
    return new ArrayList<>(bankService.getTransactions());
  }

  /**
   * Deposit funds into account
   * 
   * @param amount the amount to deposit
   */
  @PostMapping(path = "/deposit")
  public void deposit(@RequestParam double amount) {
    bankService.deposit(amount);
  }

  /**
   * Withdraw from account
   * 
   * @param amount the amount to withdraw
   */
  @PostMapping(path = "/withdraw")
  public void withdraw(@RequestParam double amount) {
    bankService.withdraw(amount);
  }

  /**
   * Reset the bank
   * 
   * @return success message
   */
  @GetMapping(path = "/reset")
  public String reset() {
    bankService.reset();
    return "Success. Bank has been reset";
  }

}