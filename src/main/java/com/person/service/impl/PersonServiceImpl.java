package com.person.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.person.dto.Person;
import com.person.entity.PersonEntity;
import com.person.mapper.DtoToEntityMapper;
import com.person.mapper.EntityToDtoMaper;
import com.person.repository.PersonRepository;
import com.person.service.PersonService;
@Service
public class PersonServiceImpl implements PersonService {

	@Autowired
	private PersonRepository personRepository;
	
	@Autowired
	private DtoToEntityMapper dtoToEntityMapper;
	
	@Autowired
	private EntityToDtoMaper entityToDtoMaper;
	
	@Override
	public PersonEntity isPersonSave(Person person) {
		PersonEntity entity = dtoToEntityMapper.personDtoToEntityMapper(person);
		return personRepository.save(entity);
	}

	@Override
	public PersonEntity isPersonUpdate(Person person) {
		return this.isPersonSave(person);
	}

	@Override
	public Person getPersonById(Integer id) {
		Person person=new Person();
		Optional<PersonEntity> personRecord = personRepository.findById(id);
		if(personRecord.isPresent()) {
			PersonEntity personEntity = personRecord.get();
			person = entityToDtoMaper.personEntityToDTO(personEntity);
		}
		return person;
	}

	@Override
	public List<Person> getAllPerson() {
		List<Person> personList=new ArrayList<Person>();
		List<PersonEntity> listOfEntities = personRepository.findAll();
		listOfEntities.forEach(entity->{
			//create the object of person class
			Person person=new Person();
			person = entityToDtoMaper.personEntityToDTO(entity);
			//BeanUtils.copyProperties(entity, person);
			personList.add(person);
		});
		return personList;
	}

	@Override
	public boolean isPersonDelete(Integer Id) {
		personRepository.deleteById(Id);
		return Boolean.TRUE;
	}
}
