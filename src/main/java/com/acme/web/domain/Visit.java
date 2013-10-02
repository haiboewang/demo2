package com.acme.web.domain;

import java.sql.Timestamp;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Visit extends BaseDomainObject {
	@ManyToOne
	@JoinColumn(name="visitor_id", nullable=false)
	private Visitor visitor;
	
	@OneToMany
	@JoinColumn(name="visitor_id")
	private Set<PageVisited> visitHistories;
	
	@Column(name="start_dt", nullable=false)
	private Timestamp startDateTime;
	
	@Column(name="end_dt", nullable=true)
	private Timestamp endDateTime;	

	public Visitor getVisitor() {
		return visitor;
	}

	public void setVisitor(Visitor visitor) {
		this.visitor = visitor;
	}

	public Timestamp getStartDateTime() {
		return startDateTime;
	}

	public void setStartDateTime(Timestamp startDateTime) {
		this.startDateTime = startDateTime;
	}

	public Timestamp getEndDateTime() {
		return endDateTime;
	}

	public void setEndDateTime(Timestamp endDateTime) {
		this.endDateTime = endDateTime;
	}
}
