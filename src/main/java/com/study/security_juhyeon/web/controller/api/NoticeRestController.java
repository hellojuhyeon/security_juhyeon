package com.study.security_juhyeon.web.controller.api;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.study.security_juhyeon.service.notice.NoticeService;
import com.study.security_juhyeon.web.dto.notice.AddNoticeReqDto;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/v1/notice")
@Slf4j
@RequiredArgsConstructor
public class NoticeRestController {

	private final NoticeService noticeService;
	@PostMapping("")
	public ResponseEntity<?> addNotice(AddNoticeReqDto addNoticeReqDto){
		log.info(">>>>{}",addNoticeReqDto);
		log.info(">>>>fileName: {}",addNoticeReqDto.getFile().get(0).getOriginalFilename());
		
		try {
			noticeService.addNotice(addNoticeReqDto);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return null;
	}
}
