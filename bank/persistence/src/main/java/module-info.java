module bank.persistence {
  requires com.fasterxml.jackson.databind;
  requires transitive bank.core;
  requires com.fasterxml.jackson.datatype.jsr310;

  exports bank.persistence;
}