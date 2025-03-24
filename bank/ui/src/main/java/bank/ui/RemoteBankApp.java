package bank.ui;

import java.io.IOException;

import bank.ui.dataaccess.RemoteBankAccess;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class RemoteBankApp extends Application {

  @Override
  public void start(Stage stage) throws IOException {
    FXMLLoader fxmlLoader = new FXMLLoader(this.getClass().getResource("Bank.fxml"));
    BankController controller = new BankController();
    controller.setBankAccess(new RemoteBankAccess()); // Sets the bank access to the remote bank access
    fxmlLoader.setController(controller);
    Parent parent = fxmlLoader.load();
    stage.setScene(new Scene(parent));
    stage.show();
  }

  public static void main(String[] args) {
    launch();
  }
}