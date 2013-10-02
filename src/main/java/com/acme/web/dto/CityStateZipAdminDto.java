package com.acme.web.dto;

import java.util.ArrayList;
import java.util.List;

import com.acme.web.domain.CityStateZip;

public class CityStateZipAdminDto {
	private String message;
	private String zip;
	private List<CityStateZip> cityStateZipList = new ArrayList<>();
	int pageSize = 10;
	int pageNumber = 0;
	int pageCount = 0;
	int recordCount = 0;
	Long id;
	String action;
	
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	public List<CityStateZip> getCityStateZipList() {
		return cityStateZipList;
	}
	public void setCityStateZipList(List<CityStateZip> cityStateZipList) {
		this.cityStateZipList = cityStateZipList;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getPageNumber() {
		return pageNumber;
	}
	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}
	public int getPageCount() {
		return pageCount;
	}
	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}
	public int getRecordCount() {
		return recordCount;
	}
	public void setRecordCount(int recordCount) {
		this.recordCount = recordCount;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}

}
