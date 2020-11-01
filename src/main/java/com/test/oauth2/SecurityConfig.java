package com.test.oauth2;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableConfigurationProperties
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    public void configure(HttpSecurity http) throws Exception {

        http
        .csrf().disable()
        .authorizeRequests()
        .antMatchers("/success","/test").authenticated() // Block this 
        .antMatchers("/").permitAll() // Allow this for all
        .anyRequest().authenticated()
        .and().logout().logoutSuccessUrl("/").permitAll()
        .and()
        .oauth2Login();
        
//		        .authorizeRequests()
//		        .antMatchers("/oauth_login")
//		        .permitAll()
//		        .anyRequest()
//		        .authenticated()
//		        .and()
//		        .oauth2Login()
//		        .loginPage("/oauth_login");
        
        
    }
}
