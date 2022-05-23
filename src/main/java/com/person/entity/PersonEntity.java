package com.person.entity;

import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "Person_Details")
public class PersonEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "Person_Id")
	private Integer persionId;

	@Column(name = "first_Name")
	private String firstname;

	@Column(name = "middle_Name")
	private String middleName;

	@Column(name = "last_Name")
	private String lastName;

	@Column(name = "mobile_Number")
	private String mobileNumber;

	@Column(name = "adhar_Number")
	private String adharNumber;

	@Column(name = "date_Of_Birth")
	private Date dateOfBirth;

	@Column(name = "state")
	private String state;

	@Column(name = "distric")
	private String distric;

	@Column(name = "zipCode")
	private Long zipCode;

	@CreationTimestamp
	@Column(name = "creationDate", updatable = false)
	private Timestamp creationDate;

	@Column(name = "updationDate",insertable = false,updatable = true)
	private Timestamp updationDate;
	
	@Column(name = "createdby")
	private String createdby;
}
