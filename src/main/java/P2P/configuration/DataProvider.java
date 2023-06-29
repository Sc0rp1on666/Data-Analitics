package P2P.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
@PropertySource("classpath:P2P.properties")
@ComponentScan(basePackages = "P2P.configuration.DataProvider")
@ConfigurationProperties("P2P.properties")
public class DataProvider {
    @Bean
    public DataSource getConnection(Environment environment){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl(environment.getProperty("spring.datasource.url"));
        dataSource.setPassword(environment.getProperty("spring.datasource.pass"));
        dataSource.setUsername(environment.getProperty("spring.datasource.user"));
        return dataSource;
    }
}