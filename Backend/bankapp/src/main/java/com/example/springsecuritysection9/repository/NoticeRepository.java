package com.example.springsecuritysection9.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.springsecuritysection9.model.Notice;

@Repository
public interface NoticeRepository extends JpaRepository<Notice, Long> {

	@Query(value="from Notice n where CURDATE() BETWEEN noticBegDt and noticEndDt")
	List<Notice> findAllActiveNotices();
}
