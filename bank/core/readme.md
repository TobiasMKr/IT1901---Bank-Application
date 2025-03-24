# _Core module_

The core module contains classes that are necessary in order to process user input and perform the intended purpose of the application. Junit is used to test these classes, and JaCoCo is used to make sure that the classes have adequate test covrage.

## _Core module contains the following classes_:

[Bank](/bank/core/src/main/java/bank/core/Bank.java) -> Our bank object\
[Transaction](/bank/core/src/main/java/bank/core/Transaction.java) -> Abstract class to keep track of transactions\
[Deposit](/bank/core/src/main/java/bank/core/Deposit.java) -> Handels deposit type transactions, extends the Transaction.java class\
[Withdrawal](/bank/core/src/main/java/bank/core/Withdrawal.java) -> Handels withdrawal type transactions, extends the Transaction.java class


## _Connection between the classes_:

Bank.java creats a bank object. This bank object gets the current balance, and transaction history, from the bank.json file located in the users home directory by using the JSONHandler class located in persistance. Furthermore, the user can choose between withdrawing and depositing money, which happens in the graphical user interface, and connects to either Withdrawal.java or Deposit.java. These transactions are stored in a list which is implicitly saved. 

## _Tests for core module_:
[BankTest](/bank/core/src/test/java/bank/core/BankTest.java) -> Verifing that the methods in the Bank class return correct values, and that the contructor works as intended.\
[TransactionTest](/bank/core/src/test/java/bank/core/TransactionTest.java) -> Verifing that the Deopsit and Withdrawal classes work as intended.

## _Class diagram_
![here](/docs/release3/Diagrams/CoreClassDiagram.png)