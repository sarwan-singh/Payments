package com.dbs.spring;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpRequest;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.dbs.spring.filters.JwtRequestFilter;
import com.dbs.spring.service.CustomerUserDetailsService;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{

	@Bean
	public PasswordEncoder getPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Autowired
	private JwtRequestFilter filter;

	@Autowired
	private CustomerUserDetailsService customerService;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(customerService);
		
	}	
    
	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		// TODO Auto-generated method stub
		return super.authenticationManagerBean();
	}

	private static final String[] AUTH_WHITELIST_GET = {
		"/v2/api-docs",
		"/swagger-resources",
		"/swagger-resources/**",
		"/configuration/ui",
		"/configuration/security",
		"/swagger-ui.html",
		"/webjars/**",
		"/v3/api-docs/**",
		"/swagger-ui/**",
		"/",
		"/message",
		"/bank",
		"/currency",
		"/customer/checkBlacklist",
		"/customer/checkBlacklist/**"
    };
	
    private static final String[] AUTH_WHITELIST_POST = {
    	"/auth/**", "/sessioncheck"
    };
    
    private static final String[] AUTH_AUTHENTICATED_GET = {
    	"/transaction", "/transaction/**"
    };
    	
    private static final String[] AUTH_AUTHENTICATED_POST = {
    
    };
    
	@Override
	protected void configure(HttpSecurity http) throws Exception {
	
		http.csrf().disable()
		.authorizeRequests()
		.antMatchers(HttpMethod.GET, AUTH_WHITELIST_GET).permitAll()
		.antMatchers(HttpMethod.POST, AUTH_WHITELIST_POST).permitAll()
		.antMatchers(HttpMethod.GET, AUTH_AUTHENTICATED_GET ).hasAnyRole("USER")
		.antMatchers(HttpMethod.POST, AUTH_AUTHENTICATED_POST).hasAnyRole("USER")
		.anyRequest().authenticated().and()
		.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
		.disable().cors();
		
		http.addFilterBefore(filter, UsernamePasswordAuthenticationFilter.class);
	}
	
	
}
