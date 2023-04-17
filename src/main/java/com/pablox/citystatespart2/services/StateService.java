package com.pablox.citystatespart2.services;


import com.pablox.citystatespart2.models.State;
import com.pablox.citystatespart2.repositories.StateRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StateService {
    @Autowired
    private StateRepo repo;

    // create or update method
    public State createOrUpdate(State s) {
        return repo.save(s);
    }

    // Get One
    public State getOne(Long id) {
        Optional<State> s = repo.findById(id);

        if (s.isPresent()) {
            return s.get();
        } else {
            return null;
        }
    }

    public List<State> getAll() {
        return repo.findAll();
    }

    public boolean deleteOne(Long id) {
        Optional<State> i = repo.findById(id);
        if (i.isPresent()) {
            repo.delete(i.get());
            return true;
        } else {
            return false;
        }
    }
}
