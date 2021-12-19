package com.example.spring.testespringmvc.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
// import org.springframework.security.core.userdetails.User;
// import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
  @Autowired
  private DataSource dataSource;

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http.authorizeRequests()
        .antMatchers("/home").permitAll()
        .anyRequest().authenticated().and()
        .formLogin(form -> form.loginPage("/login").defaultSuccessUrl("/usuario", true).permitAll())
        .logout(logout -> {logout.logoutUrl("/logout").logoutSuccessUrl("/home");});
  }

  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
    // configurar um usuario
    // UserDetails user = User.builder().username("joao").password(encoder.encode("joao")).roles("USER").build();
    // autenticar o usuario no banco de dados
    auth.jdbcAuthentication().dataSource(dataSource).passwordEncoder(encoder);
  }
  
  /* 
   * @Bean
   * @Override
   * protected UserDetailsService userDetailsService() {
   *   // metodo paratest, não usar em produção
   *   UserDetails user = User.withDefaultPasswordEncoder().username("teste").password("teste").roles("USER").build();
   *   return new InMemoryUserDetailsManager(user);
   * }
  */
}
