package uk.co.roteala;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.CrossOrigin;

@SpringBootApplication
@CrossOrigin
@PropertySource("classpath:i18n/errors.properties")
public class BlockchainIgniteApp {
    public static void main(String[] args) {
        SpringApplication.run(BlockchainIgniteApp.class, args);
    }
}
