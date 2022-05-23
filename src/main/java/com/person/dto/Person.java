package com.person.dto;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

/**
 * @author vikas yadav
 * @version 1.0, May 21,2022
 * @since JDK11
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Person {
	private Integer personId;
	private String firstname;
	private String middleName;
	private String lastName;
	private String mobileNumber;
	private String adharNumber;
	private Date dateOfBirth;
	private String state;
	private String distric;
	private Long zipCode;
}
