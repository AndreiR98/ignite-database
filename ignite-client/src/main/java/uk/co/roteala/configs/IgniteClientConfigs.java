package uk.co.roteala.configs;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.io.File;

@Getter
@Setter
@Configuration
@ConfigurationProperties(prefix = "roteala.ignite.client")
public class IgniteClientConfigs {
    private String nodeClientIP;
    private File rootDirectory;
}
