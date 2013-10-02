package com.acme.web.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="page")
public class Page extends BaseDomainObject {

	@Column(name="name", nullable=false, unique=true)
	private String name;
	
	@Column(name="description")
	private String description;
	
	@ManyToOne
	@JoinColumn(name="page_group_id")
	private PageGroup pageGroup;
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public PageGroup getPageGroup() {
		return pageGroup;
	}

	public void setPageGroup(PageGroup pageGroup) {
		this.pageGroup = pageGroup;
	}

}
