package bank.ui;

import java.io.IOException;

import bank.ui.dataaccess.LocalBankAccess;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * JavaFX App.
 */
public class BankApp extends Application {

  @Override
  public void start(Stage stage) throws IOException {
    FXMLLoader fxmlLoader = new FXMLLoader(this.getClass().getResource("Bank.fxml"));
    BankController controller = new BankController();
    controller.setBankAccess(new LocalBankAccess()); // Sets the bank access to the local bank access
    fxmlLoader.setController(controller);
    Parent parent = fxmlLoader.load();
    stage.setScene(new Scene(parent));
    stage.show();
  }

  public static void main(String[] args) {
    launch();
  }
}
