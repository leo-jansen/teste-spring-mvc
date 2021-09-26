package com.example.spring.testespringmvc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http.authorizeRequests().anyRequest().authenticated().and().formLogin(form -> form.loginPage("/login").permitAll());
  }

  @Bean
  @Override
  protected UserDetailsService userDetailsService() {
    // metodo para test, não usar em produção
    UserDetails user = User.withDefaultPasswordEncoder().username("teste").password("teste").roles("USER").build();
    return new InMemoryUserDetailsManager(user);
  }
}
