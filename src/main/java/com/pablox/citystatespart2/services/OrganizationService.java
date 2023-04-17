package com.pablox.citystatespart2.services;


import com.pablox.citystatespart2.models.Organization;
import com.pablox.citystatespart2.repositories.OrganizationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrganizationService {
    @Autowired
    private OrganizationRepo repo;

    // create or update method
    public Organization createOrUpdate(Organization o) {
        return repo.save(o);
    }

    // Get One
    public Organization getOne(Long id) {
        Optional<Organization> o = repo.findById(id);

        if (o.isPresent()) {
            return o.get();
        } else {
            return null;
        }
    }

    public List<Organization> getAll() {
        return repo.findAll();
    }

    public boolean deleteOne(Long id) {
        Optional<Organization> i = repo.findById(id);
        if (i.isPresent()) {
            repo.delete(i.get());
            return true;
        } else {
            return false;
        }
    }
}
