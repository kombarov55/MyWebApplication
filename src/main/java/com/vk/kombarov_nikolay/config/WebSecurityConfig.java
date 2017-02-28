package com.vk.kombarov_nikolay.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * Created by nikolaykombarov on 02.02.17.
 */

@Configuration
@EnableWebSecurity
@Import(RootConfig.class)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

//    @Autowired
//    RootConfig rootConfig;
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.csrf()
//                .disable()
//                .authorizeRequests()
////                .anyRequest().permitAll()
//                .antMatchers("/*").hasAuthority("member")
//                .and().httpBasic();
//    }
//
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.jdbcAuthentication().dataSource(rootConfig.dataSource())
//                .usersByUsernameQuery("" +
//                        "SELECT username, password, true " +
//                        "FROM users " +
//                        "WHERE username=?")
//                .authoritiesByUsernameQuery("" +
//                        "SELECT username, user_role " +
//                        "FROM user_roles " +
//                        "WHERE username=?");
//    }
}
