package com.example.springsecuritysection9.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.springsecuritysection9.model.Contact;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Long> {

}
