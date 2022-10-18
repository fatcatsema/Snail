package com.basharin.snail.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;


@Configuration
@EnableWebSecurity
public class SecurityConfiguration {
     
    @Bean
    public static PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    // configure SecurityFilterChain
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf().disable()
        	.authorizeRequests()
        		.antMatchers("/").permitAll()
                .antMatchers("/about").permitAll()
                .antMatchers("/career").permitAll()
                .antMatchers("/contacts").permitAll()
                .antMatchers("/tracking").permitAll()
                .antMatchers("/calculation").permitAll()
                .antMatchers("/customerservice").permitAll()
                .antMatchers("/registration/**").permitAll()
                .and()
            .formLogin()
            	.loginPage("/login")
            	.loginProcessingUrl("/login")
            	.defaultSuccessUrl("/customers")
            	.permitAll()
            	.and()
            .logout()
            	.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
            	.logoutSuccessUrl("/")
            	.permitAll();
        return http.build();
    }
}