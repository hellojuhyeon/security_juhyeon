package com.study.security_juhyeon.service.notice;

import com.study.security_juhyeon.web.dto.notice.AddNoticeReqDto;

public interface NoticeService {
	public int addNotice(AddNoticeReqDto addNoticeReqDto) throws Exception;
}
