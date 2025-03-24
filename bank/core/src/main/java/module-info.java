module bank.core {
    requires com.fasterxml.jackson.annotation;

    opens bank.core to com.fasterxml.jackson.databind;

    exports bank.core;
}
