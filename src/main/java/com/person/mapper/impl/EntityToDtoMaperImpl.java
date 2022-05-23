package com.person.mapper.impl;

import org.springframework.stereotype.Service;

import com.person.dto.Person;
import com.person.entity.PersonEntity;
import com.person.mapper.EntityToDtoMaper;

@Service
public class EntityToDtoMaperImpl implements EntityToDtoMaper{

	@Override
	public Person personEntityToDTO(PersonEntity entity) {
		Person person=new Person();
		person.setPersonId(entity.getPersionId());
		person.setFirstname(entity.getFirstname());
		person.setMiddleName(entity.getMiddleName());
		person.setLastName(entity.getLastName());
		person.setMobileNumber(entity.getMobileNumber());
		person.setAdharNumber(entity.getAdharNumber());
		person.setDateOfBirth(entity.getDateOfBirth());
		person.setDistric(entity.getDistric());
		person.setState(entity.getState());
		person.setZipCode(entity.getZipCode());
		
		return person;
	}

}
