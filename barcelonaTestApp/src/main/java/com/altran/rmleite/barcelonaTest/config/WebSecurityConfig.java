package com.altran.rmleite.barcelonaTest.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import com.altran.rmleite.barcelonaTest.security.JwtAuthenticationEntryPoint;
import com.altran.rmleite.barcelonaTest.security.JwtAuthenticationProvider;
import com.altran.rmleite.barcelonaTest.security.JwtAuthenticationSuccessHandler;
import com.altran.rmleite.barcelonaTest.security.JwtAuthenticationTokenFilter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    JwtAuthenticationEntryPoint unauthorizedHandler;

    @Autowired
    JwtAuthenticationProvider authenticationProvider;

    @Bean
    public JwtAuthenticationTokenFilter authenticationTokenFilterBean() throws Exception {

        JwtAuthenticationTokenFilter authenticationTokenFilter = new JwtAuthenticationTokenFilter();
        authenticationTokenFilter.setAuthenticationManager(authenticationManager());
        authenticationTokenFilter.setAuthenticationSuccessHandler(new JwtAuthenticationSuccessHandler());

	    return authenticationTokenFilter;
    }

    @Override
	protected void configure(HttpSecurity httpSecurity) throws Exception {
		
	    httpSecurity
	        .csrf().disable()
	        .authorizeRequests()
	        .antMatchers("/").permitAll()
	        .antMatchers("/health").permitAll()
	        .anyRequest().authenticated()
	        .and()
	        .exceptionHandling().authenticationEntryPoint(unauthorizedHandler)
	        .and()
	        .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
	
	    httpSecurity.addFilterBefore(authenticationTokenFilterBean(), BasicAuthenticationFilter.class);
	    httpSecurity.headers().cacheControl();	
	}

}
