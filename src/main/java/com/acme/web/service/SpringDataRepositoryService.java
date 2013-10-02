package com.acme.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.acme.web.domain.CityStateZip;
import com.acme.web.domain.Page;
import com.acme.web.repository.CityStateZipRepository;
import com.acme.web.repository.PageRepository;

@Service
public class SpringDataRepositoryService {

	@Autowired
	PageRepository pageRepository;
	
	@Autowired
	CityStateZipRepository cityStateZipRepository;
	
	@Transactional(propagation=Propagation.REQUIRED, rollbackFor=Throwable.class)
	public Page findPageByName(String name) {
		return pageRepository.findByName(name);
	}
	
	@Transactional(propagation=Propagation.REQUIRED, rollbackFor=Throwable.class)
	public List<CityStateZip> findCityStateZipByZipCode(String zip) {
		return cityStateZipRepository.findByZip(zip);
	}
	
	public CityStateZip findCityStateZipById(Long id) {
		return cityStateZipRepository.findById(id);
	}

}
