package com.sarish.configuaration;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class SecurityConfiguaration extends WebSecurityConfigurerAdapter{
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		//Set your Authentication to auth object
		auth.inMemoryAuthentication()
		.withUser("ani")
		.password("ani")
		.roles("USER")
		.and()
		.withUser("Sarish")
		.password("sarish")
		.roles("ADMIN");
	}
	@Bean
	public PasswordEncoder getPasswordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}
}
