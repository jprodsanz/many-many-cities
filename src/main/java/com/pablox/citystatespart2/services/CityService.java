package com.pablox.citystatespart2.services;

import com.pablox.citystatespart2.models.City;
import com.pablox.citystatespart2.repositories.CityRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CityService {
    @Autowired
    private CityRepo repo;

    // create or update method
    public City createOrUpdate(City c) {
        return repo.save(c);
    }

    // Get One
    public City getOne(Long id) {
        Optional<City> c = repo.findById(id);

        if (c.isPresent()) {
            return c.get();
        } else {
            return null;
        }
    }

    public List<City> getAll() {
        return repo.findAll();
    }

    public boolean deleteOne(Long id) {
        Optional<City> i = repo.findById(id);
        if (i.isPresent()) {
            repo.delete(i.get());
            return true;
        } else {
            return false;
        }
    }
}
