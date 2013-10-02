package com.acme.web.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="page_group")
public class PageGroup extends BaseDomainObject {
	@Column(name="name")
	private String name;
	
	@Column(name="description")
	private String description;

}
