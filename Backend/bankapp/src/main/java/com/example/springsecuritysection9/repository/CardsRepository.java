package com.example.springsecuritysection9.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.springsecuritysection9.model.Cards;

@Repository
public interface CardsRepository extends JpaRepository<Cards, Long> {

	List<Cards> findByCustomerId(int customerId);;
}
