package com.zamunda.cinema;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	
	 public void addViewControllers(ViewControllerRegistry registry) {
	        registry.addViewController("/").setViewName("home");
	    }

	
	  @Override
	    protected void configure(HttpSecurity http) throws Exception {
	        http
	            .authorizeRequests().antMatchers("/resources/**").permitAll()
	                .antMatchers("/", "/home/home").hasRole("ADMIN")
	                .antMatchers("/", "/home/halls").hasRole("USER")
	                .anyRequest().authenticated()
	                .and()
	            .formLogin()
	                .loginPage("/login")
	                .defaultSuccessUrl("/home/halls")
	                .permitAll()
	                .and()
	            .logout()
	                .permitAll();
	    }

	    @Autowired
	    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
	        auth
	            .inMemoryAuthentication()
	                .withUser("user").password("password").roles("USER").and()
	        .withUser("admin").password("password").roles("ADMIN");
	    }
}
