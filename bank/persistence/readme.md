# _Persistence module_

The persistence module contains the [JSONHandler](/bank/persistence/src/main/java/bank/persistence/JSONHandler.java) which is responsible for writing and reading from bank.json. This file contains all the data for the transactions and balance.

## _Implicit-saving model_
Implicit saving means automatically saving changes to the system without requiring the user to manually click "Save" or perform an additional action. In the context of a bank application, this can lead to a smoother, more intuitive experience for the user, as they don't need to worry about explicitly saving data after each transaction or update. Implicit saving can ensure that data is consistently saved and updated across the system. In a banking context, it’s crucial that any changes, such as updates to account balances or transaction records, are immediately persisted to avoid discrepancies between the application’s view of the data and the actual state of the system. Explicit saving models require users to manually save data, creating a risk of accidental data loss if users forget to save their changes.

## _Jackson_
The JSONHandler class uses the Jackson library to read and write from the json-file. Jackson is a Java library used for processing JSON data. It is widely used in Java applications for tasks like parsing JSON strings, generating JSON data, and serializing/deserializing Java objects to/from JSON. This made it easier for us to make deposits and witdrawls objects, as we use and abstract class for these opertions.

## _Tests for persistence module_
[JSONHandlerTest](/bank/persistence/src/test/java/bank/persistence/JSONHandlerTest.java) -> Verifing that the JSONHandler class can read and write to file, and returns the correct values.

## _Class diagram_
![here](/docs/release3/Diagrams/PersistenceClassDiagram.png)