package com.register.users.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfigurations extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private ServiceAuthentication serviceAuthentication;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.csrf().disable()
			.authorizeRequests()
			.antMatchers(HttpMethod.GET, "/products").permitAll()
			.antMatchers(HttpMethod.GET, "/products/*").permitAll()
			.antMatchers(HttpMethod.POST, "/products/register")
			.hasAnyRole("ADMIN")
			.antMatchers(HttpMethod.GET, "/users")
			.hasAnyRole("ADMIN")
			.antMatchers(HttpMethod.GET, "/users/*")
			.hasAnyRole("ADMIN")
			.antMatchers(HttpMethod.POST, "/register").permitAll()
			.anyRequest().authenticated()
			.and().formLogin()
			.and().httpBasic();
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		auth.userDetailsService(serviceAuthentication).passwordEncoder(passwordEncoder);
		
	}
	
	@Override
	public void configure(WebSecurity web) throws Exception {
		super.configure(web);
	}

	
//	public static void main(String[] args) {
//		System.out.println(new BCryptPasswordEncoder().encode("teste"));
//	}
	
}
