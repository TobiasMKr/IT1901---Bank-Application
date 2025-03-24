# Constributions

## Hans Henrik Horn Hynne - hhhynne@stud.ntnu.no
Hans Henrik has mostly been working with the frontend. In release 1 he focused on ui, and made the controller and worked with JavaFX. He ensured that the frontend worked correctly with the backend. He also wrote documentation and added the required pictures.

In release 2, Hans Henrik continued to work on the ui. He made the new transactions scene with the new controller, and connected it to the other controller, to make it possible to switch between the scenes. He styled the frontend with css, and made the transactions-table work correctly. Hans Henrik also implemented Checkstyle and Spotbugs to improve code quality. Lastly he wrote a lot of documentation, made diagrams and added pictures of the interface.

In release 3, Hans Henrik made and was responsible for our new client in React. He made it work with the API, in cooperation with Magnus. Hans Henrik wrote all tests for the client with Jest, and implemented Prettier and ESlint for code quality. He also wrote of the documentation for release 3, as well as reviewing a lot of the code with comments and improvements. 


## Tobias Kroll - tobiasmk@stud.ntnu.no
In release one Tobias was responsible, along with Brage, for making the core module, which contains the main class [Bank](/bank/core/src/main/java/bank/core/Bank.java), the abstract class [Transaction](/bank/core/src/main/java/bank/core/Transaction.java), which is implemented by [Deposit](/bank/core/src/main/java/bank/core/Deposit.java) and [Withdrawal](/bank/core/src/main/java/bank/core/Withdrawal.java). These classes are responsible for the logic behind the Bank application, and all the other modules are dependent on core. In this relese Tobias also worked extencivly on implementing JaCoCo covrage to test our test covrage.

In realese two Tobias, with Magnus, was responisble for the persistance module. This module is responsible for the implicit saving model used in the Bank application. Here Tobias decided to use the jackson Library to make serializing and deserializing as easy as possible. Tobias also continued to make sure the JaCoCo covrage was at an accepteble level by making test for both the persostance and core module.

In relese three Tobias had the main responsebility of writing test for the restserver module and UI module. For the restserver module he used mockito to mock get and post requests to test the restserver BankController class. He also tested the BankService class to make sure the classes did as intended. In the UI module he used wiremock to test http requests in the RemoteBankAccess class.

## Magnus Kristensen - magkris@stud.ntnu.no
In release one Magnus was responsible for making the core structure of the project. Setting up the basic folders and configuring the POM-files. He also took lead in inplementing the persistence class, using GSON. At the end of the release, when everything was ready, he added error handling in every class, to limit errors shown to the user.

During release two, Tobias and Magnus, took responsibility, converting the JSONHandler class over to Jackson. After the switch had been implemented, they added more logic to the class, making it possible to store more data. Tobias and Magnus, also worked together to adapt the classes in Core, making them compatible with Jackson. At the end, Magnus took lead in enhancing the code quality, fixing all reported spotbugs and checkstyle problems.

In release 3 Magnus, in cooperation with Hans Henrik, worked on creating the REST API and helped setting up the logic in React. Magnus also made necessary changes to the UI module, to make it work both localy and remote. In collaboration with Tobias, he set up CI/CD Pipelines in gitlab. Magnus also made the product shippable using JPackage. He also ensured code quality and converted comments into JavaDocs.

## Brage Jetne - brageaj@stud.ntnu.no
In release one Brage was, along with Tobias, responsible for creating the core module. This module contains [Bank](/bank/core/src/main/java/bank/core/Bank.java), the abstract class [Transaction](/bank/core/src/main/java/bank/core/Transaction.java), which is implemented by [Deposit](/bank/core/src/main/java/bank/core/Deposit.java) and [Withdrawal](/bank/core/src/main/java/bank/core/Withdrawal.java). These four different classes are responsible for some of the logic in our Bank Application. The other modules depend on the core module in order to function as intended. 

In release two, Brage was mainly responsible for making tests regarding the ui module. The tests that were made, was [BankControllerTest](bank/ui/src/test/BankControllerTest.java) and [TransactionsController](bank/ui/src/test/TransactionsController.java). The BankControllerTest is responsible for testing every function the BankController contains, mainly testing that our ui is working as intended. The TransactionsControllerTest is responsible for switching between the main scene and transactions scene.

In release three, Brage was mainly responsible for the documentation. He made most of the [Diagrams](docs/release3/Diagrams) and wrote the document regarding [sustainability](docs/release3/sustainability.md). He also updated the readme-files in order for them to appear similar to each other.