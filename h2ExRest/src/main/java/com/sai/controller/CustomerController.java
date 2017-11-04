package com.sai.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sai.dao.CustomerRepository;
import com.sai.model.Customer;

@RestController
public class CustomerController {
	@Autowired
	CustomerRepository customerRepository;
	
	@RequestMapping("/Display")
	public List<Customer> display() {
		List<Customer> list = customerRepository.findAll();
		return list;
		
	}

}
