package com.swagger.learning.example.example_of_swagger_features.controller;

import com.swagger.learning.example.example_of_swagger_features.model.PersonInfo;
import com.swagger.learning.example.example_of_swagger_features.repository.PersonRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

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

    public  ResponseEntity savePersonInfo(@Valid @RequestBody PersonInfo personInfo, BindingResult bindingResult){
        System.out.println(bindingResult.hasErrors()+"error field");
        if (bindingResult.hasErrors()){
            return ResponseEntity.ok(bindingResult.getFieldError());
        }
        else {
        //  return ResponseEntity.ok(personRepository.save(personInfo));
            personRepository.save(personInfo);
            return ResponseEntity.ok(personRepository.findAll());

        }

    }
    @DeleteMapping("/{id}")
    public ResponseEntity deletePerson(@PathVariable int id){
        PersonInfo delete=personRepository.findById(id);
        personRepository.delete(delete);
        return ResponseEntity.ok(personRepository.findAll());
    }
    @PutMapping("/{id}")
public ResponseEntity edit(@PathVariable int id,@RequestBody PersonInfo personInfo){
        PersonInfo personInfo1=personRepository.findById(id);
        personInfo1.setName(personInfo.getName());
        personRepository.save(personInfo1);
        return ResponseEntity.ok(personRepository.findAll());

}
}
