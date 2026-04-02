package com.cms.service;

import org.springframework.stereotype.Service;
import com.cms.entity.Customer;
import com.cms.repository.CustomerRepository;

@Service
public class CustomerServiceImplementation 
implements CustomerService{

	CustomerRepository cusRepo;
	
	public CustomerServiceImplementation(CustomerRepository cusRepo) {
		this.cusRepo = cusRepo;
	}

	@Override
	public boolean validate(Customer cus) {
		String dbPass = cusRepo.findById(cus.getId()).get().getPassword();
		return cus.getPassword().equals(dbPass);
	}

	@Override
	public String addUser(Customer cus) {
		String uName = cus.getUsername();
		Customer dbCus = cusRepo.findByUsername(uName);
				
		boolean exists = (dbCus != null);
		if(exists == true)
			return "user already exists";
		else {
	        cusRepo.save(cus);
		    return "user added successfully";
		}
	}

}