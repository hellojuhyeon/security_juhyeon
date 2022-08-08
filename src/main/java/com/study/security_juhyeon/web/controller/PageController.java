package com.study.security_juhyeon.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {
	
	@GetMapping({"/","index"})
	public String loadIndex() {
		return "index";
	}
	
	@GetMapping("/auth/signin")
	public String loadSignIn() {
		return "auth/signin";
	}
	
	@GetMapping("/auth/signup")
	public String loadSignUp() {
		return "auth/signup";
	}
	@GetMapping("/mypage")
	public String loadMyPage() {
		return "mypage";
	}
}
