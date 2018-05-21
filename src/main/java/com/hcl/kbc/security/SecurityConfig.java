package com.hcl.kbc.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	 @Override
	    protected void configure(AuthenticationManagerBuilder auth)
	            throws Exception {
	        /* auth
	        .inMemoryAuthentication()
	        .withUser("admin1").password("secret1").roles("ADMIN");*/
		 
		//
	        
	        
	 }
	
	  @Override
	    protected void configure(HttpSecurity http) throws Exception {
	        http.httpBasic().and().authorizeRequests().antMatchers("/","/index","/showGame","/retrieveQuestion","/showFinalScore").permitAll()
	        .antMatchers("/refreshList","/questions/add","/questions").hasRole("ADMIN").and().csrf().disable()
	                .headers().frameOptions().disable();
	    }
	
	
}