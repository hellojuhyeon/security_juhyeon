package com.study.security_juhyeon.service.auth;

import com.study.security_juhyeon.web.dto.UsernameCheckReqDto;

public interface AuthService {
	public boolean checkUsername(UsernameCheckReqDto usernameCheckReqDto) throws Exception;
	public boolean signup() throws Exception;
}
