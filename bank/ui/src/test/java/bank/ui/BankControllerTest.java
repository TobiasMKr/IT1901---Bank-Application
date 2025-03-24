package bank.ui;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.testfx.framework.junit5.ApplicationTest;
import org.testfx.matcher.control.LabeledMatchers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import bank.ui.dataaccess.LocalBankAccess;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class BankControllerTest extends ApplicationTest {

  private BankController controller;
  @FXML
  private Label balanceViewer;

  /**
   * Sets up the stage for the test
   */
  @Override
  public void start(Stage stage) throws Exception {
    FXMLLoader fxmlLoader = new FXMLLoader(this.getClass().getResource("Bank.fxml"));
    this.controller = new BankController();
    controller.setBankAccess(new LocalBankAccess());
    fxmlLoader.setController(controller);
    Parent parent = fxmlLoader.load();
    stage.setScene(new Scene(parent));
    stage.show();
  }

  /**
   * Clicks on a button with the given label
   * 
   * @param label button label
   */
  private void clickButton(String label) {
    clickOn(LabeledMatchers.hasText(label));
  }

  /**
   * Enters text into a field with the given id
   * 
   * @param fieldId id of the field
   * @param text    to enter
   */
  private void enterText(String fieldId, String text) {
    clickOn(fieldId);
    write(text);
  }

  /**
   * Gets the balance before a transaction
   * 
   * @return the balance before the transaction
   */
  private double getBalanceBefore() {
    return Double.parseDouble(controller.getBalance().split("\s")[0]);
  }

  /**
   * Tests the deposit functionality
   */
  @Test
  public void testDeposit() {
    double initialBalance = getBalanceBefore();
    double depositAmount = 1000.00;
    enterText("#depositText", "1000.00");
    clickButton("Deposit");
    double balanceAfterDeposit = getBalanceBefore();
    double expectedBalance = initialBalance + depositAmount;

    Assertions.assertEquals(expectedBalance, balanceAfterDeposit, "Balance after deposit is incorrect");
  }

  /**
   * Tests the withdrawal functionality
   */
  @Test
  public void testWithdrawal() {
    double initialBalance = getBalanceBefore();
    double withdrawalAmount = 500.00;
    enterText("#withdrawalText", "500.00");
    clickButton("Withdraw");
    clickButton("Transactions");
    double balanceAfterWithdrawal = getBalanceBefore();
    double expectedBalance = initialBalance - withdrawalAmount;
    Assertions.assertEquals(expectedBalance, balanceAfterWithdrawal, "Balance after withdrawal is incorrect");
  }

  @Test
  public void testSwitchToTransactions() {
    clickButton("Transactions");
    Assertions.assertNotNull(lookup("#tableview"), "Transactions table should be visible");
  }

  /**
   * Clears the bank object after all tests are run
   */
  @AfterAll
  public void clearBank() {
    controller.clearBankObject();
  }
}
