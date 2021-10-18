package com.vs4vijay.app;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class AppRunner implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
        System.err.println("AppRunner Running");
    }

}