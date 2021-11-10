package com.example.basicauth;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import static com.example.basicauth.ApplicationUserRole.*;

@Configuration
@EnableWebSecurity
public class BasicAuth extends WebSecurityConfigurerAdapter {

private final PasswordConfig passwordConfig;

    public BasicAuth(PasswordConfig passwordConfig) {
        this.passwordConfig = passwordConfig;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
      http
              .authorizeRequests()
              .antMatchers("/","index")
              .permitAll()
              .antMatchers("/api/**").hasRole(STUDENT.name())
              .anyRequest()
              .authenticated()
              .and()
              .httpBasic();
    }

    @Override
    @Bean
    protected UserDetailsService userDetailsService() {
        UserDetails user = User.builder()
                .username("ahmmuh")
                .password(passwordConfig.passwordEncoder().encode("password"))
                .roles(STUDENT.name())
                .build();

       UserDetails abdi =   User.builder()
                .username("abdi")
                .password(passwordConfig.passwordEncoder().encode("abdi123"))
                .roles(ADMIN.name())
                .build();


       UserDetails anas = User.builder()
               .username("anas")
               .password(passwordConfig.passwordEncoder().encode("anas123"))
               .roles(STUDENT.name())
               .build();

        return  new InMemoryUserDetailsManager(
                user,
                abdi,
                anas
        );
    }
}
