package uk.co.roteala;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
public class IgniteServerApp
{
    public static void main(String[] args) {
        SpringApplication.run(IgniteServerApp.class, args);
    }
}
