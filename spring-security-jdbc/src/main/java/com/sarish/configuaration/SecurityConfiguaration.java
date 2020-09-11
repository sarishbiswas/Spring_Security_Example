package com.sarish.configuaration;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class SecurityConfiguaration extends WebSecurityConfigurerAdapter {
	@Autowired
	DataSource dataSource;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		auth.jdbcAuthentication()
//		.dataSource(dataSource)
//		.withDefaultSchema() //this creates a default schema in h2 database
//		.withUser(User.withUsername("User").password("User").roles("USER"))
//		.withUser(User.withUsername("Admin").password("Admin").roles("ADMIN"))
//		.withUser(User.withUsername("Ani").password("Ani").roles("USER"))
//		.withUser(User.withUsername("Sarish").password("Sarish").roles("ADMIN"));
		
		//Now We get rid of DefaultSchema cause its not useful for production environment
		//https://docs.spring.io/spring-security/site/docs/current/reference/html5/#servlet-authentication-jdbc
		//The above site for schema docs and defination
		auth.jdbcAuthentication()
		.dataSource(dataSource)
		.usersByUsernameQuery("select username, password , enabled "+"from users "+"where username = ?")
		.authoritiesByUsernameQuery("select username, authority "+"from authorities "+"where username = ?");
	}
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		.antMatchers("/admin").hasRole("ADMIN")
		.antMatchers("/user").hasAnyRole("USER","ADMIN")
		.antMatchers("/").permitAll()
		.and().formLogin();
	}
	@Bean
	public PasswordEncoder getPasswordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}
}
