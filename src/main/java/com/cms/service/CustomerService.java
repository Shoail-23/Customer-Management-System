package com.cms.service;

import com.cms.entity.Customer;

public interface CustomerService {
	boolean validate(Customer cus);
	String addUser(Customer cus);
}