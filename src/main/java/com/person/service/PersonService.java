package com.person.service;

import java.util.List;

import com.person.dto.Person;
import com.person.entity.PersonEntity;

/**
 * @author vikas yadav
 * @version 1.0, May 21,2022
 * @since JDK11
 */
public interface PersonService {
	/**
	 * This method takes the person details as object and save the Data into the database 
	 * @param person
	 * @return
	 */
	public PersonEntity isPersonSave(Person person);
	public PersonEntity isPersonUpdate(Person person);
	public List<Person> getAllPerson();
	public Person getPersonById(Integer id);
	public boolean isPersonDelete(Integer Id);
}
