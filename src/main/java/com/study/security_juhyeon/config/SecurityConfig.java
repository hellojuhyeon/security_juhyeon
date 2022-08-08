package com.study.security_juhyeon.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity //필수!기존의 WebSecurityConfigurerAdapter을 비활성 시키고 현재 시큐리티 패턴을 따르겠다는 내용 "내 좆대로 한다"
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter{

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable();//<=이거 안하면 나중에 문제생김
	}
}
