package com.example.springsecuritysection9.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.springsecuritysection9.model.Cards;
import com.example.springsecuritysection9.repository.CardsRepository;



@RestController
public class CardController {
	
	@Autowired
	private CardsRepository theCardRepository;
	
	@GetMapping("/myCards")
	public List<Cards> getBalanceDetails(@RequestParam int id) {

		List<Cards> cards = theCardRepository.findByCustomerId(id);
		
		if(cards != null) {
			return cards;
		} else {
			return null;
		}
	}
}
