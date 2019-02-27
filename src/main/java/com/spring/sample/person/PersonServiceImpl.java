package com.spring.sample.person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonRepository personRepository;

    @Override
    public Iterable<Person> listAllPersons() {
        return personRepository.findAll();
    }

    @Override
    public Person getPersonById(Integer id) {
        System.out.println("PersonID "+id);
        return personRepository.findById(id).orElseThrow(() -> new RuntimeException("No data!"));
    }

    @Override
    public Person savePerson(Person person) {
        System.out.println(person.toString());
        return personRepository.save(person);
    }

    @Override
    public void deletePerson(Integer id) {
        System.out.println("PersonID "+id);
        personRepository.deleteById(id);
    }
}
