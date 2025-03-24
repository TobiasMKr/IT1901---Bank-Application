package bank.ui;

import java.io.IOException;

import bank.core.Transaction;
import bank.ui.dataaccess.BankAccess;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class TransactionsController {

  private BankAccess dataAccess;

  @FXML
  private TableView<Transaction> tableview;
  @FXML
  private TableColumn<Transaction, String> type;
  @FXML
  private TableColumn<Transaction, String> dato;
  @FXML
  private TableColumn<Transaction, String> beløp;
  @FXML
  private TableColumn<Transaction, String> saldoetter;

  /**
   * Loads transactions to tableview
   */
  @FXML
  public void loadTransactions() {
    type.setCellValueFactory(new PropertyValueFactory<>("type"));
    dato.setCellValueFactory(new PropertyValueFactory<>("date"));
    beløp.setCellValueFactory(new PropertyValueFactory<>("amount"));
    saldoetter.setCellValueFactory(new PropertyValueFactory<>("balanceAfter"));
    transactions();
  }

  /**
   * Gets transactions from dataAccess and adds them to tableview
   */
  public void transactions() {
    tableview.getItems().clear();
    for (Transaction transaction : dataAccess.getTransactions()) {
      tableview.getItems().add(transaction);

    }
    tableview.refresh();
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
   * Switches to the main scene
   * 
   * @throws IOException if the fxml file is not found
   */
  public void switchToMainScene(final ActionEvent event) throws IOException {
    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Bank.fxml"));
    BankController controller = new BankController();
    fxmlLoader.setController(controller);
    controller.setBankAccess(dataAccess);
    Parent root = fxmlLoader.load();
    Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    stage.setScene(new Scene(root));
    stage.show();
    controller.initialize();
  }
}
