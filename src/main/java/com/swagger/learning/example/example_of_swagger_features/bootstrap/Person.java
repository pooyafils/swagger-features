package com.swagger.learning.example.example_of_swagger_features.bootstrap;

import com.swagger.learning.example.example_of_swagger_features.model.PersonInfo;
import com.swagger.learning.example.example_of_swagger_features.repository.PersonRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Person implements CommandLineRunner {
    private final PersonRepository personRepository;

    public Person(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public void run(String... args) throws Exception {
loadPerson();
    }
    private void loadPerson(){
        PersonInfo personone=new PersonInfo();
        personone.setId(1);
        personone.setName("pooya");
        personone.setFamilyName("files");
personRepository.save(personone);
        PersonInfo persontwo=new PersonInfo();
        persontwo.setId(2);
        persontwo.setName("jhon");
        persontwo.setFamilyName("spring");
        personRepository.save(persontwo);
        System.out.println(personRepository.count());
    }
}
