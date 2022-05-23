package com.person.mapper.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.person.dto.Person;
import com.person.entity.PersonEntity;
import com.person.mapper.DtoToEntityMapper;
@Service
public class DtoToEntityMapperImpl implements DtoToEntityMapper {

	@Override
	public PersonEntity personDtoToEntityMapper(Person person) {
		//create the object of PersonEntity class
		PersonEntity entity=new PersonEntity();
		entity.setPersionId(person.getPersonId());
		BeanUtils.copyProperties(person, entity);
		entity.setCreatedby(person.getFirstname());
		return entity;
	}

}
