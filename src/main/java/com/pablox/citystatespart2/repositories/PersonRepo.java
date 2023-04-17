package com.pablox.citystatespart2.repositories;

import com.pablox.citystatespart2.models.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepo extends CrudRepository <Person, Long> {
    List<Person> findAll();


}
