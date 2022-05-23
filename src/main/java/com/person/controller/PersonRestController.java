package com.person.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.person.Util.CommonMessage;
import com.person.dto.Person;
import com.person.entity.PersonEntity;
import com.person.service.PersonService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(value = "/PersonApp")
public class PersonRestController {

	@Autowired
	PersonService personService;

	@GetMapping(value = "/person", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<List<Person>> getAllPerson() {
		List<Person> listOfPerson = personService.getAllPerson();
		log.info("Person List :: {} " + listOfPerson);
		return !listOfPerson.isEmpty() ? ResponseEntity.ok(listOfPerson) : ResponseEntity.noContent().build();
	}
	
	@GetMapping(value = "/person/{Id}", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<Person> getPersonById(@PathVariable("Id") Integer id) {
		Person person = personService.getPersonById(id);
		log.info("Person :: {} " + person);
		return null!=person.getPersonId()? ResponseEntity.ok(person) : ResponseEntity.noContent().build();
	}

	@PostMapping(value = "/person", consumes = { MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE,
												 MediaType.APPLICATION_XML_VALUE })
	ResponseEntity<CommonMessage> getPersonById(@RequestBody Person person) {
		PersonEntity personSave = personService.isPersonSave(person);
		return personSave.getPersionId()!=null? ResponseEntity.ok(new CommonMessage(personSave.getPersionId(), "Record Saved successFully !!"))
				: ResponseEntity.internalServerError().build();
	}

	@PutMapping(value = "/person", consumes = { MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE,
					                            MediaType.APPLICATION_XML_VALUE })
	ResponseEntity<CommonMessage> updatePersonById(@RequestBody Person person) {
		PersonEntity personUpdate = personService.isPersonUpdate(person);
		return personUpdate.getPersionId()!=null ? ResponseEntity.ok(new CommonMessage(person.getPersonId(), "Record Update successFully !!"))
				: ResponseEntity.internalServerError().build();
	}
	
	@DeleteMapping(value = "/person/{Id}", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<CommonMessage> deletePersonById(@PathVariable("Id") Integer id) {
		boolean flag = personService.isPersonDelete(id);
		log.info("Person :: {} " + flag);
		return flag? ResponseEntity.ok(new CommonMessage(id, "Record Deleted successFully !!")) : ResponseEntity.noContent().build();
	}

}
