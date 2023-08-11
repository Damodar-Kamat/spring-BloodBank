package com.bloodbank.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import com.bloodbank.service.AppUserServiceImpl;
import com.bloodbank.service.BloodBankServiceImpl;

@Configuration
public class WebConfig {
	
	@Bean
    public UserDetailsManager userDetailsManager() {
		System.out.println("UserDetails");
		return new AppUserServiceImpl();
    }

    @Bean
    public PasswordEncoder encoder() {
    	System.out.println("hello");
        return new BCryptPasswordEncoder();
    }


 

    // authorization
    @Bean
        public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
            return http
                    .csrf()
                    .disable()
                    .authorizeHttpRequests(httpRequest->{
                    	//httpRequest.requestMatchers("/**").permitAll();
                    	httpRequest.requestMatchers("/user-api/v1/**").permitAll();
                    	httpRequest.requestMatchers("/bloodbank-api/v1/admin/**").hasRole("ADMIN");
                    	//httpRequest.requestMatchers("/bloodbank-api/v1/admin/**").permitAll();
                        httpRequest.requestMatchers("/bloodbank-api/v1/bloodbank/**").permitAll();
            })
            .httpBasic()
            .and()
            .build();
    }
}
