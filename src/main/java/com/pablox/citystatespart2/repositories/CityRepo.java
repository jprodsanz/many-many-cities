package com.pablox.citystatespart2.repositories;

import com.pablox.citystatespart2.models.City;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CityRepo extends CrudRepository <City, Long> {
    List<City> findAll();


}
