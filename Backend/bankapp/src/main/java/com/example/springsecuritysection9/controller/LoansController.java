package com.example.springsecuritysection9.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.springsecuritysection9.model.Loans;
import com.example.springsecuritysection9.repository.LoanRepository;

@RestController
public class LoansController {
	
	@Autowired
	private LoanRepository theLoanRepository;

	@GetMapping("/myLoans")
	public List<Loans> getLoansDetails(@RequestParam int id) {
		List<Loans> loans = theLoanRepository.findByCustomerIdOrderByStartDtDesc(id);
		
		if(loans != null) {
			return loans;
		} else {
			return null;
		}
	}
}
