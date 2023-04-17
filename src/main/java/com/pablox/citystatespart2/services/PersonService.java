package com.pablox.citystatespart2.services;


import com.pablox.citystatespart2.models.Person;
import com.pablox.citystatespart2.repositories.PersonRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonService {
    @Autowired
    private PersonRepo repo;

    // create or update method
    public Person createOrUpdate(Person p) {
        return repo.save(p);
    }

    // Get One
    public Person getOne(Long id) {
        Optional<Person> p = repo.findById(id);

        if (p.isPresent()) {
            return p.get();
        } else {
            return null;
        }
    }

    public List<Person> getAll() {
        return repo.findAll();
    }

    public boolean deleteOne(Long id) {
        Optional<Person> i = repo.findById(id);
        if (i.isPresent()) {
            repo.delete(i.get());
            return true;
        } else {
            return false;
        }
    }
}
