# _UI module_

The ui module is responsible for the application's user interface. It contains the [BankApp](/bank/ui/src/main/java/bank/ui/BankApp.java),[BankController](/bank/ui/src/main/java/bank/ui/BankController.java) and [TransactionsController](/bank/ui/src/main/java/bank/ui/TransactionsController.java) classes. The BankController links the internal logic to the user interface, BankApp is responsible for launching the app and TransactionsController is responsible for loading and storing the former transactions. The module also contains the FXML files [Bank](/bank/ui/src/main/resources/bank/ui/Bank.fxml) and [Transactions](/bank/ui/src/main/resources/bank/ui/Transactions.fxml) located in the resources folder. The Bank.FXML file is responsible for the setup on the front page, and Transactions.FXML is responsible for the setup in the transactions-scene.

The ui module also contains [Bank.css](/bank/ui/src/main/resources/bank/ui/Bank.css), responsible for the styling of the application.

## _Tests for UI module_
[BankControllerTest](/bank/ui/src/test/java/bank/ui/BankControllerTest.java) -> Verifies the bank operations; deposit and withdrawal, ensuring that the balance is updated accurately based on user actions.\
[TransactionsControllerTest](/bank/ui/src/test/java/bank/ui/TransactionsControllerTest.java) -> Focuses on the functionality of the transactions view, confirming that the application correctly displays transaction details when navigated to by the user.
#### _In dataaccess folder:_
[RemoteBankAccessTest](/bank/ui/src/test/java/bank/ui/dataaccess/RemoteBankAccessTest.java) -> Verifies that the HTTP requests return the correct values, and are working acording to javadoc.

This project contains unit tests for the Bank application's user interface, targeting the `BankController`, `TransactionsController` and `RemoteBankAccess` classes. The tests use the TestFX framework to simulate user interactions in the JavaFX environment, ensuring that core functionalities operate correctly. `RemoteBankAccess` Uses wiremock to mock HTTP requests, this is used for testing the `get` and `put` functionality.

## _Class diagram_
![here](/docs/release3/Diagrams/UIClassDiagram.png)
