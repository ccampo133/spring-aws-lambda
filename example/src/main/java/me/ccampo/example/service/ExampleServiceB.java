package me.ccampo.example.service;

import org.springframework.stereotype.Service;

/**
 * Notice here we're using Spring's {@link Service} annotation
 * to register this class as a bean.
 */
@Service
public class ExampleServiceB {

    public String getMessage() {
        return "B";
    }
}
