package com.acme.web.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.acme.web.domain.Customer;
import com.acme.web.domain.Page;

@Repository("customerRepository")
public interface PageRepository extends JpaRepository<Page, Long>{
	public Customer findById(Long id);
	public List<Page> findAll();
	public Page findByName(String name);

}
