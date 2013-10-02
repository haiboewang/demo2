package com.acme.web.domain;

public class ContactUs extends BaseDomainObject {
	private Customer customer;
	private String category;
	private String comment;
	
	public ContactUs() {
		super();
		this.customer = new Customer();
	}

	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
}
