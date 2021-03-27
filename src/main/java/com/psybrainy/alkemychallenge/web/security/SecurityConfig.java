package com.psybrainy.alkemychallenge.web.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.psybrainy.alkemychallenge.domain.service.UserSevice;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
    private BCryptPasswordEncoder encoder;
	
	@Autowired
    private UserSevice user;
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(user)
		.passwordEncoder(encoder);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.authorizeRequests()
		.antMatchers("/index", "/home", "/", "/views/registration/**" ,"/css/**","/js/**").permitAll()
		.antMatchers("/views/course/").hasAnyRole("ADMIN")
		.antMatchers("/views/course/create/").hasAnyRole("ADMIN")
		.antMatchers("/views/course/save/").hasAnyRole("ADMIN")
		.antMatchers("/views/course/edit/").hasAnyRole("ADMIN")
		.antMatchers("/views/course/delete/").hasAnyRole("ADMIN")
		.antMatchers("/views/professor/").hasAnyRole("ADMIN")
		.antMatchers("/views/professor/create/").hasAnyRole("ADMIN")
		.antMatchers("/views/professor/save/").hasAnyRole("ADMIN")
		.antMatchers("/views/professor/edit/").hasAnyRole("ADMIN")
		.antMatchers("/views/professor/delete/").hasAnyRole("ADMIN")
		.anyRequest().authenticated()
		.and()
		.formLogin().permitAll()
		.and()
		.logout().permitAll();
	}
}
