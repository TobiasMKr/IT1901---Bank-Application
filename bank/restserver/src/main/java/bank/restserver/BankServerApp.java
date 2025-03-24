package bank.restserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class BankServerApp {

  /**
   * Main method to start the Spring Boot application.
   * 
   * @param args Command line arguments
   */
  public static void main(String[] args) {
    SpringApplication.run(BankServerApp.class, args);
  }

  /**
   * Configure CORS for the REST server. This is necessary for react integration.
   */
  @Bean
  public WebMvcConfigurer corsConfigurer() {
    return new WebMvcConfigurer() {
      @SuppressWarnings("null")
      @Override
      public void addCorsMappings(CorsRegistry registry) {
        registry
            .addMapping("/bank/**")
            .allowedOrigins("*")
            .allowedMethods("PUT", "POST", "GET");
      }
    };
  }

}
