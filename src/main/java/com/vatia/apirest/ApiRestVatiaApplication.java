package com.vatia.apirest;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import com.vatia.apirest.security.JWTAuthorizationFilter;



@SpringBootApplication
public class ApiRestVatiaApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiRestVatiaApplication.class, args);
	}

	@EnableWebSecurity
	@Configuration
	class WebSecurityConfig extends WebSecurityConfigurerAdapter {
 
		@Override
		protected void configure(HttpSecurity http) throws Exception {
			http.csrf().disable().cors().and()
					.addFilterAfter(new JWTAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class)
					.authorizeRequests().antMatchers(HttpMethod.POST, "/v1/auth").permitAll().anyRequest()
					.authenticated();
		}

	}
	
}
