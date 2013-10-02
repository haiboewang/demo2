package com.acme.web.service;

import static org.junit.Assert.*;

import java.util.List;

import javax.persistence.Cache;
import javax.persistence.EntityManagerFactory;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.acme.web.domain.CityStateZip;


@RunWith(SpringJUnit4ClassRunner.class)
public class CityStateZipServiceTest extends BaseServiceTest {
	@Autowired
	CityStateZipService cityStateZipService;
	
	@Autowired
	protected EntityManagerFactory entityManagerFactory;
	
	CityStateZip cityStateZipGlobal;
	
	@Before
	public void setup() {
		final Long id = 1L;
		cityStateZipGlobal = cityStateZipService.findCityStateZipById(id);
		assertNotNull(cityStateZipGlobal);
	}
	
	@Test
	public void testCache() {
		Cache cache = entityManagerFactory.getCache();
		Long id = 1L;
		cityStateZipService.findCityStateZipById(id);
		assertTrue(cache.contains(CityStateZip.class, id));
		cityStateZipService.findCityStateZipById(id);
	}
	@Test
	public void findByZip() {
		String zip = "34211";
		List<CityStateZip> cityStateZipList = cityStateZipService.findCityStateZipByZipCode(zip);
		assertNotNull(cityStateZipList);
		for(CityStateZip cityStateZip : cityStateZipList) {
			//System.out.println(cityStateZip.getCity() + ", " + cityStateZip.getState());
		}
	}
	
	@Test
	public void findByZipLike() {
		String zip = "3421";
		List<CityStateZip> cityStateZipList = cityStateZipService.findCityStateZipByZipCodeLike(zip);
		assertNotNull(cityStateZipList);
		for(CityStateZip cityStateZip : cityStateZipList) {
			System.out.println(cityStateZip.getCity() + ", " + cityStateZip.getState());
		}
	}
	
	@Test
	public void findByZipLikePagination() {
		int pageNumber = 1;
		int pageSize = 50;
		Pageable pageable = new PageRequest(pageNumber, pageSize);
		String zip = "3421";
		Page<CityStateZip> page = cityStateZipService.findCityStateZipByZipCodeLike(zip, pageable);
		assertNotNull(page);
		System.out.println(page.getTotalPages());
		for(CityStateZip cityStateZip : page.getContent()) {
			System.out.println(cityStateZip.getCity() + ", " + cityStateZip.getState());
		}
	}
	
	@Test
	public void findById() {
		CityStateZip cityState = cityStateZipService.findCityStateZipById(cityStateZipGlobal.getId());
		assertNotNull(cityState);
	}
	
	@Test
	@Transactional
	@Rollback(true)
	public void save() {
		final String dummyZip = "!!!";
		cityStateZipGlobal.setZip(dummyZip);
		cityStateZipService.save(cityStateZipGlobal);
		CityStateZip cityStateTemp = cityStateZipService.findCityStateZipById(cityStateZipGlobal.getId());
		assert(dummyZip.equals(cityStateTemp.getZip()));
	}
	
	@Test
	@Transactional
	@Rollback(true)
	public void delete() {
		cityStateZipService.delete(cityStateZipGlobal.getId());
		assertNull(cityStateZipService.findCityStateZipById(cityStateZipGlobal.getId()));
	}

}
