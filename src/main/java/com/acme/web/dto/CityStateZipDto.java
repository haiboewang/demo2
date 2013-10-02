package com.acme.web.dto;

import java.util.List;

import com.acme.web.domain.State;

public class CityStateZipDto {
	private State state;
	private List<String> cityList;
	
	public State getState() {
		return state;
	}
	public void setState(State state) {
		this.state = state;
	}
	public List<String> getCityList() {
		return cityList;
	}
	public void setCityList(List<String> cityList) {
		this.cityList = cityList;
	}

}
