package com.example.springsecuritysection9.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.springsecuritysection9.model.Accounts;

@Repository
public interface AccountRepository extends JpaRepository<Accounts, Long>{
	
	Accounts findByCustomerId(int customerId);

}
