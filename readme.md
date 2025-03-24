# _Bank_

## _Group 2426, IT1901_
This is group 26's IT1901 project. This repo contains a multi-module, multi-package java, javaFX and React project for checking your bank status. We made a bank that keeps track of a users current balance and transactions. Read more [here](/bank/readme.md).

Open in EclipseChe [here](https://che.stud.ntnu.no/#https://gitlab.stud.idi.ntnu.no/it1901/groups-2024/gr2426/gr2426?new)

### **Technologies used**
- [**_Java_ 17.0.8**](https://www.oracle.com/java/technologies/downloads/#java17)
- [**_Maven_ 3.11.0**](https://maven.apache.org/download.cgi)
- [**_JUnit_ 5.10.0**](https://junit.org/junit5/docs/current/user-guide/)
- [**_JaCoCo_ 0.8.12**](https://mvnrepository.com/artifact/org.jacoco/jacoco-maven-plugin)
- [**_Checkstyle_ 3.3.0**](https://mvnrepository.com/artifact/com.puppycrawl.tools/checkstyle)
- [**_Spotbugs_ 4.7.3.6**](https://mvnrepository.com/artifact/com.github.spotbugs/spotbugs)
- [**_Jackson_ 2.15.2**](https://mvnrepository.com/artifact/com.fasterxml.jackson.core/jackson-databind)
- [**_JavaFX_ 17.0.8**](https://mvnrepository.com/artifact/org.openjfx)
- [**_Spring Boot_ 3.1.4**](https://mvnrepository.com/search?q=spring+boot)
- [**_Jpackage_ 1.4.0**](https://github.com/petr-panteleyev/jpackage-maven-plugin)
- [**_WireMock_ 3.0.1**](https://wiremock.org/)
- [**_TestFX_ 4.0.16**](https://mvnrepository.com/artifact/org.testfx)
- [**_Mockito_** ](https://site.mockito.org/)

Read about techologies in the new client [here](/bank/react/readme.md)

## _Purpose of the project_
In order for people to maintain control over their current balance and money that they inherit. It can be difficult for people to keep track of their money without a functional application that does it for you. 

## _Release Documentation_
__[- Release 1 -](docs/release1/release1.md)  
[- Release 2 -](docs/release2/release2.md)  
[- Release 3 -](docs/release3/release3.md)__


## _Running the application_
Learn how to run the application [here](bank/readme.md).


## _Testing_
This project uses JUNIT 5 for testing. To run the tests, follow these steps:
```bash
# make sure you are in the bank directory
cd bank #(if not)

# run tests
mvn test

# if you want to test specific modules:
cd core
# or
cd persistence
# or
cd resterver
# or 
cd ui

# run tests
mvn test

```

## _Open Jacoco report_
This project uses Jacoco 0.8.12 to produce a testing covrage report

To open Jacoco for core:
```bash
#Make sure you are in the bank directory
#Mac
open core/target/site/jacoco/index.html 

#Windows 
start core/target/site/jacoco/index.html 
```
To open Jacoco for persistence:
```bash
#Make sure you are in the bank directory
#Mac
open persistence/target/site/jacoco/index.html 

#Windows 
start persistence/target/site/jacoco/index.html 
```
To open Jacoco for ui:
```bash
#Make sure you are in the bank directory
#Mac
open ui/target/site/jacoco/index.html 

#Windows 
start ui/target/site/jacoco/index.html 
```
To open Jacoco for restserver:
```bash
#Make sure you are in the bank directory
#Mac
open restserver/target/site/jacoco/index.html 

#Windows 
start restserver/target/site/jacoco/index.html 
```

## _User interface stage 3_

### _Home page_
![here](/docs/release3/Interface/Home.png)

### _Transaction page_ 
![here](/docs/release3/Interface/Transactions.png)

## _Contributors_
- Hans Henrik Horn Hynne
- Tobias Meinich Kroll 
- Magnus Kristensen
- Brage Jetne
