package com.basharin.snail.configuration;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

/*
 * Class to hold methods which set access level
 */
@Configuration
@EnableWebSecurity
public class SecurityConfiguration {
   
   @Autowired
   DataSource dataSorce;
     
    @Bean
    public static PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    // configure SecurityFilterChain
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf().disable()
           .authorizeRequests()
              .antMatchers("/personalpage").authenticated()
              .anyRequest().permitAll()
               .and()
            .formLogin(
               form -> form
               .loginPage("/login")
            .failureUrl("/login?failed")
               .loginProcessingUrl("/login")
               .usernameParameter("email")
               .passwordParameter("password")
               .defaultSuccessUrl("/personalpage")
               .permitAll())
            .logout(
               logout -> logout
               .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
               .logoutSuccessUrl("/")
               .permitAll());
        return http.build();
    } // close filterChain()
} // close SecurityConfiguration class