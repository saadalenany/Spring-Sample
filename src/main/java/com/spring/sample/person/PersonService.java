package com.spring.sample.person;

public interface PersonService {

    Iterable<Person> listAllPersons();

    Person getPersonById(Integer id);

    Person savePerson(Person person);

    void deletePerson(Integer id);

}
