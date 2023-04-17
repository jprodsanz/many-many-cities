package com.pablox.citystatespart2.repositories;

import com.pablox.citystatespart2.models.State;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StateRepo extends CrudRepository <State, Long> {
    List<State> findAll();

    
}
