package com.example.springsecuritysection9.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.springsecuritysection9.model.AccountTransactions;
import com.example.springsecuritysection9.repository.AccountTransactionsRepository;

@RestController
public class BalanceController {
	
	@Autowired
	private AccountTransactionsRepository theAccountTransactionsRepository;

	@GetMapping("/myBalance")
	public List<AccountTransactions> getBalanceDetails(@RequestParam int id) {

		List<AccountTransactions> transactions = theAccountTransactionsRepository
				.findByCustomerIdOrderByTransactionDtDesc(id);
		
		if(transactions != null) {
			return transactions;
		} else {
			return null;
		}
	}
}
