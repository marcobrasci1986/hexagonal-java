package be.avidoo.hexagonal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * We do componentScan in the current package and also in de ports package from the Application Hexagon to find the @Named services
 */
@SpringBootApplication
@ComponentScan(value = {"be.avidoo.hexagonal.framework", "be.avidoo.hexagonal.application"})
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
}
