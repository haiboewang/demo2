package com.acme.web.domain;

public class State extends BaseDomainObject {
	private String name;
	private String stateCode;
	
	public State(String name, String stateCode) {
		super();
		this.name = name;
		this.stateCode = stateCode;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getStateCode() {
		return stateCode;
	}
	public void setStateCode(String stateCode) {
		this.stateCode = stateCode;
	}
	

}
