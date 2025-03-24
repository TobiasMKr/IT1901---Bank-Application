module bank.ui {
    requires bank.core;
    requires bank.persistence;
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires com.fasterxml.jackson.databind;
    requires com.fasterxml.jackson.core;
    requires com.fasterxml.jackson.datatype.jsr310;
    requires java.net.http;
    requires javafx.base;

    opens bank.ui to javafx.graphics, javafx.fxml;
}
