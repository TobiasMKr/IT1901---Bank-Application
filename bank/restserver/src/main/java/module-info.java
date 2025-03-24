module bank.restserver {
  requires transitive bank.core;
  requires transitive bank.persistence;

  requires spring.boot;
  requires spring.boot.autoconfigure;

  requires spring.beans;
  requires spring.core;
  requires spring.context;

  requires spring.data.rest.core;
  requires spring.data.commons;

  requires spring.web;
  requires transitive spring.webmvc;

  requires org.slf4j;

  opens bank.restserver to spring.beans, spring.context, spring.web, spring.core;

  exports bank.restserver to spring.beans, spring.boot;
}
