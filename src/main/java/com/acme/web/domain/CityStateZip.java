package com.acme.web.domain;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name="city_state_zip")
@Cacheable(true)
@Cache(usage=CacheConcurrencyStrategy.READ_WRITE /*allow write so that they can be edited/deleted in the admin section */, region="com.acme.web.domain.CityStateZip")
public class CityStateZip extends BaseDomainObject {
	private String city;

	private String state;
	@Column(name="state_name")
	private String stateName;
	private String zip;
	
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	public String getStateName() {
		return stateName;
	}
	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

}
