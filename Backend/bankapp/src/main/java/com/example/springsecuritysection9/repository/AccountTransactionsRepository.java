package com.example.springsecuritysection9.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.springsecuritysection9.model.AccountTransactions;

@Repository
public interface AccountTransactionsRepository extends JpaRepository<AccountTransactions, Long>{
	
	List<AccountTransactions> findByCustomerIdOrderByTransactionDtDesc(int customerId);

}
