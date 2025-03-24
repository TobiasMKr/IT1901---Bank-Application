# __Bank__

## _Project description_

The Bank is an application providing a way to withdraw and deposit money into a bank account, as well as showing your balance. The current version also has a transaction-page, showing a list of all the recent transactions from and to you account. 

## _User Story_
A man walks past the TV-store. He wants to buy a new TV, but he does not know if he can afford it. Therefore he checks his balance with the bank applications, and sees that he can afford it with ease. He buys the TV and lives happely ever after and his balance gets automatically updated to make sure he knows if he can buy another one.  
 
## _Building and running the app_
The application can be ran in three different ways. Here is a step by step guide for each method:

### _Running the application with local access_:
1) Navigate to bank directory
2) Install the required dependencies and run the tests
3) Run the javaFX application

```bash
# navigate to the bank directory:
cd bank

# maven install:
mvn clean install
#Tests can be skipped by using "mvn clean install -Dmaven.test.skip"
#Clean install can be skipped if application has been ran with remote access or with react client previously.


# run the app
mvn javafx:run -pl ui
```

### _Running the project with remote access_
1) Navigate to bank directory.
2) Install dependencies and run tests.
3) Start server. 
4) Open new terminal window.
5) Run javafx client application.

```bash
# navigate to the bank directory:
cd bank

# maven install:
mvn clean install
#Tests can be skipped by using "mvn clean install -Dmaven.test.skip"
#Clean install can be skipped if application has been ran with local access or with react client previously.

mvn spring-boot:run -pl restserver

#Command 4 must be written in seperate terminal window after repeating step 1)

mvn javafx:run -pl ui -P remote
```

### _Running the project with React client_
If you are running from EclipseChe, read below before attempting to run the project.
1) Navigate to bank directory.
2) Install dependencies and run tests.
3) Start server.
4) Navigate to react directory in new terminal and install dependencies
3) Build and run react client application.

```bash
#Navigate to bank directory
cd bank

mvn clean install
#Tests can be skipped by using "mvn clean install -Dmaven.test.skip"
#Clean install can be skipped if application has been ran with remote access or with local access previously.

mvn spring-boot:run -pl restserver

#Navigate to react directory in new terminal
cd react

#Install dependencies
npm install

#Build the client application
npm run build 


#Start the client application
npm start

http://localhost:3000/
#Click the link to open the client application
```
#### _IMPORTANT: If you are running from EclipseChe_
If you are running from EclipseChe, you first need to install a newer version of Node.js.
```bash
#Run this in your terminal to install nvm
curl -o- https://raw.githubusercontent.com/nvm-sh/nvm/v0.40.1/install.sh | bash

#Run this to load nvm
export NVM_DIR="$([ -z "${XDG_CONFIG_HOME-}" ] && printf %s "${HOME}/.nvm" || printf %s "${XDG_CONFIG_HOME}/nvm")"
[ -s "$NVM_DIR/nvm.sh" ] && \. "$NVM_DIR/nvm.sh" # This loads nvm

#Run this to update Node.js version
nvm install node

#Then run
nvm use node
```

## _Project structure_

The project is built using maven.  
It consists of four modules; _core_, _ui_, _persistence_ and _restserver_, each responsible for different parts of the application.  
The _core module_ contains classes responsible for the internal representation of the bank.  
The _ui module_ contains classes responsible for the user interface.  
The _persistence module_ is responsible for reading and writing the bank to a json file.  
The _restserver module_ contains the REST_API.
You can read more about the different modules below. 

The project also includes a react directory. This contains the files for the React client.
You can read more about this [here](/bank/react/readme.md).


![Structure](/docs/release3/Diagrams/PlantUML3.png)

## _Modules_
### _core_
Read about the __core__ module [here](/bank/core/readme.md)

### _persistence_
Read about the __persistence__ module [here](/bank/persistence/readme.md)

### _react_
Read about the __react__ module [here](/bank/react/readme.md)

### _restserver_
Read about the __restserver__ module [here](/bank/restserver/readme.md)

### _ui_
Read about the __ui__ module [here](/bank/ui/readme.md)

## _Shippable product_
This project is able to be shipped as a standalone application using jlink and jpackage. To ship the project, follow theese steps, assuming you have allready buildt the project.

1) Navigate to bank directory.
2) Install dependencies
3) Navigate to UI directory
4) Create a runtime image using Jlink
5) Package the image using JPackage

```bash
#Navigate to bank directory
cd bank

mvn clean install
#Tests can be skipped by using "mvn clean install -Dmaven.test.skip"

#Navigate to UI directory
cd ui

#Create a runtime image
mvn javafx:jlink 

#Package the image
mvn jpackage:jpackage

#.dmg file can be found in /ui/target/dist/BankAppFX-1.0.0.dmg
```

## _Sequence diagram_
![here](/docs/release3/Diagrams/SequenceDiagram.png)

## _Package diagram_
![here](/docs/release3/Diagrams/PackageDiagram.png)