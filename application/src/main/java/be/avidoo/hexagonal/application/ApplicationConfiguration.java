package be.avidoo.hexagonal.application;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.time.Clock;

@Configuration
@ComponentScan
public class ApplicationConfiguration {

    @Bean
    public Clock clock() {
        return Clock.systemDefaultZone();
    }
}
