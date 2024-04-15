package com.example.springsecuritysection9.controller;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.CacheControl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springsecuritysection9.model.Notice;
import com.example.springsecuritysection9.repository.NoticeRepository;

@RestController
public class NoticesController {
	
	@Autowired
	private NoticeRepository theNoticeRepository;

	@GetMapping("/notices")
	public ResponseEntity<List<Notice>> getNoticesDetails() {

		List<Notice> notices = theNoticeRepository.findAllActiveNotices();
		
		if(notices != null) {
			return ResponseEntity.ok()
					// it means if a user refreshes the page within 60 seconds after loading the data
					// the REST API call will not happen from the UI Application rather 
					// it will use the notices details which it has already has inside the cache
					.cacheControl(CacheControl.maxAge(60, TimeUnit.SECONDS))
					.body(notices);
		} else {
			return null;
		}
	}
}
