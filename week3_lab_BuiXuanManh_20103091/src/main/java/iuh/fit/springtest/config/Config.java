package iuh.fit.springtest.config;

import com.zaxxer.hikari.util.DriverDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
public class Config {
    @Bean
    @Scope("singleton")
    public DataSource createDataSource() throws Throwable {
        DriverManagerDataSource ds = new DriverManagerDataSource();
        ds.setDriverClassName("org.mariadb.jdbc.Driver"); // Actual driver class name
        ds.setUrl("jdbc:mariadb://localhost:3306/SpringTest"); // Actual database URL
        ds.setUsername("root"); // Actual username
        ds.setPassword("sapassword"); // Actual password
        return ds;
    }
}
