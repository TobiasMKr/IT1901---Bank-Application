package bank.ui;

import java.io.IOException;

import bank.ui.dataaccess.BankAccess;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class BankController {

  private BankAccess dataAccess;

  @FXML
  private TextField depositText, withdrawalText;

  @FXML
  private Button depositButtin, withdrawalButton;

  @FXML
  public Label balanceViewer;

  /**
   * Initializes the controller class.
   */
  @FXML
  public void initialize() {
    updateBalance();
  }

  /**
   * Deposits the amount in the depositText field.
   * If the amount is not a number or the deposit fails, the field is cleared.
   */
  @FXML
  public void doDeposit() {
    String input = depositText.getText();

    try {
      Double.parseDouble(input);
    } catch (Exception e) {
      depositText.setText(null);
      return;
    }

    try {
      dataAccess.deposit(Double.parseDouble(input));
    } catch (IllegalArgumentException e) {
      withdrawalText.setText(null);
      return;
    }

    this.updateBalance();
    depositText.setText(null);
  }

  /**
   * Withdraws the amount in the withdrawalText field.
   * If the amount is not a number or the withdrawal fails, the field is cleared.
   */
  @FXML
  public void doWithdrawal() {
    String input = withdrawalText.getText();
    try {
      Double.parseDouble(input);
    } catch (Exception e) {
      withdrawalText.setText(null);
      return;
    }

    try {
      dataAccess.withdrawal(Double.parseDouble(input));
    } catch (IllegalStateException | IllegalArgumentException e) {
      withdrawalText.setText(null);
      return;
    }

    this.updateBalance();
    withdrawalText.setText(null);
  }

  /**
   * Updates the balance in the balanceViewer.
   */
  public void updateBalance() {
    balanceViewer.setText(Double.toString(dataAccess.getBalance()));
  }

  /**
   * Returns the balance in the balanceViewer.
   */
  @FXML
  public String getBalance() {
    return balanceViewer.getText();
  }

  /**
   * Clears the bank object.
   */
  public void clearBankObject() {
    dataAccess.reset();
    updateBalance();
  }

  /**
   * Sets the bank access object, to determine whether the bank is local or
   * remote.
   * 
   * @param dataAccess either LocalBankAccess or RemoteBankAccess
   */
  public void setBankAccess(BankAccess dataAccess) {
    this.dataAccess = dataAccess;
  }

  /**
   * Switches to the Transactions view.
   * 
   * @exception IOException if the FXML file cannot be loaded
   */
  @FXML
  public void switchToTransactions(ActionEvent event) throws IOException {
    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Transactions.fxml"));
    TransactionsController controller = new TransactionsController();
    controller.setBankAccess(dataAccess);
    fxmlLoader.setController(controller);
    Parent root = fxmlLoader.load();
    Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    stage.setScene(new Scene(root));
    stage.show();
    controller.loadTransactions();
  }

}
