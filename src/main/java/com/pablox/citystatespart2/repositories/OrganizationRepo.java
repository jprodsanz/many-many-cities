package com.pablox.citystatespart2.repositories;

import com.pablox.citystatespart2.models.Organization;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrganizationRepo extends CrudRepository <Organization, Long> {
    List<Organization> findAll();


}
