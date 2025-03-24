# _Restserver_

The restserver module is responsible for creating a REST API, making communication between frontend and backend. We used SpringBoot to create this API. The controller module is responsible for creating endpoints, while the service class is responsible for handling the logic after each endpoints is called. The BankServerApp primary function is to launch the server, but we had to implement CORS-configuration with Bean to make the endpoints accesible with React. The server is launched at the HTTP address: http://localhost:8080/bank

## _Implemented HTTP-requests_

* **GET /account** - Returns the Bank-object
* **GET /balance** - Returns the current balance
* **GET /transactions** - Returns a list of transaction objects
* **POST /deposit** - Creates a new deposit object and updates the bank accordingly
* **POST /withdraw** - Creates a new withdrawal object and updates the bank accordingly
* **GET /reset** - Resets the bank. Used in testing. Returns a String if it was successful

## _Files in restserver module_

### _Classes_
[BankController](/bank/restserver/src/main/java/bank/restserver/BankController.java) -> Responsible for creating endpoints\
[BankServerApp](/bank/restserver/src/main/java/bank/restserver/BankServerApp.java) -> Launches the server\
[BankService](/bank/restserver/src/main/java/bank/restserver/BankService.java) -> Handles the logic after each endpoint is called


### _Tests_
[BankControllerTest](/bank/restserver/src/test/java/bank/restserver/BankControllerTest.java) -> Testing the get and post functionality in `BankController`, and verifing that the class has conection to the Rest-API\
[BankServiceTest](/bank/restserver/src/test/java/bank/restserver/BankServiceTest.java) -> Verifing that the methods in `BankService` return the correct values, and are working according to javadoc.

## _Class diagram_
![here](/docs/release3/Diagrams/RestserverClassDiagram.png)