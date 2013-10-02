package com.acme.web.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.acme.web.domain.Customer;

@Repository("customerRepository")
public interface CustomerRepository extends JpaRepository<Customer, Long>{
	@SuppressWarnings("unchecked")
	public Customer save(Customer customer);
	public Customer findById(Long id);
	public List<Customer> findAll();
	public List<Customer> findByLastName(String lastName);
	public List<Customer> findByFirstNameOrLastName(String firstName, String lastName);

}
