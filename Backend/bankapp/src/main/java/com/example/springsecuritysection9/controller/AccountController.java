package com.example.springsecuritysection9.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.springsecuritysection9.model.Accounts;
import com.example.springsecuritysection9.repository.AccountRepository;

@RestController
public class AccountController {
	
	@Autowired
	private AccountRepository theAccountRepository;

	@GetMapping("/myAccount")
	public Accounts getAccountDetails(@RequestParam int id) {
		Accounts accounts = theAccountRepository.findByCustomerId(id);
		
		if(accounts != null) {
			return accounts;
		} else {
			return null;
		}
	}
	
}
