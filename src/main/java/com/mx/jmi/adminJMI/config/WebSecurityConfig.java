package com.mx.jmi.adminJMI.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import com.mx.jmi.adminJMI.services.UserDetailsServiceImpl;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {	

	//String[] resources = new String[] { "/include/**", "/assets/**", "/css/**", "/icons/**", "/img/**", "/js/**","/map/**","/gif/**", "/layer/**", "/dist/**","/images/**","/" };
	String[] resources = new String[]{"/include/**", "/dist/**", "/build/**", "/plugins/**","/css/**","/icons/**","/img/**","/js/**","/layer/**"};

	BCryptPasswordEncoder bCryptPasswordEncoder;
	
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
	        .antMatchers(resources).permitAll()  
	        .antMatchers("/").permitAll()
	        .antMatchers("/products*").access("hasRole('USER') or hasRole('ADMIN')")
	        .antMatchers("/categories*").access("hasRole('USER') or hasRole('ADMIN')")
                .anyRequest().authenticated()
                .and()
            .formLogin()
                .loginPage("/login")
                .permitAll()
                .defaultSuccessUrl("/categories")
                .failureUrl("/login?error=true")
                .usernameParameter("username")
                .passwordParameter("password")
                .and()
            .logout()
                .permitAll()
                .logoutSuccessUrl("/login");
    }
    
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
		bCryptPasswordEncoder = new BCryptPasswordEncoder(4); 
		return bCryptPasswordEncoder;
    }
	
    @Autowired
    UserDetailsServiceImpl userDetailsService;
	
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {  
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());     
    }

}
