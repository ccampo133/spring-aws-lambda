package me.ccampo.example;

import me.ccampo.example.service.ExampleServiceA;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * Declare all your beans here, or use the annotation driven approach
 * with {@link org.springframework.context.annotation.ComponentScan}.
 *
 * @author Chris Campo
 */
@Configuration
@ComponentScan
public class ApplicationConfiguration {

    private static final long START_TIME = System.currentTimeMillis();

    @Bean
    public ExampleServiceA exampleServiceA() {
        return new ExampleServiceA();
    }

    @Bean
    public ContextRefreshedEventListener contextRefreshedEventListener() {
        return new ContextRefreshedEventListener();
    }

    public static class ContextRefreshedEventListener implements ApplicationListener<ContextRefreshedEvent> {

        @Override
        public void onApplicationEvent(final ContextRefreshedEvent event) {
            final long endTime = System.currentTimeMillis();
            final long dt = endTime - START_TIME;
            System.out.println("ContextRefreshedEvent fired " + dt + " ms after ApplicationConfiguration was created");
        }
    }
}
