package com.acme.web.repository;

import java.util.List;

import javax.persistence.QueryHint;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.acme.web.domain.CityStateZip;
import com.acme.web.domain.Customer;

@Repository("cityStateZipRepository")
public interface CityStateZipRepository extends JpaRepository<CityStateZip, Long>{
	@SuppressWarnings("unchecked")
	public CityStateZip save(CityStateZip cityStateZip);
	public CityStateZip findById(Long id);
	public List<CityStateZip> findByZip(String zip);
	@Query("select cityStateZip from CityStateZip cityStateZip where cityStateZip.zip like :zip")
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	public List<CityStateZip> findByZipLike(@Param("zip") String zip);
	//public List<CityStateZip> findByZipLike(String zip);
	public Page<CityStateZip> findByZipLike(String zip, Pageable pageable);
	public void delete(Long id);
	public void delete(CityStateZip cityStateZip);

}
