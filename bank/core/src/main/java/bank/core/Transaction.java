package bank.core;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

// Allow the 'type' field to remain visible for use in subclasses
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.EXISTING_PROPERTY, property = "type", visible = true)
@JsonSubTypes({
    @JsonSubTypes.Type(value = Deposit.class, name = "true"),
    @JsonSubTypes.Type(value = Withdrawal.class, name = "false")
})

public abstract class Transaction {
  protected double amount;
  protected boolean type;
  protected double balanceAfter;

  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "d.M.yyyy")
  protected LocalDate date;

  /*
   * Default constructor for Transaction
   */
  public Transaction() {
  }

  /**
   * Constructor for Transaction
   * 
   * @param amount       Amount to be deposited or withdrawn
   * @param type         Type of transaction (Deposit=true or Withdrawal=false)
   * @param balanceAfter Balance after transaction
   */
  public Transaction(double amount, boolean type, double balanceAfter) {
    this.amount = amount;
    this.type = type;
    this.balanceAfter = balanceAfter;
    this.date = LocalDate.now();
  }

  /**
   * Returns the amount of the transaction
   * 
   * @return The amount of the transaction
   */
  public double getAmount() {
    return this.amount;
  }

  /**
   * Returns the type of the transaction
   * 
   * @return The type of the transaction (Deposit=true or Withdrawal=false)
   */
  public boolean getType() {
    return this.type;
  }

  /**
   * Returns the balance after the transaction
   * 
   * @return The balance after the transaction
   */
  public double getBalanceAfter() {
    return balanceAfter;
  }

  /**
   * Returns the date of the transaction
   * 
   * @return The date of the transaction as a String in the format "dd.mm.yyyy"
   */
  public String getDate() {
    String day = String.valueOf(date.getDayOfMonth());
    String month = String.valueOf(date.getMonthValue());
    String year = String.valueOf(date.getYear());
    return day + "." + month + "." + year;
  }

  /**
   * Sets date of the transaction
   * 
   * @param date Date of the transaction in LocalDate format
   */
  public void setDate(LocalDate date) {
    this.date = date;
  }
}