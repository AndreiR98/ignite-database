package uk.co.roteala.configs;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.ignite.Ignite;
import org.apache.ignite.Ignition;
import org.apache.ignite.configuration.ConnectorConfiguration;
import org.apache.ignite.configuration.DataStorageConfiguration;
import org.apache.ignite.configuration.IgniteConfiguration;
import org.apache.ignite.spi.discovery.tcp.ipfinder.multicast.TcpDiscoveryMulticastIpFinder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
@RequiredArgsConstructor
public class IgniteServerConfig {
    private final BlockchainConfigs blockchainConfigs;

    @Bean
    public Ignite igniteInstance() {
        IgniteConfiguration configuration = new IgniteConfiguration();
        configuration.setLocalHost(blockchainConfigs.getNodeServerIP());
        configuration.setConnectorConfiguration(new ConnectorConfiguration()
                .setPort(7331)
                .setHost(blockchainConfigs.getNodeServerIP()));

        configuration.setDataStorageConfiguration(new DataStorageConfiguration()
                .setPageSize(100)
                .setStoragePath(blockchainConfigs.getRootDirectory().getAbsolutePath()));

        TcpDiscoveryMulticastIpFinder ipFinder = new TcpDiscoveryMulticastIpFinder();

//        configuration.setDeploymentSpi();
//        configuration.setDiscoverySpi()

        return Ignition.start(configuration);

    }
}
