package com.acme.web.service;

import static org.junit.Assert.assertNotNull;

import java.sql.Timestamp;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.acme.web.domain.Customer;
import com.acme.web.domain.Visitor;


@RunWith(SpringJUnit4ClassRunner.class)
public class RepositoryServiceTest extends BaseServiceTest {
	@Autowired
	CustomRepositoryService repositoryService;
	
	@Test
	@Transactional
	@Rollback(false)
	public void saveCustomer() {
		Customer customer = new Customer();
		customer.setFirstName("customer");
		customer.setLastName("customer");
		repositoryService.persist(customer);
		assertNotNull(customer.getId());
	}
	
	@Test
	@Transactional
	@Rollback(false)
	public void saveVisitor() {
		Visitor visitor = new Visitor();
		repositoryService.persist(visitor);
		assertNotNull(visitor.getId());
	}

}
