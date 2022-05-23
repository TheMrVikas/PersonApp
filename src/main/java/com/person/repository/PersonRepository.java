package com.person.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.person.entity.PersonEntity;

public interface PersonRepository extends JpaRepository<PersonEntity, Serializable>{

}
        