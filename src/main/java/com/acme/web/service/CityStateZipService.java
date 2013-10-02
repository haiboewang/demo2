package com.acme.web.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.acme.web.domain.CityStateZip;

public interface CityStateZipService {

	public abstract CityStateZip save(CityStateZip cityStateZip);

	public abstract void delete(CityStateZip cityStateZip);

	public abstract void delete(Long id);

	public abstract List<CityStateZip> findCityStateZipByZipCode(String zip);

	public abstract List<CityStateZip> findCityStateZipByZipCodeLike(String zip);

	public abstract Page<CityStateZip> findCityStateZipByZipCodeLike(
			String zip, Pageable pageable);

	public abstract CityStateZip findCityStateZipById(Long id);

}