package com.vk.kombarov_nikolay.config;

import com.vk.kombarov_nikolay.model.user.User;
import org.apache.tomcat.jdbc.pool.PoolProperties;
import org.springframework.context.annotation.*;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.lookup.JndiDataSourceLookup;
import org.springframework.jndi.JndiObjectFactoryBean;

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
        ds.setUsername("root");
        ds.setPassword("Cab11451246");
        ds.setUrl("jdbc:mysql://localhost:3306/myDBTest?useUnicode=true" +
                "&useJDBCCompliantTimezoneShift=true" +
                "&useLegacyDatetimeCode=false" +
                "&serverTimezone=UTC" +
                "&useSSL=false");
        ds.setDriverClassName("com.mysql.jdbc.Driver");

        return ds;
    }

}
