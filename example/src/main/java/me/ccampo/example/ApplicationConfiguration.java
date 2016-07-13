package me.ccampo.example;

import me.ccampo.example.service.ExampleServiceA;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Declare all your beans here, or use the annotation driven approach
 * with {@link org.springframework.context.annotation.ComponentScan}.
 *
 * @author Chris Campo
 */
@Configuration
@ComponentScan
public class ApplicationConfiguration {

    @Bean
    public ExampleServiceA exampleServiceA() {
        return new ExampleServiceA();
    }
}
