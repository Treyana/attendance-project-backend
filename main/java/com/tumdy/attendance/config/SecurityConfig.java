package com.tumdy.attendance.config;

import org.springframework.context.annotation.Bean;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.tumdy.attendance.serviceImpl.TeacherUserDetailsService;

import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class SecurityConfig {
	
	private final TeacherUserDetailsService teacherUserDetailsService;
	private final JWTAuthenticationEntryPoint authenticationEntryPoint;
	private final JwtTokenProvider jwtTokenProvider;
	
	
	private static final String[] PUBLIC_MATCHERS = {
			"/api/user/**","/api/role/**","/api/student/**","/api/accordion/**","/api/subject/**",
			"/api/email/**","/api/class/**","/api/semester/**","/api/timetable/**","/api/attendance/**",
			"/api/totaltimecount/**","/api/activity/**"
	};
	
	@Bean
	public JwtAuthenticationFilter authenticationFilter() {
		return new JwtAuthenticationFilter(jwtTokenProvider, teacherUserDetailsService);
	}
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http
			.cors().disable().csrf().disable()
			.exceptionHandling().authenticationEntryPoint(authenticationEntryPoint)
			.and()
			.headers().frameOptions().sameOrigin()
			.and()
			.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
			.and()
			.authorizeHttpRequests()
			.requestMatchers(new AntPathRequestMatcher("/h2-console/**")).permitAll()
			.requestMatchers(PUBLIC_MATCHERS).permitAll()
			.anyRequest().authenticated();
		http.authenticationProvider(daoProvider());
		http.addFilterBefore(authenticationFilter(), UsernamePasswordAuthenticationFilter.class);
		
			
		return http.build();
		
	}
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration authConfig) throws Exception {
		return authConfig.getAuthenticationManager();
	}
	
	@Bean
	public DaoAuthenticationProvider daoProvider() {
		DaoAuthenticationProvider daoProvider = new DaoAuthenticationProvider();
		daoProvider.setUserDetailsService(teacherUserDetailsService);
		daoProvider.setPasswordEncoder(passwordEncoder());
		return daoProvider;
	}
}
