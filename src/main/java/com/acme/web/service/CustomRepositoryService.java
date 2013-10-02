package com.acme.web.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.acme.web.domain.BaseDomainObject;
import com.acme.web.domain.Customer;
import com.acme.web.repository.CustomDao;

@Service
public class CustomRepositoryService {
	@Autowired
	CustomDao customDao;
	
	private static final Logger logger = LoggerFactory.getLogger(CustomRepositoryService.class);
	
	@Transactional(propagation=Propagation.REQUIRED, rollbackFor=Throwable.class)
	public void persist(BaseDomainObject baseDomainObject) {
		customDao.persist(baseDomainObject);
		//customDao.flush();
	}
	
	public void persist(Customer customer) {
		customDao.persist(customer);
	}
	
	public <T extends BaseDomainObject> T find(Class<T> domainObjectClass, Long id) {
		return customDao.find(domainObjectClass, id);
	}
}
