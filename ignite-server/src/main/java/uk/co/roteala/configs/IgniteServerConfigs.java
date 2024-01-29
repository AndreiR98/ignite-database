package uk.co.roteala.configs;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.io.File;

@Getter
@Setter
@Configuration
@ConfigurationProperties(prefix = "roteala.ignite.server")
public class IgniteServerConfigs {
    private String nodeServerIP;
    private File rootDirectory;
}
