package com.study.security_juhyeon.domain.user;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserRepository {
	public int save(User user) throws Exception;
	public User findUserByUsername(String username) throws Exception;
	public User findOauth2UserByUsername(String oauth2_id) throws Exception;
}
