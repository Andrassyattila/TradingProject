package com.codecool.tradingproject.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


@EnableGlobalMethodSecurity(securedEnabled = true)
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {


    @Override
    protected void configure(HttpSecurity https) throws Exception{
        https
                .authorizeRequests()
                    .antMatchers("/").permitAll()
                    .antMatchers("/login").permitAll()
                    .antMatchers("/add").access("hasRole('USER')")
                    .antMatchers("/profile").access("hasRole('USER')")
                    //.antMatchers("/moderator").access("hasRole('ADMIN')")
                .and()
                .formLogin()
                    .loginPage("/login").permitAll()
                .and()
                .logout()
                    .logoutSuccessUrl("/").permitAll();

    }

}
