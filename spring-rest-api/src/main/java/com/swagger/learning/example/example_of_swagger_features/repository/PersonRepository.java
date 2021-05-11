package com.swagger.learning.example.example_of_swagger_features.repository;

import com.swagger.learning.example.example_of_swagger_features.bootstrap.Person;
import com.swagger.learning.example.example_of_swagger_features.model.PersonInfo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends CrudRepository<PersonInfo,Integer> {
    PersonInfo findById(int id);

}
