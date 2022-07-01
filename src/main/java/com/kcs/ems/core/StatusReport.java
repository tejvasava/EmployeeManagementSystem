package com.kcs.ems.core;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;

@Entity
@Data
public class StatusReport {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long statusRptId;

	@ManyToOne
	@JoinColumn(name = "cid")
	private Compliance compliance;

	@ManyToOne
	@JoinColumn(name = "eid")
	private Employees employees;

	@Column(name = "COMMENTS")
	private String comments;

	@Column(name = "CREATEDATE")
	private String createdDate;

	@ManyToOne
	@JoinColumn(name = "department_id")
	private Department department;

}
