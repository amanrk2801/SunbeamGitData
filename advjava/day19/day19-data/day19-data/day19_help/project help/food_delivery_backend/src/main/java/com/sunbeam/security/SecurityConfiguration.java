package com.sunbeam.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import lombok.AllArgsConstructor;

@Configuration // to declare config class - equivalent to bean config xml file
@EnableWebSecurity // to enable spring security
@EnableMethodSecurity // later - to enable auth rules at method level
@AllArgsConstructor
public class SecurityConfiguration {

    private final CustomUserDetailsServiceImpl customUserDetailsServiceImpl;
	private final PasswordEncoder passwordEncoder;
	private final CustomJWTFilter customJWTFilter;
	private JwtAuthEntryPoint jwtAuthEntryPoint;

   

	// configure spring security filter chain - as a spring bean
	@Bean
	SecurityFilterChain configureFilterChain(HttpSecurity http) throws Exception {
		// HttpSecurity - spring sec supplied class
		// to customize n build filter chain
		// 1. disable CSRF protection
		http.csrf(csrf -> csrf.disable());
		// 2. any request - has to be authenticated
		http.authorizeHttpRequests(

				request -> request
						.requestMatchers("/swagger-ui/**",
								"/v3/api-docs/**",
								"/users/signin", "/users/signup")
						.permitAll()
						.requestMatchers(HttpMethod.GET, "/restaurants")
						.permitAll()
						//only for react apps - permit in flight requests - otherwise CORS error
						.requestMatchers(HttpMethod.OPTIONS).permitAll()
						//RULE - only customer should be able to get restaurant n menu by id
						.requestMatchers(HttpMethod.GET, "/restaurants/{id}/food_items")
						.hasRole("CUSTOMER")
						//RULE - only customer should be able to place orders
						.requestMatchers(HttpMethod.POST, "/orders")
						.hasRole("CUSTOMER")		
						//RULE - only ADMIN should be able to add | update new restaurant 
						.requestMatchers(HttpMethod.POST, "/restaurants")
						.hasRole("ADMIN")
						//any other remaining requests - needs to be authenticated
						.anyRequest().authenticated());
				// 3. disable HttpSession tracking - stateless
				http.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
					// 4. To support REST APIs , disable form login
		//		http.formLogin(form -> form.disable());
		// 5. Disable Basic auth support
		//http.httpBasic(basic->basic.disable());
		// Handle unauthenticated access with 401
	    http.exceptionHandling(ex -> ex.authenticationEntryPoint(jwtAuthEntryPoint));

	
		//add custom jwt filter before usernamepwd auth filter
		http.addFilterBefore(customJWTFilter, 
				UsernamePasswordAuthenticationFilter.class);
		return http.build();
	}

	// configure AuthManager as a spring bean
	@Bean
	AuthenticationManager 
	authenticationManager
	(AuthenticationConfiguration config) throws Exception{
		return config.getAuthenticationManager();
	}
}
