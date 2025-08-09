package com.sunbeam.security;

import java.util.List;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import lombok.AllArgsConstructor;

@Configuration // to declare config class - to declare spring beans - @Bean)
@EnableWebSecurity // to customize spring security
@EnableMethodSecurity // to enable method level annotations
//(@PreAuthorize , @PostAuthorize..) to specify  authorization rules
@AllArgsConstructor
public class SecurityConfiguration {
	//depcy - password encoder
	private final PasswordEncoder encoder;
/* configure spring bean to customize spring security filter chain
 * disable CSRF protection
 - session creation policy - stateless
 - disable form login based authentication
 - enable basic authentication scheme , for REST clients
 */
	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
		//1. Disable CSRF protection
		http.csrf(csrf -> csrf.disable());
		//2. Authenticate any request 
		http.authorizeHttpRequests(request -> 
		//5.permit all - swagger , view all restaurants , user signin , sign up....
		request.requestMatchers("/swagger-ui/**","/v**/api-docs/**",
				"/users/signin","/users/signup").permitAll()
		//6. restaurants - GET - to get all restaurants  - no authentication
		.requestMatchers(HttpMethod.GET, "/restaurants").permitAll()
		//get restaurant by id - customer
		.requestMatchers("/restaurants/{id}").hasRole("CUSTOMER")
		//update restaurant details - admin
		.requestMatchers(HttpMethod.PUT,"/restaurants/**").hasRole("ADMIN")
		.anyRequest().authenticated());
		//3. enable HTTP basic auth
		http.httpBasic(Customizer.withDefaults());
		//4. set session creation policy - stateless
		http.sessionManagement(session -> 
		session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
		return http.build();
	}
	/*
	 * Configure InMemoryUserDetailsManager as a spring bean
	 */
	@Bean
	UserDetailsService userDetailsService() {
		// create use details 
		//User(String userName|email , String encryptedPwd,
		//Collection<GrantedAuthority> authorities)
		//GrantedAuthority i.f <----- implemented by SimpleGrantedAuthority class
		//SimpleGrantedAuthority(String roleName)
		
		User admin=
				new User("Rama Kher", 
				encoder.encode("12345"), 
				List.of(new SimpleGrantedAuthority("ROLE_ADMIN")));
		User customer=
				new User("Mihir Patil", 
				encoder.encode("32345"), 
				List.of(new SimpleGrantedAuthority("ROLE_CUSTOMER")));
		InMemoryUserDetailsManager mgr=
				new InMemoryUserDetailsManager(admin,customer);
		return mgr;
	}
	
	
}
