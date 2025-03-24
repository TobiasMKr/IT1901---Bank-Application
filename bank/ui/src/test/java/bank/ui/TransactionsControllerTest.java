package bank.ui;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.testfx.framework.junit5.ApplicationTest;
import org.testfx.matcher.control.LabeledMatchers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import bank.ui.dataaccess.LocalBankAccess;

public class TransactionsControllerTest extends ApplicationTest {

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
    controller.setBankAccess(new LocalBankAccess()); // Sets the bank access to the local bank access
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
   * Tests the transactions button by clicking on it and checking if the
   * transactions table is visible
   */
  @Test
  public void testSwitchToMainScene(){
    clickButton("Transactions");
    clickButton("Home");
    Assertions.assertNotNull(lookup("#balanceViewer"), "Balance viewer should be visible");
  }
}
