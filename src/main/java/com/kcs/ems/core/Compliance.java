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
public class Compliance {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cid")
	private Long complianceId;

	@Column(name = "RLTYPE")
	private String rlType;

	@Column(name = "DETAILS")
	private String details;

	@Column(name = "CREATEDATE")
	private String createdDate;

	@ManyToOne
	@JoinColumn(name = "department_id")
	private Department department;

}
