package com.cms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cms.entity.Customer;

public interface CustomerRepository 
	extends JpaRepository<Customer, Long>{
Customer findByUsername(String uName);
}