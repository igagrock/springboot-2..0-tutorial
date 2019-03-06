package com.initgrep.springit.auth;

import org.springframework.boot.actuate.autoconfigure.security.servlet.EndpointRequest;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import com.initgrep.springit.user.UserDetailsServiceImpl;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration  extends WebSecurityConfigurerAdapter{
	
    private UserDetailsServiceImpl userDetailsService;
    
  
	public SecurityConfiguration(UserDetailsServiceImpl userDetailsService) {
      super();
      this.userDetailsService = userDetailsService;
    }

  @Override
	protected void configure(HttpSecurity http) throws Exception {

    http
    .authorizeRequests()
        .requestMatchers(EndpointRequest.to("info")).permitAll()
        .requestMatchers(EndpointRequest.toAnyEndpoint()).hasRole("ADMIN")
        .antMatchers("/actuator/").hasRole("ACTUATOR")
        .antMatchers("/").permitAll()
        .antMatchers("/link/submit").hasRole("USER")
        .antMatchers("/h2/**").permitAll()
        .and()
    .formLogin()
    .loginPage("/login").permitAll()
    .usernameParameter("email")
    .and()
    .logout()
    .and()
    .rememberMe()
    ;
    
//    .and()
//    .csrf().disable()
//    .headers().frameOptions().disable();
	
  }
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	  auth.userDetailsService(userDetailsService);
	}
	
}
