package be.avidoo.hexagonal;

import be.avidoo.hexagonal.application.ApplicationConfiguration;
import be.avidoo.hexagonal.input.InputAdaptorConfiguration;
import be.avidoo.hexagonal.output.OutputAdaptorConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

/**
 * We do componentScan in the current package and also in de ports package from the Application Hexagon to find the @Named services
 */
@SpringBootApplication
@Import({ApplicationConfiguration.class, InputAdaptorConfiguration.class, OutputAdaptorConfiguration.class})
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
}
