package io.github.terramedia.infra;

import com.netflix.dyno.connectionpool.HostSupplier;
import com.netflix.dyno.connectionpool.TokenMapSupplier;
import com.netflix.dyno.connectionpool.impl.ConnectionPoolConfigurationImpl;
import com.netflix.dyno.contrib.ArchaiusConnectionPoolConfiguration;
import com.netflix.dyno.jedis.DynoJedisClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DynoConfiguration {

  @Bean
  public DynoJedisClient dynoJedisClient(
      final ConnectionPoolConfigurationImpl connectionPoolConfiguration,
      final HostSupplier hostSupplier,
      final @Value("${dyno.cluster.name}") String clusterName) {

    return new DynoJedisClient.Builder()
        .withDynomiteClusterName(clusterName)
        .withCPConfig(connectionPoolConfiguration)
        .withHostSupplier(hostSupplier)
        .build();
  }

  @Bean
  public ArchaiusConnectionPoolConfiguration archaiusConnectionPoolConfiguration(
      final TokenMapSupplier tokenMapSupplier,
      final @Value("${spring.application.name}") String appName) {

    final ArchaiusConnectionPoolConfiguration connectionPoolConfiguration;

    connectionPoolConfiguration = new ArchaiusConnectionPoolConfiguration(appName);
    connectionPoolConfiguration.withTokenSupplier(tokenMapSupplier);

    return connectionPoolConfiguration;
  }


}
