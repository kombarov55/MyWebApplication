package com.vk.kombarov_nikolay.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 * Created by nikolaykombarov on 27.01.17.
 */

@Configuration
@ComponentScan(basePackages = {"com.vk.kombarov_nikolay.model"})
public class RootConfig {

    @Bean
    public DataSource dataSource() throws NamingException {
        DriverManagerDataSource ds = new DriverManagerDataSource();
        ds.setUsername("postgres");
        ds.setPassword("root");
        ds.setUrl("jdbc:postgresql://localhost:5432/messenter-new");
        ds.setDriverClassName("org.postgresql.Driver");

        return ds;
    }

}
