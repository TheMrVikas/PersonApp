package com.person.mapper;

import com.person.dto.Person;
import com.person.entity.PersonEntity;

public interface EntityToDtoMaper {
    Person personEntityToDTO(PersonEntity entity);
}
