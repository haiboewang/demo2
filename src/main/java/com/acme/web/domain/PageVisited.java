package com.acme.web.domain;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="page_visited")
public class PageVisited extends BaseDomainObject {
	@ManyToOne
	@JoinColumn(name="visit_id", nullable=false)
	private Visit visit;
	
	@ManyToOne
	@JoinColumn(name="page_id", nullable=false)
	private Page page;

	public Visit getVisit() {
		return visit;
	}

	public void setVisit(Visit visit) {
		this.visit = visit;
	}

	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}
}
