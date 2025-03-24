package bank.persistence;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.databind.ObjectMapper;

import bank.core.*;

public class JSONHandler {

  private Path filePath;

  /**
   * Constructor for the JSONHandler class
   * 
   * @param filename Name of the file
   */
  public JSONHandler(String filename) {
    if (filename == null) {
      filename = "bank.json";
    }
    this.filePath = Paths.get(System.getProperty("user.home"), "/.bank/" + filename);
    try {
      Path parent = this.filePath.getParent();
      if (parent == null) {
        throw new IllegalArgumentException("Parent is null");
      }
      Files.createDirectories(parent);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * Writes the value of the bank object to a file
   * 
   * @param bank Bank object
   */
  public void writeValue(Bank bank) {
    ObjectMapper objectMapper = new ObjectMapper();
    try {
      objectMapper.writeValue(filePath.toFile(), bank);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  /**
   * Reads the value of the bank object from a file
   * 
   * @return Bank object
   * @throws IOException If the file is not found
   */
  public Bank readValue() throws IOException {
    ObjectMapper objectMapper = new ObjectMapper();
    objectMapper.registerModule(new JavaTimeModule());
    Bank bank = objectMapper.readValue(filePath.toFile(), Bank.class);
    return bank;
  }
}
