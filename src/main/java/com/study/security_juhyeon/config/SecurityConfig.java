package com.study.security_juhyeon.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.study.security_juhyeon.config.auth.AuthFailUreHandler;
import com.study.security_juhyeon.service.auth.PrincipalOauth2UserService;

import lombok.RequiredArgsConstructor;



@EnableWebSecurity //필수!기존의 WebSecurityConfigurerAdapter을 비활성 시키고 현재 시큐리티 패턴을 따르겠다는 내용 "내 좆대로 한다"
@Configuration
@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	private final PrincipalOauth2UserService principalOauth2UserService;
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable();					//<=이거 안하면 나중에 문제생김
		http.authorizeRequests()
			.antMatchers("/api/v1/grant/tert/user/**")
			.access("hasRole('ROLE_USER') or hasRole('ROLE_MANAGER') or hasRole('ROLE_ADMIN')")
			
			.antMatchers("/api/v1/grant/tert/user/**")
			.access("hasRole('ROLE_MANAGER') or hasRole('ROLE_ADMIN')")
			
			.antMatchers("/api/v1/grant/tert/user/**")
			.access("hasRole('ROLE_ADMIN')")
			
			.antMatchers("/","/index","/mypage/**")			//우리가 지정한 요청
			.authenticated()					//인증을 거쳐라
			.anyRequest()						//다른 모든 요청은
			.permitAll()						//모두 접근 권한을 허용한다
			.and()
			.formLogin()						//로그인방식은 form로그인을 사용한다
			.loginPage("/auth/signin")			//로그인 페이지는 해당 get요청을 통해 접근한다.
			.loginProcessingUrl("/auth/signin")	//로그인 요청(post요청)
			.failureHandler(new AuthFailUreHandler())
			
		
			.and()
			
			.oauth2Login()
			.userInfoEndpoint()
			.userService(principalOauth2UserService)
			
			
			.and()
			
			.defaultSuccessUrl("/index");
			
			
			;
	}
}
