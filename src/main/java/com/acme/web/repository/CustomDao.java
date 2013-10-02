package com.acme.web.repository;

import org.springframework.stereotype.Repository;

import com.acme.web.domain.Customer;

@Repository
public class CustomDao extends BaseDao {
	
	public Customer findCustomerById(Long id) {
		Customer customer = super.find(Customer.class, id);
		return customer;
	}

}
