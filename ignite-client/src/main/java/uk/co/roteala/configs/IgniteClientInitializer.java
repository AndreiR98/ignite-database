package uk.co.roteala.configs;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.ignite.Ignite;
import org.apache.ignite.Ignition;
import org.apache.ignite.configuration.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
@RequiredArgsConstructor
public class IgniteClientInitializer {
    private final IgniteClientConfigs configs;

    @Bean
    public Ignite igniteClientInstance() {
        IgniteConfiguration configuration = new IgniteConfiguration();
        configuration.setLocalHost(configs.getNodeClientIP());

        configuration.setConnectorConfiguration(new ConnectorConfiguration()
                .setPort(7331)
                .setHost(configs.getNodeClientIP()));

        configuration.setDataStorageConfiguration(new DataStorageConfiguration()
                .setPageSize(DataStorageConfiguration.MAX_PAGE_SIZE)
                .setStoragePath(configs.getRootDirectory().getAbsolutePath()));
        configuration.setClientMode(true);

        configuration.setSqlConfiguration(new SqlConfiguration());

        //configuration.setAsyncContinuationExecutor();

        configuration.setDeploymentMode(DeploymentMode.CONTINUOUS);

        //TcpDiscoveryMulticastIpFinder ipFinder = new TcpDiscoveryMulticastIpFinder();

//        configuration.setDeploymentSpi();
//        configuration.setDiscoverySpi()

        return Ignition.start(configuration);
    }
}
