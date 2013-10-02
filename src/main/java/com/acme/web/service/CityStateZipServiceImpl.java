package com.acme.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.acme.web.domain.CityStateZip;
import com.acme.web.repository.CityStateZipRepository;
import com.acme.web.repository.PageRepository;

@Service
public class CityStateZipServiceImpl implements CityStateZipService {

	@Autowired
	CityStateZipRepository cityStateZipRepository;
	
	@Transactional(propagation=Propagation.REQUIRED, rollbackFor=Throwable.class)
	public CityStateZip save(CityStateZip cityStateZip) {
		return cityStateZipRepository.save(cityStateZip);
	}

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@Transactional(propagation=Propagation.REQUIRED, rollbackFor=Throwable.class)
	public void delete(CityStateZip cityStateZip) {
		cityStateZipRepository.delete(cityStateZip);
	}

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@Transactional(propagation=Propagation.REQUIRED, rollbackFor=Throwable.class)
	public void delete(Long id) {
		cityStateZipRepository.delete(id);
	}
	
	public List<CityStateZip> findCityStateZipByZipCode(String zip) {
		return cityStateZipRepository.findByZip(zip);
	}
	
	public List<CityStateZip> findCityStateZipByZipCodeLike(String zip) {
		return cityStateZipRepository.findByZipLike(zip + "%");
	}
	
	public Page<CityStateZip> findCityStateZipByZipCodeLike(String zip, Pageable pageable) {
		return cityStateZipRepository.findByZipLike(zip + "%", pageable);
	}
	
	public CityStateZip findCityStateZipById(Long id) {
		return cityStateZipRepository.findById(id);
	}

}
