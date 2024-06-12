package com.teleapps_user_details.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class DatabaseConfig 
{
    @Bean
     DataSource dataSource() {
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl("jdbc:mysql://localhost:3306/user_management");
        config.setUsername("root");
        config.setPassword("MySQL@8.0.36");
        return new HikariDataSource(config);
    }
}