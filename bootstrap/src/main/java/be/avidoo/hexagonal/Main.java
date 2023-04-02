package be.avidoo.hexagonal;

import be.avidoo.hexagonal.application.dossier.ApplicationConfiguration;
import be.avidoo.hexagonal.framework.FrameworkConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

/**
 * We do componentScan in the current package and also in de ports package from the Application Hexagon to find the @Named services
 */
@SpringBootApplication
@Import({ApplicationConfiguration.class, FrameworkConfiguration.class})
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
}
