package com.swagger.learning.example.example_of_swagger_features.controller;

import com.swagger.learning.example.example_of_swagger_features.model.PersonInfo;
import com.swagger.learning.example.example_of_swagger_features.repository.PersonRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Api( description = "this is person-info")
@RestController
@RequestMapping("/person")
public class PersonController {
PersonRepository personRepository;

    public PersonController(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @ApiOperation(value = "this is method for getting person-info")
    @GetMapping
    public ResponseEntity getAllPersons() {
        return ResponseEntity.ok(personRepository.findAll());
    }
    @ApiOperation(value = "getting person-info by id")
    @GetMapping("/{id}")
    public ResponseEntity getPersonById (@PathVariable int id){
        return  ResponseEntity.ok(personRepository.findById(id));
    }
    @ApiOperation(value = "save student info")
    @PostMapping
    public  ResponseEntity savePersonInfo(@RequestBody PersonInfo personInfo){
        return ResponseEntity.ok(personRepository.save(personInfo));
    }
}
